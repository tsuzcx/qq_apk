public class bfne<T>
{
  private long jdField_a_of_type_Long;
  private bfnf<T> jdField_a_of_type_Bfnf;
  private long b;
  
  private bfne(bfnf<T> parambfnf)
  {
    this.jdField_a_of_type_Bfnf = parambfnf;
  }
  
  public static <T> bfne<T> a(bfnf<T> parambfnf)
  {
    return new bfne(parambfnf);
  }
  
  public bfne<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bfne<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bfnf != null) {
        this.jdField_a_of_type_Bfnf.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfne
 * JD-Core Version:    0.7.0.1
 */