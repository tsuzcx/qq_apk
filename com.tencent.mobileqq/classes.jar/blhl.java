public class blhl<T>
{
  private long jdField_a_of_type_Long;
  private blhm<T> jdField_a_of_type_Blhm;
  private long b;
  
  private blhl(blhm<T> paramblhm)
  {
    this.jdField_a_of_type_Blhm = paramblhm;
  }
  
  public static <T> blhl<T> a(blhm<T> paramblhm)
  {
    return new blhl(paramblhm);
  }
  
  public blhl<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public blhl<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Blhm != null) {
        this.jdField_a_of_type_Blhm.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhl
 * JD-Core Version:    0.7.0.1
 */