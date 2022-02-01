import android.text.TextUtils;

public class bcmo
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bcmo(bcmn parambcmn, bcin parambcin)
  {
    if (parambcin == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambcin.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = parambcin.a("r");
    }
    this.b = bblk.a(bchh.a(parambcin), false);
  }
  
  public bcmo(bcmn parambcmn, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmo
 * JD-Core Version:    0.7.0.1
 */