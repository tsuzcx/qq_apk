public class arby
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public String b = "";
  
  public arby(arbn paramarbn, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected arby a()
  {
    return (arby)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arby
 * JD-Core Version:    0.7.0.1
 */