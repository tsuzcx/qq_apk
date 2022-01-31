import com.tencent.qqmini.sdk.log.QMLog;

public class bgid
  extends bgkd
  implements bghv<String>
{
  public int a;
  private bghn b;
  
  public bgid()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public static bgid a(bgkd parambgkd, int paramInt)
  {
    bgid localbgid = new bgid();
    localbgid.jdField_a_of_type_JavaLangString = parambgkd.jdField_a_of_type_JavaLangString;
    localbgid.jdField_b_of_type_JavaLangString = parambgkd.jdField_b_of_type_JavaLangString;
    localbgid.jdField_a_of_type_Bghn = parambgkd.jdField_a_of_type_Bghn;
    localbgid.jdField_b_of_type_Int = parambgkd.jdField_b_of_type_Int;
    localbgid.jdField_a_of_type_Int = paramInt;
    return localbgid;
  }
  
  public String a(bghl parambghl)
  {
    QMLog.d("Action", "sendNativeViewEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + " " + "jsService = " + this.jdField_a_of_type_Bghn + " " + "callbackId = " + this.jdField_b_of_type_Int + " " + "target = " + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Bghn = parambghl.a();
    return parambghl.a().a(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_b_of_type_Bghn != null) {
      this.jdField_b_of_type_Bghn.a(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgid
 * JD-Core Version:    0.7.0.1
 */