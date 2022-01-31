import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public final class bgif
  extends bgkd
  implements bghv<String>
{
  private bgkd a;
  
  public static bgif a(bgkd parambgkd, String paramString)
  {
    bgif localbgif = new bgif();
    localbgif.jdField_a_of_type_Bgkd = parambgkd;
    localbgif.jdField_a_of_type_JavaLangString = paramString;
    localbgif.jdField_b_of_type_JavaLangString = parambgkd.jdField_b_of_type_JavaLangString;
    localbgif.jdField_b_of_type_Int = parambgkd.jdField_b_of_type_Int;
    localbgif.jdField_a_of_type_Bghn = parambgkd.jdField_a_of_type_Bghn;
    return localbgif;
  }
  
  public String a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if ((parambghl instanceof JsPluginEngine))
    {
      parambghl = (JsPluginEngine)parambghl;
      QMLog.d("RepeatRequestEvent", "Dispatch repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
      return parambghl.dispatchSecondaryRequestEvent(this);
    }
    QMLog.w("RepeatRequestEvent", "Failed to handle repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
    return "";
  }
  
  public String a(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bgkd.a(paramJSONObject);
  }
  
  public String a(JSONObject paramJSONObject, String paramString)
  {
    return this.jdField_a_of_type_Bgkd.a(paramJSONObject, paramString);
  }
  
  public String b(JSONObject paramJSONObject)
  {
    return this.jdField_a_of_type_Bgkd.b(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgif
 * JD-Core Version:    0.7.0.1
 */