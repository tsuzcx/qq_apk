import java.util.Arrays;

class bemk
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public bemk(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bemk)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && (bemq.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemk
 * JD-Core Version:    0.7.0.1
 */