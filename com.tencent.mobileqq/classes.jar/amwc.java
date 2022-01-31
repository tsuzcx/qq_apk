import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwc
{
  public String a = "";
  
  public static amwc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        amwc localamwc = new amwc();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localamwc.a = paramString.getJSONArray("contents").toString();
        }
        return localamwc;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwc
 * JD-Core Version:    0.7.0.1
 */