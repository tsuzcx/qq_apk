public class bhsx<T>
{
  private long jdField_a_of_type_Long;
  private bhsy<T> jdField_a_of_type_Bhsy;
  private long b;
  
  private bhsx(bhsy<T> parambhsy)
  {
    this.jdField_a_of_type_Bhsy = parambhsy;
  }
  
  public static <T> bhsx<T> a(bhsy<T> parambhsy)
  {
    return new bhsx(parambhsy);
  }
  
  public bhsx<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bhsx<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bhsy != null) {
        this.jdField_a_of_type_Bhsy.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhsx
 * JD-Core Version:    0.7.0.1
 */