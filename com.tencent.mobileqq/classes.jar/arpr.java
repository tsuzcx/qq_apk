public class arpr
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  private arpr(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupPushData--");
    localStringBuilder.append(",sig:").append(this.jdField_a_of_type_JavaLangString).append(",bizType:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arpr
 * JD-Core Version:    0.7.0.1
 */