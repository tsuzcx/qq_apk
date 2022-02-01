public class azfr
{
  public long a;
  public String a;
  public long b;
  
  public azfr(long paramLong1, long paramLong2, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return String.format("[voiceIdx:%s, bTime:%s, eTime:%s]", new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfr
 * JD-Core Version:    0.7.0.1
 */