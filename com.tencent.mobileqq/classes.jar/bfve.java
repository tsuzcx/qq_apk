import android.text.TextUtils;

public class bfve
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  
  public bfve()
  {
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public boolean a(bfve parambfve)
  {
    return (parambfve != null) && (this.jdField_a_of_type_Int == parambfve.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambfve.jdField_a_of_type_JavaLangString)) && (Math.abs(this.jdField_a_of_type_Float - parambfve.jdField_a_of_type_Float) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfve
 * JD-Core Version:    0.7.0.1
 */