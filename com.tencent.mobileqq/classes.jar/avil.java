class avil
  implements Comparable<avil>
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  long b;
  
  public avil(long paramLong1, long paramLong2, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(avil paramavil)
  {
    long l = this.jdField_a_of_type_Long - paramavil.a();
    if (0L == l) {
      return -(int)(this.b - paramavil.b());
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
 * Qualified Name:     avil
 * JD-Core Version:    0.7.0.1
 */