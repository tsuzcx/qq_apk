public class bdko
{
  static final bdko jdField_a_of_type_Bdko = new bdko(0);
  static final bdko b = new bdko(1);
  static final bdko c = new bdko(257);
  static final bdko d = new bdko(2);
  static final bdko e = new bdko(258);
  static final bdko f = new bdko(3);
  static final bdko g = new bdko(259);
  final int jdField_a_of_type_Int;
  
  public bdko(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bdko a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bdko;
    case 1: 
      return b;
    case 2: 
      return d;
    case 3: 
      return f;
    case 257: 
      return c;
    case 258: 
      return e;
    }
    return g;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int & 0xF) == 1;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int & 0xF) == 3;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int > 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdko
 * JD-Core Version:    0.7.0.1
 */