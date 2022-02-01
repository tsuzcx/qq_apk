public class bamx
{
  public int a;
  public bamy a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c = "";
  
  public bamx()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Bamy == null) || (this.jdField_a_of_type_Bamy.d == 2);
  }
  
  public String toString()
  {
    return "SubtitleItem{id=" + this.jdField_a_of_type_Int + " name=" + this.jdField_b_of_type_JavaLangString + " isShow=" + this.jdField_a_of_type_Boolean + " pos=" + this.jdField_b_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamx
 * JD-Core Version:    0.7.0.1
 */