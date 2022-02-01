import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class arge
{
  public String a = "";
  
  public static arge a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        arge localarge = new arge();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localarge.a = paramString.getJSONArray("contents").toString();
        }
        return localarge;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arge
 * JD-Core Version:    0.7.0.1
 */