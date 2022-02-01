import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apyw
{
  public boolean a = true;
  
  public static apyw a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        apyw localapyw = new apyw();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localapyw.a = bool;
          return localapyw;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(apyw paramapyw)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramapyw != null) {}
    try
    {
      localJSONObject.put("isMultiChannelReportEnable", paramapyw.a);
      return localJSONObject.toString();
    }
    catch (JSONException paramapyw)
    {
      for (;;)
      {
        paramapyw.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyw
 * JD-Core Version:    0.7.0.1
 */