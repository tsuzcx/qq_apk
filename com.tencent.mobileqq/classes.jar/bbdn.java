import androidx.annotation.NonNull;

public class bbdn
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c = -1;
  
  public bbdn()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("age").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("gender").append("=").append(this.jdField_b_of_type_Int).append("|");
    localStringBuilder.append("place").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("addSrc").append("=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("commFrdCnt").append("=").append(this.c).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdn
 * JD-Core Version:    0.7.0.1
 */