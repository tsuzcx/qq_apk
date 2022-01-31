import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aonh
{
  public String a = "";
  
  public static aonh a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aonh localaonh = new aonh();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localaonh.a = paramString.getJSONArray("contents").toString();
        }
        return localaonh;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonh
 * JD-Core Version:    0.7.0.1
 */