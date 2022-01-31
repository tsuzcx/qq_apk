import android.text.TextUtils;

public class awzy
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public awzy(awzx paramawzx, awwc paramawwc)
  {
    if (paramawwc == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramawwc.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramawwc.a("r");
    }
    this.b = awbk.a(awuw.a(paramawwc), false);
  }
  
  public awzy(awzx paramawzx, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzy
 * JD-Core Version:    0.7.0.1
 */