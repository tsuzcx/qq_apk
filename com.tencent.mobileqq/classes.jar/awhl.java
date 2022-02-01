import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class awhl
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c = "";
  
  public awhl()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public awhl(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  public boolean a()
  {
    long l = NetConnInfoCenter.getServerTime();
    return (this.jdField_a_of_type_Long <= 0L) || (l > this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhl
 * JD-Core Version:    0.7.0.1
 */