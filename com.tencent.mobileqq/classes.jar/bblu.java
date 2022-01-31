public class bblu
{
  static final bblu jdField_a_of_type_Bblu = new bblu(1);
  static final bblu b = new bblu(257);
  static final bblu c = new bblu(2);
  static final bblu d = new bblu(258);
  static final bblu e = new bblu(3);
  static final bblu f = new bblu(259);
  final int jdField_a_of_type_Int;
  
  public bblu(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bblu a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_Bblu;
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
 * Qualified Name:     bblu
 * JD-Core Version:    0.7.0.1
 */