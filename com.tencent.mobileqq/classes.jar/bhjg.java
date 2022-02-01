public class bhjg
{
  static final bhjg jdField_a_of_type_Bhjg = new bhjg(0);
  static final bhjg b = new bhjg(1);
  static final bhjg c = new bhjg(257);
  static final bhjg d = new bhjg(2);
  static final bhjg e = new bhjg(258);
  static final bhjg f = new bhjg(3);
  static final bhjg g = new bhjg(259);
  final int jdField_a_of_type_Int;
  
  public bhjg(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bhjg a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bhjg;
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
 * Qualified Name:     bhjg
 * JD-Core Version:    0.7.0.1
 */