public class bcva
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c;
  
  public bcva(bcuy parambcuy)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("mUnread=" + this.jdField_a_of_type_Long);
    localStringBuilder.append(",mNewMsg=" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append("mText=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mIconPath=" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("mRedPoint=" + this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",mTab=" + this.c);
    localStringBuilder.append(",mType=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcva
 * JD-Core Version:    0.7.0.1
 */