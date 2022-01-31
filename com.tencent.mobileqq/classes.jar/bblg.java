public class bblg
{
  static final bblg jdField_a_of_type_Bblg = new bblg(1);
  static final bblg b = new bblg(257);
  static final bblg c = new bblg(2);
  static final bblg d = new bblg(258);
  static final bblg e = new bblg(3);
  static final bblg f = new bblg(259);
  final int jdField_a_of_type_Int;
  
  public bblg(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bblg a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bblg;
    case 2: 
      return c;
    case 3: 
      return e;
    case 257: 
      return b;
    case 258: 
      return d;
    }
    return f;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int & 0xF) == 1;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int & 0xF) == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblg
 * JD-Core Version:    0.7.0.1
 */