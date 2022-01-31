public class bgnc
{
  public static final String a;
  public int a;
  public int b;
  public String b;
  public int c = 0;
  public int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = Long.toString(1130L);
  }
  
  public bgnc()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int a(bgnc parambgnc)
  {
    int k = 1;
    bgnc localbgnc;
    if (this.jdField_a_of_type_Int > parambgnc.jdField_a_of_type_Int)
    {
      localbgnc = parambgnc;
      parambgnc = this;
    }
    for (;;)
    {
      int i;
      switch (localbgnc.jdField_a_of_type_Int)
      {
      default: 
        i = 0;
        j = 0;
        label64:
        if (j == 0) {
          break;
        }
      }
      for (int j = k;; j = 0)
      {
        k = j;
        if (i != 0) {
          k = j | 0x2;
        }
        return k;
        if (parambgnc.jdField_a_of_type_Int == 0) {
          break;
        }
        i = 1;
        j = 1;
        break label64;
        if ((parambgnc.jdField_a_of_type_Int == 1) && (localbgnc.jdField_b_of_type_Int == parambgnc.jdField_b_of_type_Int)) {
          break;
        }
        i = 1;
        j = 1;
        break label64;
        if ((parambgnc.jdField_a_of_type_Int == 2) && (localbgnc.jdField_b_of_type_JavaLangString.equals(parambgnc.jdField_b_of_type_JavaLangString))) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
        if ((parambgnc.jdField_a_of_type_Int == 3) && (localbgnc.c == parambgnc.c)) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
        if ((parambgnc.jdField_a_of_type_Int == 4) && (localbgnc.jdField_b_of_type_JavaLangString.equals(parambgnc.jdField_b_of_type_JavaLangString))) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
      }
      localbgnc = this;
    }
  }
  
  public boolean a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      return true;
      return false;
    } while (this.jdField_b_of_type_Int > 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgnc
 * JD-Core Version:    0.7.0.1
 */