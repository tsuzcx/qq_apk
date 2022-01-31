import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aorq
{
  public String a = "";
  
  public static aorq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aorq localaorq = new aorq();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localaorq.a = paramString.getJSONArray("contents").toString();
        }
        return localaorq;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorq
 * JD-Core Version:    0.7.0.1
 */