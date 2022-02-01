import android.text.TextUtils;

public class bduc
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bduc(bdub parambdub, bdqc parambdqc)
  {
    if (parambdqc == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambdqc.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = parambdqc.a("r");
    }
    this.b = bcsa.a(bdow.a(parambdqc), false);
  }
  
  public bduc(bdub parambdub, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduc
 * JD-Core Version:    0.7.0.1
 */