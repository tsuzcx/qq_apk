import com.tencent.qqmini.sdk.log.QMLog;

public class bgil
  implements bghv<String>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static bgil a(String paramString1, String paramString2, int paramInt)
  {
    bgil localbgil = new bgil();
    localbgil.jdField_a_of_type_JavaLangString = paramString1;
    localbgil.b = paramString2;
    localbgil.jdField_a_of_type_Int = paramInt;
    return localbgil;
  }
  
  public String a(bghl parambghl)
  {
    QMLog.d("Action", "SubscribeEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + "sourceWebViewId = " + this.jdField_a_of_type_Int);
    parambghl = parambghl.a();
    if (parambghl != null) {
      parambghl.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgil
 * JD-Core Version:    0.7.0.1
 */