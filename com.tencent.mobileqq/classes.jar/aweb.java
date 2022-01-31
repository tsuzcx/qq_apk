import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aweb
{
  int a;
  int b;
  int c;
  int d;
  
  public static aweb a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        aweb localaweb = new aweb();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localaweb.c = localJSONObject.optInt("showRed", 0);
          localaweb.d = localJSONObject.optInt("version", 0);
          return localaweb;
        }
        paramString = localaweb;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localaweb.a = localJSONObject.optInt("showRed", 0);
        localaweb.b = localJSONObject.optInt("version", 0);
        return localaweb;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoAndHotPicRedDotConfProcessor", 2, "handleGetPtvHotPicConfig Exception :", paramString);
      }
      paramString = null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aweb
 * JD-Core Version:    0.7.0.1
 */