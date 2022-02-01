public class bkyn<T>
{
  private long jdField_a_of_type_Long;
  private bkyo<T> jdField_a_of_type_Bkyo;
  private long b;
  
  private bkyn(bkyo<T> parambkyo)
  {
    this.jdField_a_of_type_Bkyo = parambkyo;
  }
  
  public static <T> bkyn<T> a(bkyo<T> parambkyo)
  {
    return new bkyn(parambkyo);
  }
  
  public bkyn<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bkyn<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bkyo != null) {
        this.jdField_a_of_type_Bkyo.execute(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyn
 * JD-Core Version:    0.7.0.1
 */