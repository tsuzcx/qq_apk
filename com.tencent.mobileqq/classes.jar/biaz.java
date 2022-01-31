import android.text.TextUtils;

public class biaz
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  
  public biaz()
  {
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public boolean a(biaz parambiaz)
  {
    return (parambiaz != null) && (this.jdField_a_of_type_Int == parambiaz.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambiaz.jdField_a_of_type_JavaLangString)) && (Math.abs(this.jdField_a_of_type_Float - parambiaz.jdField_a_of_type_Float) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biaz
 * JD-Core Version:    0.7.0.1
 */