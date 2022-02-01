public class bjnb<T>
{
  private long jdField_a_of_type_Long;
  private bjnc<T> jdField_a_of_type_Bjnc;
  private long b;
  
  private bjnb(bjnc<T> parambjnc)
  {
    this.jdField_a_of_type_Bjnc = parambjnc;
  }
  
  public static <T> bjnb<T> a(bjnc<T> parambjnc)
  {
    return new bjnb(parambjnc);
  }
  
  public bjnb<T> a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bjnb<T> a(T paramT)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > this.b)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_Bjnc != null) {
        this.jdField_a_of_type_Bjnc.execute(paramT);
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnb
 * JD-Core Version:    0.7.0.1
 */