import android.text.TextUtils;

public class benk
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  
  public benk()
  {
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public boolean a(benk parambenk)
  {
    return (parambenk != null) && (this.jdField_a_of_type_Int == parambenk.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambenk.jdField_a_of_type_JavaLangString)) && (Math.abs(this.jdField_a_of_type_Float - parambenk.jdField_a_of_type_Float) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     benk
 * JD-Core Version:    0.7.0.1
 */