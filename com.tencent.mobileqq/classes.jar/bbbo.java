public class bbbo
  extends bbbz
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b = false;
  public String c;
  public String d;
  
  public bbbo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mResid:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" startOffset:").append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbo
 * JD-Core Version:    0.7.0.1
 */