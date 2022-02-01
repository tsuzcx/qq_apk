public class bgao
{
  static final bgao jdField_a_of_type_Bgao = new bgao(0);
  static final bgao b = new bgao(1);
  static final bgao c = new bgao(257);
  static final bgao d = new bgao(2);
  static final bgao e = new bgao(258);
  static final bgao f = new bgao(3);
  static final bgao g = new bgao(259);
  final int jdField_a_of_type_Int;
  
  public bgao(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bgao a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bgao;
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
 * Qualified Name:     bgao
 * JD-Core Version:    0.7.0.1
 */