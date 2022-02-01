public class bfbe
  extends bfbf
{
  public int a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public bfbe()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" voiceLength:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" autoToText:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" type:").append(this.c).append(" audioPanel:").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbe
 * JD-Core Version:    0.7.0.1
 */