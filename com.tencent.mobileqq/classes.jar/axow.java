public class axow
{
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  
  public axow()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L)) {}
    for (long l = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000000L;; l = 0L)
    {
      if (l < 0L) {
        return 0L;
      }
      return l;
    }
  }
  
  public String a(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Int != -1)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Long != 0L)
      {
        l1 = l2;
        if (this.jdField_b_of_type_Long != 0L) {
          l1 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000000L;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append("_").append(this.jdField_a_of_type_Int).append("_").append(this.jdField_b_of_type_Int).append("_").append(this.c).append("_").append(l1);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.nanoTime();
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= this.jdField_b_of_type_Long) {
      this.jdField_a_of_type_Long = 0L;
    }
    while (paramLong <= this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void b()
  {
    long l = System.nanoTime();
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("startTime: ").append(this.jdField_a_of_type_Long).append(" finishTime: ").append(this.jdField_b_of_type_Long);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axow
 * JD-Core Version:    0.7.0.1
 */