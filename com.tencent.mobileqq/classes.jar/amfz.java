import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class amfz
{
  public String a = "";
  
  public static amfz a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        amfz localamfz = new amfz();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localamfz.a = paramString.getJSONArray("contents").toString();
        }
        return localamfz;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfz
 * JD-Core Version:    0.7.0.1
 */