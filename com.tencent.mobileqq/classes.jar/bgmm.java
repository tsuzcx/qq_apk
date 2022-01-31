import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public final class bgmm
  extends bgok
  implements bgmc<String>
{
  private bgok a;
  
  public static bgmm a(bgok parambgok, String paramString)
  {
    bgmm localbgmm = new bgmm();
    localbgmm.jdField_a_of_type_Bgok = parambgok;
    localbgmm.jdField_a_of_type_JavaLangString = paramString;
    localbgmm.jdField_b_of_type_JavaLangString = parambgok.jdField_b_of_type_JavaLangString;
    localbgmm.jdField_b_of_type_Int = parambgok.jdField_b_of_type_Int;
    localbgmm.jdField_a_of_type_Bglu = parambgok.jdField_a_of_type_Bglu;
    return localbgmm;
  }
  
  public String a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if ((parambgls instanceof JsPluginEngine))
    {
      parambgls = (JsPluginEngine)parambgls;
      QMLog.d("RepeatRequestEvent", "Dispatch repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
      return parambgls.dispatchSecondaryRequestEvent(this);
    }
    QMLog.w("RepeatRequestEvent", "Failed to handle repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
    return "";
  }
  
  public String a(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bgok.a(paramJSONObject);
  }
  
  public String a(JSONObject paramJSONObject, String paramString)
  {
    return this.jdField_a_of_type_Bgok.a(paramJSONObject, paramString);
  }
  
  public String b(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bgok.b(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmm
 * JD-Core Version:    0.7.0.1
 */