public class anot
{
  public int a;
  public String a;
  public boolean a;
  
  public anot(String paramString, int paramInt)
  {
    this(paramString, paramInt, true);
  }
  
  public anot(String paramString, int paramInt, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anot
 * JD-Core Version:    0.7.0.1
 */