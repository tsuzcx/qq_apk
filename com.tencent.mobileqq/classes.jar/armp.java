import java.util.ArrayList;

public class armp
{
  private armq jdField_a_of_type_Armq;
  private String jdField_a_of_type_JavaLangString;
  
  public armp()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Armq = new armq();
  }
  
  public armp(String paramString, armq paramarmq)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Armq = paramarmq;
  }
  
  public armq a()
  {
    return this.jdField_a_of_type_Armq;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Armq == null) || (this.jdField_a_of_type_Armq.a == null) || (this.jdField_a_of_type_Armq.a.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armp
 * JD-Core Version:    0.7.0.1
 */