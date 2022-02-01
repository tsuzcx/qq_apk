import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class bcwu
{
  int a;
  int b;
  int c;
  int d;
  
  public static bcwu a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        bcwu localbcwu = new bcwu();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localbcwu.c = localJSONObject.optInt("showRed", 0);
          localbcwu.d = localJSONObject.optInt("version", 0);
          return localbcwu;
        }
        paramString = localbcwu;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localbcwu.a = localJSONObject.optInt("showRed", 0);
        localbcwu.b = localJSONObject.optInt("version", 0);
        return localbcwu;
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
 * Qualified Name:     bcwu
 * JD-Core Version:    0.7.0.1
 */