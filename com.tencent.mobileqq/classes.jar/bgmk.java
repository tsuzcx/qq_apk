import com.tencent.qqmini.sdk.log.QMLog;

public class bgmk
  extends bgok
  implements bgmc<String>
{
  public int a;
  private bglu b;
  
  public bgmk()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public static bgmk a(bgok parambgok, int paramInt)
  {
    bgmk localbgmk = new bgmk();
    localbgmk.jdField_a_of_type_JavaLangString = parambgok.jdField_a_of_type_JavaLangString;
    localbgmk.jdField_b_of_type_JavaLangString = parambgok.jdField_b_of_type_JavaLangString;
    localbgmk.jdField_a_of_type_Bglu = parambgok.jdField_a_of_type_Bglu;
    localbgmk.jdField_b_of_type_Int = parambgok.jdField_b_of_type_Int;
    localbgmk.jdField_a_of_type_Int = paramInt;
    return localbgmk;
  }
  
  public String a(bgls parambgls)
  {
    QMLog.d("Action", "sendNativeViewEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + " " + "jsService = " + this.jdField_a_of_type_Bglu + " " + "callbackId = " + this.jdField_b_of_type_Int + " " + "target = " + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Bglu = parambgls.a();
    return parambgls.a().a(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_b_of_type_Bglu != null) {
      this.jdField_b_of_type_Bglu.a(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmk
 * JD-Core Version:    0.7.0.1
 */