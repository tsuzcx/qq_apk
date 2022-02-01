public class bcyd
{
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  bcyd(String paramString)
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
  
  int a(char paramChar)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return -3;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_JavaLangString.split("\\" + paramChar);
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
    return this.jdField_a_of_type_ArrayOfJavaLangString[0].trim();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
  
  String c()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0].trim();
  }
  
  String d()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyd
 * JD-Core Version:    0.7.0.1
 */