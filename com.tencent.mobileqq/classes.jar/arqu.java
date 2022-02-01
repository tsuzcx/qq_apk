public class arqu
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  int b;
  int c = 0;
  
  public arqu(int paramInt)
  {
    this(paramInt, null);
  }
  
  public arqu(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (bgsp.a(this.jdField_a_of_type_JavaLangString)) {}
    for (boolean bool = bgsp.a(paramString); (1 != 0) && (bool); bool = this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
      return true;
    }
    return false;
  }
  
  public boolean a(arqu paramarqu)
  {
    if (paramarqu == null) {
      return false;
    }
    return a(paramarqu.jdField_a_of_type_Int, paramarqu.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqu
 * JD-Core Version:    0.7.0.1
 */