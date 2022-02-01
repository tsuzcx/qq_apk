import android.text.TextUtils;

public class bdbj
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bdbj(bdbi parambdbi, bcxj parambcxj)
  {
    if (parambcxj == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambcxj.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = parambcxj.a("r");
    }
    this.b = bbzj.a(bcwd.a(parambcxj), false);
  }
  
  public bdbj(bdbi parambdbi, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbj
 * JD-Core Version:    0.7.0.1
 */