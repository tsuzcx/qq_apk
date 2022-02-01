public class bhgz
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("DataItem:position=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", type=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", coverUrl=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", feedId=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", vid=").append(this.c);
    localStringBuilder.append(", jumpUrl=").append(this.d);
    localStringBuilder.append(", spiritImageUrl=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgz
 * JD-Core Version:    0.7.0.1
 */