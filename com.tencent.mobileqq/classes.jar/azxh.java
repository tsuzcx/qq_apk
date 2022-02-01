import androidx.annotation.NonNull;

public class azxh
{
  public int a;
  public String a;
  public String b = "";
  
  public azxh()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("actionId").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("actionAndData").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("plainText").append("=").append(this.b).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxh
 * JD-Core Version:    0.7.0.1
 */