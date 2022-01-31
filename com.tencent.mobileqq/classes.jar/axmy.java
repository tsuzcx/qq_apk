public class axmy
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  public String a()
  {
    if (axnf.a()) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(axmy paramaxmy)
  {
    if (paramaxmy == null) {}
    while ((this.jdField_b_of_type_Boolean != paramaxmy.jdField_b_of_type_Boolean) || (!ahiy.c(this.jdField_a_of_type_JavaLangString, paramaxmy.jdField_a_of_type_JavaLangString)) || (!ahiy.c(this.jdField_b_of_type_JavaLangString, paramaxmy.jdField_b_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "LoadOptions{isLoadLastSuccWhenFail=" + this.jdField_b_of_type_Boolean + ", old32Bit='" + this.jdField_a_of_type_JavaLangString + '\'' + ", old64Bit='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmy
 * JD-Core Version:    0.7.0.1
 */