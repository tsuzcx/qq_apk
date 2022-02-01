public class asgx
{
  public int a;
  public String a;
  
  public asgx(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.startsWith("[")) && (this.jdField_a_of_type_JavaLangString.endsWith("]"))) {
      return this.jdField_a_of_type_JavaLangString.substring(1, this.jdField_a_of_type_JavaLangString.length() - 1);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return "" + this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgx
 * JD-Core Version:    0.7.0.1
 */