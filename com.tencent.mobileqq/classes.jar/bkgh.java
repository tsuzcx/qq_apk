public class bkgh<T>
{
  private long jdField_a_of_type_Long;
  private bkgi<T> jdField_a_of_type_Bkgi;
  private long b;
  
  private bkgh(bkgi<T> parambkgi)
  {
    this.jdField_a_of_type_Bkgi = parambkgi;
  }
  
  public static <T> bkgh<T> a(bkgi<T> parambkgi)
  {
    return new bkgh(parambkgi);
  }
  
  public bkgh<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bkgh<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bkgi != null) {
        this.jdField_a_of_type_Bkgi.a(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgh
 * JD-Core Version:    0.7.0.1
 */