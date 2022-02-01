public class asak
{
  public int a;
  public String a;
  public boolean a;
  
  public asak(String paramString, int paramInt)
  {
    this(paramString, paramInt, true);
  }
  
  public asak(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ComboObject:");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString).append(',').append(this.jdField_a_of_type_Int).append(',').append(this.jdField_a_of_type_Boolean);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asak
 * JD-Core Version:    0.7.0.1
 */