import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arfg
{
  public boolean a = true;
  
  public static arfg a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        arfg localarfg = new arfg();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localarfg.a = bool;
          return localarfg;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(arfg paramarfg)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramarfg != null) {}
    try
    {
      localJSONObject.put("isMultiChannelReportEnable", paramarfg.a);
      return localJSONObject.toString();
    }
    catch (JSONException paramarfg)
    {
      for (;;)
      {
        paramarfg.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfg
 * JD-Core Version:    0.7.0.1
 */