import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqpy
{
  public boolean a = true;
  
  public static aqpy a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aqpy localaqpy = new aqpy();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaqpy.a = bool;
          return localaqpy;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(aqpy paramaqpy)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramaqpy != null) {}
    try
    {
      localJSONObject.put("isMultiChannelReportEnable", paramaqpy.a);
      return localJSONObject.toString();
    }
    catch (JSONException paramaqpy)
    {
      for (;;)
      {
        paramaqpy.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpy
 * JD-Core Version:    0.7.0.1
 */