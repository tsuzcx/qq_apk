import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arjg
{
  public boolean a = true;
  
  public static arjg a(String paramString)
  {
    arjg localarjg = new arjg();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountConfigBean", 0, "parse content is empty");
      }
      return localarjg;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isSideAccountGroupMsgEnabled", 0) != 0) {
          break label109;
        }
        bool = true;
        localarjg.a = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubAccountConfigBean", 0, "parse configValue=" + localarjg.a);
        return localarjg;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SubAccountConfigBean", 0, "parse e:", paramString);
      return localarjg;
      label109:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjg
 * JD-Core Version:    0.7.0.1
 */