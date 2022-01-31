public class bdox
{
  static final bdox jdField_a_of_type_Bdox = new bdox(0);
  static final bdox b = new bdox(1);
  static final bdox c = new bdox(257);
  static final bdox d = new bdox(2);
  static final bdox e = new bdox(258);
  static final bdox f = new bdox(3);
  static final bdox g = new bdox(259);
  final int jdField_a_of_type_Int;
  
  public bdox(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bdox a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bdox;
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
 * Qualified Name:     bdox
 * JD-Core Version:    0.7.0.1
 */