import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

public class bejt
  extends beka
  implements beju<String>
{
  private String c;
  
  public static bejt a(String paramString1, String paramString2, beka parambeka)
  {
    if (!"NativePlugin".equals(paramString1)) {
      throw new IllegalArgumentException("Invalid namespace: " + paramString1);
    }
    bejt localbejt = new bejt();
    localbejt.c = "invokeNativePlugin";
    localbejt.jdField_a_of_type_JavaLangString = (paramString1 + "#" + paramString2);
    localbejt.jdField_b_of_type_JavaLangString = parambeka.jdField_b_of_type_JavaLangString;
    localbejt.jdField_b_of_type_Int = parambeka.jdField_b_of_type_Int;
    localbejt.jdField_a_of_type_Begy = parambeka.jdField_a_of_type_Begy;
    return localbejt;
  }
  
  public String a(begw parambegw)
  {
    parambegw = parambegw.a();
    if ((parambegw instanceof JsPluginEngine))
    {
      parambegw = (JsPluginEngine)parambegw;
      besl.a("RepeatRequestEvent", "Dispatch repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
      return parambegw.dispatchRequestEvent(this);
    }
    besl.c("RepeatRequestEvent", "Failed to handle repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
    return "";
  }
  
  public String a(JSONObject paramJSONObject)
  {
    paramJSONObject = bekg.a(this.c, paramJSONObject).toString();
    a(paramJSONObject);
    return paramJSONObject;
  }
  
  public String a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = bekg.a(this.c, paramJSONObject, paramString).toString();
    a(paramJSONObject);
    return paramJSONObject;
  }
  
  public String b(JSONObject paramJSONObject)
  {
    paramJSONObject = bekg.c(this.c, paramJSONObject).toString();
    a(paramJSONObject);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejt
 * JD-Core Version:    0.7.0.1
 */