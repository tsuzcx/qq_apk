import android.content.ContentValues;

public final class bivm
{
  public long a;
  public Object a;
  public String a;
  public long b = -1L;
  
  public bivm(long paramLong1, long paramLong2, ContentValues paramContentValues)
  {
    this.jdField_a_of_type_Long = 1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangObject = paramContentValues;
    try
    {
      this.jdField_a_of_type_JavaLangString = paramContentValues.getAsString("entityNickName");
      return;
    }
    catch (Exception paramContentValues) {}
  }
  
  public bivm(long paramLong1, long paramLong2, Object paramObject, String paramString)
  {
    this.jdField_a_of_type_Long = 1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivm
 * JD-Core Version:    0.7.0.1
 */