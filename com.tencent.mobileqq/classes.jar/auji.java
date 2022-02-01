public class auji
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public auji(auix paramauix, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected auji a()
  {
    return (auji)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auji
 * JD-Core Version:    0.7.0.1
 */