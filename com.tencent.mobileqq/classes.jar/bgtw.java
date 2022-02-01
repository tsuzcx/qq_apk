public class bgtw
{
  static final bgtw jdField_a_of_type_Bgtw = new bgtw(0);
  static final bgtw b = new bgtw(1);
  static final bgtw c = new bgtw(257);
  static final bgtw d = new bgtw(2);
  static final bgtw e = new bgtw(258);
  static final bgtw f = new bgtw(3);
  static final bgtw g = new bgtw(259);
  final int jdField_a_of_type_Int;
  
  public bgtw(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bgtw a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bgtw;
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
 * Qualified Name:     bgtw
 * JD-Core Version:    0.7.0.1
 */