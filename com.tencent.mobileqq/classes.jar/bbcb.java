public class bbcb
  extends bbbz
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b = 0;
  
  public bbcb()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" fileId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" startOffset:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" videoAttr:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" videoKandianType:").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcb
 * JD-Core Version:    0.7.0.1
 */