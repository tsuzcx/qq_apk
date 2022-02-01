import android.text.TextUtils;

public class blpn
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  public String b;
  
  public blpn()
  {
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public boolean a(blpn paramblpn)
  {
    return (paramblpn != null) && (this.jdField_a_of_type_Int == paramblpn.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramblpn.jdField_a_of_type_JavaLangString)) && (Math.abs(this.jdField_a_of_type_Float - paramblpn.jdField_a_of_type_Float) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpn
 * JD-Core Version:    0.7.0.1
 */