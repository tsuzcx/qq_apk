class awoo
  implements Comparable<awoo>
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  long b;
  
  public awoo(long paramLong1, long paramLong2, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(awoo paramawoo)
  {
    long l = this.jdField_a_of_type_Long - paramawoo.a();
    if (0L == l) {
      return -(int)(this.b - paramawoo.b());
    }
    return (int)l;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awoo
 * JD-Core Version:    0.7.0.1
 */