public class bdfi
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public bdfi(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b(int paramInt)
  {
    if (paramInt <= a()) {}
    for (boolean bool = true;; bool = false)
    {
      bdej.a(bool, new Object[] { "!(", Integer.valueOf(paramInt), " <= ", Integer.valueOf(a()), ")" });
      return;
    }
  }
  
  int a()
  {
    return this.jdField_a_of_type_JavaLangString.length() - this.jdField_a_of_type_Int;
  }
  
  String a(int paramInt)
  {
    b(paramInt);
    String str = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + paramInt);
    this.jdField_a_of_type_Int += paramInt;
    return str;
  }
  
  void a(int paramInt)
  {
    b(paramInt);
    this.jdField_a_of_type_Int += paramInt;
  }
  
  String b(int paramInt)
  {
    b(paramInt);
    return this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfi
 * JD-Core Version:    0.7.0.1
 */