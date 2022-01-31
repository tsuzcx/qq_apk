public class bkcd
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
  
  public bkcd()
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
  
  public int a(bkcd parambkcd)
  {
    int k = 1;
    bkcd localbkcd;
    if (this.jdField_a_of_type_Int > parambkcd.jdField_a_of_type_Int)
    {
      localbkcd = parambkcd;
      parambkcd = this;
    }
    for (;;)
    {
      int i;
      switch (localbkcd.jdField_a_of_type_Int)
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
        if (parambkcd.jdField_a_of_type_Int == 0) {
          break;
        }
        i = 1;
        j = 1;
        break label64;
        if ((parambkcd.jdField_a_of_type_Int == 1) && (localbkcd.jdField_b_of_type_Int == parambkcd.jdField_b_of_type_Int)) {
          break;
        }
        i = 1;
        j = 1;
        break label64;
        if ((parambkcd.jdField_a_of_type_Int == 2) && (localbkcd.jdField_b_of_type_JavaLangString.equals(parambkcd.jdField_b_of_type_JavaLangString))) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
        if ((parambkcd.jdField_a_of_type_Int == 3) && (localbkcd.c == parambkcd.c)) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
        if ((parambkcd.jdField_a_of_type_Int == 4) && (localbkcd.jdField_b_of_type_JavaLangString.equals(parambkcd.jdField_b_of_type_JavaLangString))) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
      }
      localbkcd = this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcd
 * JD-Core Version:    0.7.0.1
 */