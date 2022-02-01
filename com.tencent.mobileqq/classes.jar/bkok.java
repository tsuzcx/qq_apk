import android.text.TextUtils;

public class bkok
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  
  public bkok()
  {
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public boolean a(bkok parambkok)
  {
    return (parambkok != null) && (this.jdField_a_of_type_Int == parambkok.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, parambkok.jdField_a_of_type_JavaLangString)) && (Math.abs(this.jdField_a_of_type_Float - parambkok.jdField_a_of_type_Float) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkok
 * JD-Core Version:    0.7.0.1
 */