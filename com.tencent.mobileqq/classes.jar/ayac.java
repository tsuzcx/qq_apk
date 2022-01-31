import android.text.TextUtils;

public class ayac
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public ayac(ayab paramayab, axwg paramaxwg)
  {
    if (paramaxwg == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramaxwg.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramaxwg.a("r");
    }
    this.b = axau.a(axva.a(paramaxwg), false);
  }
  
  public ayac(ayab paramayab, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayac
 * JD-Core Version:    0.7.0.1
 */