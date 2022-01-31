import android.text.TextUtils;

public class anoc
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  
  public anoc() {}
  
  public anoc(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public anoc(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoutuItem uuid:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", md5").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", fileId").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", url").append(this.c);
    localStringBuilder.append(",key:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",count:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",picUin:").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anoc
 * JD-Core Version:    0.7.0.1
 */