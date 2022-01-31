import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aors
{
  public boolean a = true;
  
  public static aors a(String paramString)
  {
    aors localaors = new aors();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountConfigBean", 0, "parse content is empty");
      }
      return localaors;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isSideAccountGroupMsgEnabled", 0) != 0) {
          break label109;
        }
        bool = true;
        localaors.a = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubAccountConfigBean", 0, "parse configValue=" + localaors.a);
        return localaors;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SubAccountConfigBean", 0, "parse e:", paramString);
      return localaors;
      label109:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aors
 * JD-Core Version:    0.7.0.1
 */