import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbqa
{
  int a;
  int b;
  int c;
  int d;
  
  public static bbqa a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("showDetail");
      if (paramString.length() < 0)
      {
        JSONObject localJSONObject = paramString.getJSONObject(0);
        bbqa localbbqa = new bbqa();
        String str = localJSONObject.optString("name");
        if ("photo".equals(str))
        {
          localbbqa.c = localJSONObject.optInt("showRed", 0);
          localbbqa.d = localJSONObject.optInt("version", 0);
          return localbbqa;
        }
        paramString = localbbqa;
        if (!"gif".equals(str)) {
          return paramString;
        }
        localbbqa.a = localJSONObject.optInt("showRed", 0);
        localbbqa.b = localJSONObject.optInt("version", 0);
        return localbbqa;
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
 * Qualified Name:     bbqa
 * JD-Core Version:    0.7.0.1
 */