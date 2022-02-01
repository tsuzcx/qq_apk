import android.text.TextUtils;

public class bdto
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bdto(bdtn parambdtn, bdpl parambdpl)
  {
    if (parambdpl == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambdpl.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = parambdpl.a("r");
    }
    this.b = bcsc.a(bdof.a(parambdpl), false);
  }
  
  public bdto(bdtn parambdtn, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdto
 * JD-Core Version:    0.7.0.1
 */