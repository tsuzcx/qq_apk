public class bflc
{
  public int a;
  public long a;
  public String a;
  public String b;
  
  public bflc()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.b = "";
  }
  
  public bflc(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("iconUrl").append("=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", appid").append("=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", titleType").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", defTitle").append("=").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflc
 * JD-Core Version:    0.7.0.1
 */