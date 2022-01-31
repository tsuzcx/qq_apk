public class bkzq
{
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  bkzq(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return -3;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_JavaLangString.split("\\_");
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length < 2) {
      return -2;
    }
    return 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzq
 * JD-Core Version:    0.7.0.1
 */