import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwd
{
  public String a = "";
  
  public static amwd a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        amwd localamwd = new amwd();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localamwd.a = paramString.getJSONArray("contents").toString();
        }
        return localamwd;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwd
 * JD-Core Version:    0.7.0.1
 */