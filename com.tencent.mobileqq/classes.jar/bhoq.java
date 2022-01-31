public class bhoq<T>
{
  private long jdField_a_of_type_Long;
  private bhor<T> jdField_a_of_type_Bhor;
  private long b;
  
  private bhoq(bhor<T> parambhor)
  {
    this.jdField_a_of_type_Bhor = parambhor;
  }
  
  public static <T> bhoq<T> a(bhor<T> parambhor)
  {
    return new bhoq(parambhor);
  }
  
  public bhoq<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bhoq<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bhor != null) {
        this.jdField_a_of_type_Bhor.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhoq
 * JD-Core Version:    0.7.0.1
 */