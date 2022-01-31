public class arca
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public arca(arbp paramarbp, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected arca a()
  {
    return (arca)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arca
 * JD-Core Version:    0.7.0.1
 */