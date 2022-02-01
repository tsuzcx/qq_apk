import java.util.Arrays;

class belq
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public belq(int paramInt1, int paramInt2, String paramString)
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
      paramObject = (belq)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && (belw.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belq
 * JD-Core Version:    0.7.0.1
 */