public class bebz
  extends becg
{
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public int b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" groupFileID:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" groupFileKey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
    localStringBuilder.append(" voiceType:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" downType:").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebz
 * JD-Core Version:    0.7.0.1
 */