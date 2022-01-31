import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class axdl
{
  int a;
  int b;
  int c;
  int d;
  
  public static axdl a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        axdl localaxdl = new axdl();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localaxdl.c = localJSONObject.optInt("showRed", 0);
          localaxdl.d = localJSONObject.optInt("version", 0);
          return localaxdl;
        }
        paramString = localaxdl;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localaxdl.a = localJSONObject.optInt("showRed", 0);
        localaxdl.b = localJSONObject.optInt("version", 0);
        return localaxdl;
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
 * Qualified Name:     axdl
 * JD-Core Version:    0.7.0.1
 */