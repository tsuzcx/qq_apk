public class arlz
{
  public int a;
  public String a;
  public boolean a;
  public String b = "";
  public String c = "";
  
  public arlz()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enable:").append(this.jdField_a_of_type_Boolean).append(",");
    localStringBuilder.append("mPlainContent:").append(this.jdField_a_of_type_JavaLangString).append(",");
    localStringBuilder.append("mHighLightContent:").append(this.b).append(",");
    localStringBuilder.append("times:").append(this.jdField_a_of_type_Int).append(",");
    localStringBuilder.append("mJumpLinkUrls:").append(this.c).append(",");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlz
 * JD-Core Version:    0.7.0.1
 */