import android.text.TextUtils;

public class azvw
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public azvw(azvv paramazvv, azsa paramazsa)
  {
    if (paramazsa == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramazsa.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramazsa.a("r");
    }
    this.b = ayvy.a(azqu.a(paramazsa), false);
  }
  
  public azvw(azvv paramazvv, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvw
 * JD-Core Version:    0.7.0.1
 */