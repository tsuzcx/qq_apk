import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arbz
{
  public boolean a = true;
  
  public static arbz a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        arbz localarbz = new arbz();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localarbz.a = bool;
          return localarbz;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(arbz paramarbz)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramarbz != null) {}
    try
    {
      localJSONObject.put("isMultiChannelReportEnable", paramarbz.a);
      return localJSONObject.toString();
    }
    catch (JSONException paramarbz)
    {
      for (;;)
      {
        paramarbz.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbz
 * JD-Core Version:    0.7.0.1
 */