import android.support.annotation.NonNull;

public class bbcm
  implements bbcl
{
  public int a;
  public String a;
  public boolean a;
  
  public bbcm()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NonNull
  public String toString()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(":").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcm
 * JD-Core Version:    0.7.0.1
 */