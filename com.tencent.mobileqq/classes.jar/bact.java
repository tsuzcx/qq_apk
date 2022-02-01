public class bact
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c = "";
  
  public bact()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idolid:").append(this.jdField_a_of_type_Int).append(" ");
    localStringBuilder.append("name:").append(this.jdField_a_of_type_JavaLangString).append(" ");
    localStringBuilder.append("avatar:").append(this.jdField_b_of_type_JavaLangString).append(" ");
    localStringBuilder.append("pic:").append(this.c).append(" ");
    localStringBuilder.append("rank:").append(this.jdField_a_of_type_Long).append(" ");
    localStringBuilder.append("qScore:").append(this.jdField_b_of_type_Long).append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bact
 * JD-Core Version:    0.7.0.1
 */