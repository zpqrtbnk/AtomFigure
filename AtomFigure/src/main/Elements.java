package main;

import javax.swing.ImageIcon;

public class Elements {

    public final int COUNT = 18;
	public final String[] SYMBOLS = new String[COUNT];
	public final byte[] ATOMIC_NUMBERS = new byte[COUNT];
	public final ImageIcon[] REPRESENTATIONS = new ImageIcon[COUNT];
	public final String[] ELEMENT_NAMES = new String[COUNT];

    public Elements() {

        createArrays();
    }

    public int getIndex(String input) {

		int inputNumber;
		try {
			inputNumber = Integer.valueOf(input);
		}
		catch (NumberFormatException e) {
			inputNumber = -1;
		}
		
        int index = 0;
		if (inputNumber >= 0) {

			// AtomID is a number, should match an atomic number
			for (byte number : ATOMIC_NUMBERS) {
				if (number == inputNumber) {
					break;
				}
				index++;
			}
		} 
		else {

			// AtomID is a string, should match a symbol
			for (String symbol : SYMBOLS) {
				if (symbol.equalsIgnoreCase(input)) {
					break;
				}
				index++;
			}
		}
		
		// element not found (all arrays have same length)
		if (index == SYMBOLS.length) {
			index = -1;
		}

        return index;
    }

    private ImageIcon getImage(String filename) {
        
        // works - but files are needed - how can we read them from the JAR?
        String path = System.getProperty("user.dir") + "/AtomFigure/" + filename;

        /*
        InputStream stream = this.getClass().getResourceAsStream("/" + filename);
        return new ImageIcon(new Image(stream));
        return new ImageIcon(stream);
        */

        return new ImageIcon(path);
    }

    private void createArrays() {
		
		// symbols
		SYMBOLS[0] = "H";
		SYMBOLS[1] = "He";
		SYMBOLS[2] = "Li";
		SYMBOLS[3] = "Be";
		SYMBOLS[4] = "B";
		SYMBOLS[5] = "C";
		SYMBOLS[6] = "N";
		SYMBOLS[7] = "O";
		SYMBOLS[8] = "F";
		SYMBOLS[9] = "Ne";
		SYMBOLS[10] = "Na";
		SYMBOLS[11] = "Mg";
		SYMBOLS[12] = "Al";
		SYMBOLS[13] = "Si";
		SYMBOLS[14] = "P";
		SYMBOLS[15] = "S";
		SYMBOLS[16] = "Cl";
		SYMBOLS[17] = "Ar";
		
		// atomic numbers
		for(int i = 0; i < 18; i++) {
			ATOMIC_NUMBERS[i] = (byte) (i+1);
		}
		
		// representations
		REPRESENTATIONS[0] = getImage("H.png");
		REPRESENTATIONS[1] = getImage("He.png");
		REPRESENTATIONS[2] = getImage("Li.png");
		REPRESENTATIONS[3] = getImage("Be.png");
		REPRESENTATIONS[4] = getImage("B.png");
		REPRESENTATIONS[5] = getImage("C.png");
		REPRESENTATIONS[6] = getImage("N.png");
		REPRESENTATIONS[7] = getImage("O.png");
		REPRESENTATIONS[8] = getImage("F.png");
		REPRESENTATIONS[9] = getImage("Ne.png");
		REPRESENTATIONS[10] = getImage("Na.png");
		REPRESENTATIONS[11] = getImage("Mg.png");
		REPRESENTATIONS[12] = getImage("src/res/Al.png");
		REPRESENTATIONS[13] = getImage("Si.png");
		REPRESENTATIONS[14] = getImage("P.png");
		REPRESENTATIONS[15] = getImage("S.png");
		REPRESENTATIONS[16] = getImage("Cl.png");
		REPRESENTATIONS[17] = getImage("Ar.png");
	
		// names
		ELEMENT_NAMES[0] = "Hydrogen";
		ELEMENT_NAMES[1] = "Helium";
		ELEMENT_NAMES[2] = "Lithium";
		ELEMENT_NAMES[3] = "Beryllium";
		ELEMENT_NAMES[4] = "Boron";
		ELEMENT_NAMES[5] = "Carbon";
		ELEMENT_NAMES[6] = "Nitrogen";
		ELEMENT_NAMES[7] = "Oxygen";
		ELEMENT_NAMES[8] = "Fluorine";
		ELEMENT_NAMES[9] = "Neon";
		ELEMENT_NAMES[10] = "Sodium";
		ELEMENT_NAMES[11] = "Magnesium";
		ELEMENT_NAMES[12] = "Aluminium";
		ELEMENT_NAMES[13] = "Silicon";
		ELEMENT_NAMES[14] = "Phosphorus";
		ELEMENT_NAMES[15] = "Sulfur";
		ELEMENT_NAMES[16] = "Chlorine";
		ELEMENT_NAMES[17] = "Argon";		
	}
}
