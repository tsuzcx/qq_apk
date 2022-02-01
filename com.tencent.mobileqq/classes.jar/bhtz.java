public class bhtz
{
  static final bhtz jdField_a_of_type_Bhtz = new bhtz(0);
  static final bhtz b = new bhtz(1);
  static final bhtz c = new bhtz(257);
  static final bhtz d = new bhtz(2);
  static final bhtz e = new bhtz(258);
  static final bhtz f = new bhtz(3);
  static final bhtz g = new bhtz(259);
  final int jdField_a_of_type_Int;
  
  public bhtz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bhtz a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bhtz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtz
 * JD-Core Version:    0.7.0.1
 */