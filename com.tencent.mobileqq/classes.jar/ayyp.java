public class ayyp
  extends ayyy
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" storageSource:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" isSelfSend:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" voiceType:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" busiType:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" downType:").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyp
 * JD-Core Version:    0.7.0.1
 */