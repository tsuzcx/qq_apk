public final class bidw
  implements Cloneable
{
  public volatile int a;
  public long a;
  public bidv a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c = "";
  public String d = "";
  
  public bidw()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public bidw a()
  {
    try
    {
      bidw localbidw = (bidw)super.clone();
      return localbidw;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 3) || ((this.jdField_a_of_type_Int == 1) && ((this.jdField_b_of_type_Int == 1810003) || (this.jdField_b_of_type_Int == 1810004)));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int != 1810003) && (this.jdField_b_of_type_Int != 1810004);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 1) && ((this.jdField_b_of_type_Int == 1810003) || (this.jdField_b_of_type_Int == 1810004));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidw
 * JD-Core Version:    0.7.0.1
 */