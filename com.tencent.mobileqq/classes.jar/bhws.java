import android.text.TextUtils;

public class bhws
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  
  public bhws()
  {
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public boolean a(bhws parambhws)
  {
    return (parambhws != null) && (this.jdField_a_of_type_Int == parambhws.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambhws.jdField_a_of_type_JavaLangString)) && (Math.abs(this.jdField_a_of_type_Float - parambhws.jdField_a_of_type_Float) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhws
 * JD-Core Version:    0.7.0.1
 */