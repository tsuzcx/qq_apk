import java.util.ArrayList;

public class anas
{
  private anat jdField_a_of_type_Anat;
  private String jdField_a_of_type_JavaLangString;
  
  public anas()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Anat = new anat();
  }
  
  public anas(String paramString, anat paramanat)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Anat = paramanat;
  }
  
  public anat a()
  {
    return this.jdField_a_of_type_Anat;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Anat == null) || (this.jdField_a_of_type_Anat.a == null) || (this.jdField_a_of_type_Anat.a.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anas
 * JD-Core Version:    0.7.0.1
 */