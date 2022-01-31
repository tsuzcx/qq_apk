import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

public class bekk
  extends bekr
  implements bekl<String>
{
  private String c;
  
  public static bekk a(String paramString1, String paramString2, bekr parambekr)
  {
    if (!"NativePlugin".equals(paramString1)) {
      throw new IllegalArgumentException("Invalid namespace: " + paramString1);
    }
    bekk localbekk = new bekk();
    localbekk.c = "invokeNativePlugin";
    localbekk.jdField_a_of_type_JavaLangString = (paramString1 + "#" + paramString2);
    localbekk.jdField_b_of_type_JavaLangString = parambekr.jdField_b_of_type_JavaLangString;
    localbekk.jdField_b_of_type_Int = parambekr.jdField_b_of_type_Int;
    localbekk.jdField_a_of_type_Behp = parambekr.jdField_a_of_type_Behp;
    return localbekk;
  }
  
  public String a(behn parambehn)
  {
    parambehn = parambehn.a();
    if ((parambehn instanceof JsPluginEngine))
    {
      parambehn = (JsPluginEngine)parambehn;
      betc.a("RepeatRequestEvent", "Dispatch repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
      return parambehn.dispatchRequestEvent(this);
    }
    betc.c("RepeatRequestEvent", "Failed to handle repeat RequestEvent=" + this.jdField_a_of_type_JavaLangString);
    return "";
  }
  
  public String a(JSONObject paramJSONObject)
  {
    paramJSONObject = bekx.a(this.c, paramJSONObject).toString();
    a(paramJSONObject);
    return paramJSONObject;
  }
  
  public String a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = bekx.a(this.c, paramJSONObject, paramString).toString();
    a(paramJSONObject);
    return paramJSONObject;
  }
  
  public String b(JSONObject paramJSONObject)
  {
    paramJSONObject = bekx.c(this.c, paramJSONObject).toString();
    a(paramJSONObject);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekk
 * JD-Core Version:    0.7.0.1
 */