import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class azcy
{
  int a;
  int b;
  int c;
  int d;
  
  public static azcy a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        azcy localazcy = new azcy();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localazcy.c = localJSONObject.optInt("showRed", 0);
          localazcy.d = localJSONObject.optInt("version", 0);
          return localazcy;
        }
        paramString = localazcy;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localazcy.a = localJSONObject.optInt("showRed", 0);
        localazcy.b = localJSONObject.optInt("version", 0);
        return localazcy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcy
 * JD-Core Version:    0.7.0.1
 */