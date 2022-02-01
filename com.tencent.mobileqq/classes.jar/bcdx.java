import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class bcdx
{
  int a;
  int b;
  int c;
  int d;
  
  public static bcdx a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        bcdx localbcdx = new bcdx();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localbcdx.c = localJSONObject.optInt("showRed", 0);
          localbcdx.d = localJSONObject.optInt("version", 0);
          return localbcdx;
        }
        paramString = localbcdx;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localbcdx.a = localJSONObject.optInt("showRed", 0);
        localbcdx.b = localJSONObject.optInt("version", 0);
        return localbcdx;
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
 * Qualified Name:     bcdx
 * JD-Core Version:    0.7.0.1
 */