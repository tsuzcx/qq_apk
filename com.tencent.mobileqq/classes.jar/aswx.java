public class aswx
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public aswx(aswm paramaswm, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected aswx a()
  {
    return (aswx)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswx
 * JD-Core Version:    0.7.0.1
 */