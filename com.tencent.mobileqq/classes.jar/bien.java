public final class bien
  implements Cloneable
{
  public volatile int a;
  public long a;
  public biem a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c = "";
  public String d = "";
  
  public bien()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public bien a()
  {
    try
    {
      bien localbien = (bien)super.clone();
      return localbien;
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
 * Qualified Name:     bien
 * JD-Core Version:    0.7.0.1
 */