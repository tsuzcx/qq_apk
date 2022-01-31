public class befk<T>
{
  private long jdField_a_of_type_Long;
  private befl<T> jdField_a_of_type_Befl;
  private long b;
  
  private befk(befl<T> parambefl)
  {
    this.jdField_a_of_type_Befl = parambefl;
  }
  
  public static <T> befk<T> a(befl<T> parambefl)
  {
    return new befk(parambefl);
  }
  
  public befk<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public befk<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Befl != null) {
        this.jdField_a_of_type_Befl.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     befk
 * JD-Core Version:    0.7.0.1
 */