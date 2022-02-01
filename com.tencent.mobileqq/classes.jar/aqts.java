import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqts
{
  public String a = "";
  
  public static aqts a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aqts localaqts = new aqts();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localaqts.a = paramString.getJSONArray("contents").toString();
        }
        return localaqts;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqts
 * JD-Core Version:    0.7.0.1
 */