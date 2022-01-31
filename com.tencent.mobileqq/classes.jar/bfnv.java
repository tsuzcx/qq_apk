public class bfnv<T>
{
  private long jdField_a_of_type_Long;
  private bfnw<T> jdField_a_of_type_Bfnw;
  private long b;
  
  private bfnv(bfnw<T> parambfnw)
  {
    this.jdField_a_of_type_Bfnw = parambfnw;
  }
  
  public static <T> bfnv<T> a(bfnw<T> parambfnw)
  {
    return new bfnv(parambfnw);
  }
  
  public bfnv<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bfnv<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bfnw != null) {
        this.jdField_a_of_type_Bfnw.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfnv
 * JD-Core Version:    0.7.0.1
 */