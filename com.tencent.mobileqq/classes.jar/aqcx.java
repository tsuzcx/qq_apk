import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqcx
{
  public String a = "";
  
  public static aqcx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aqcx localaqcx = new aqcx();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localaqcx.a = paramString.getJSONArray("contents").toString();
        }
        return localaqcx;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcx
 * JD-Core Version:    0.7.0.1
 */