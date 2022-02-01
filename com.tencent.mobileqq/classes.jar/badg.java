public class badg
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  public int c;
  public int d;
  
  public badg(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public badg a()
  {
    return (badg)super.clone();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int + " failCount:" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badg
 * JD-Core Version:    0.7.0.1
 */