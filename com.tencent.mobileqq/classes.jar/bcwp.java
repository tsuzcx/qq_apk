import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class bcwp
{
  int a;
  int b;
  int c;
  int d;
  
  public static bcwp a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        bcwp localbcwp = new bcwp();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localbcwp.c = localJSONObject.optInt("showRed", 0);
          localbcwp.d = localJSONObject.optInt("version", 0);
          return localbcwp;
        }
        paramString = localbcwp;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localbcwp.a = localJSONObject.optInt("showRed", 0);
        localbcwp.b = localJSONObject.optInt("version", 0);
        return localbcwp;
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
 * Qualified Name:     bcwp
 * JD-Core Version:    0.7.0.1
 */