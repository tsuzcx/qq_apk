import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class argg
{
  public boolean a = true;
  
  public static argg a(String paramString)
  {
    argg localargg = new argg();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountConfigBean", 0, "parse content is empty");
      }
      return localargg;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isSideAccountGroupMsgEnabled", 0) != 0) {
          break label109;
        }
        bool = true;
        localargg.a = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubAccountConfigBean", 0, "parse configValue=" + localargg.a);
        return localargg;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SubAccountConfigBean", 0, "parse e:", paramString);
      return localargg;
      label109:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argg
 * JD-Core Version:    0.7.0.1
 */