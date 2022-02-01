public class avpc
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public avpc(avor paramavor, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected avpc a()
  {
    return (avpc)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpc
 * JD-Core Version:    0.7.0.1
 */