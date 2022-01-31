public final class aqle
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString = "word";
  private int c = 1;
  
  public aqle(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("(" + this.jdField_a_of_type_JavaLangString + "," + this.jdField_a_of_type_Int + "," + this.jdField_b_of_type_Int);
    if (!this.jdField_b_of_type_JavaLangString.equals("word")) {
      localStringBuffer.append(",type=" + this.jdField_b_of_type_JavaLangString);
    }
    if (this.c != 1) {
      localStringBuffer.append(",posIncr=" + this.c);
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqle
 * JD-Core Version:    0.7.0.1
 */