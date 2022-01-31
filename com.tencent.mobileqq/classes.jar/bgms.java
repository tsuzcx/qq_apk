import com.tencent.qqmini.sdk.log.QMLog;

public class bgms
  implements bgmc<String>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static bgms a(String paramString1, String paramString2, int paramInt)
  {
    bgms localbgms = new bgms();
    localbgms.jdField_a_of_type_JavaLangString = paramString1;
    localbgms.b = paramString2;
    localbgms.jdField_a_of_type_Int = paramInt;
    return localbgms;
  }
  
  public String a(bgls parambgls)
  {
    QMLog.d("Action", "SubscribeEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + "sourceWebViewId = " + this.jdField_a_of_type_Int);
    parambgls = parambgls.a();
    if (parambgls != null) {
      parambgls.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgms
 * JD-Core Version:    0.7.0.1
 */