import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aonj
{
  public boolean a = true;
  
  public static aonj a(String paramString)
  {
    aonj localaonj = new aonj();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountConfigBean", 0, "parse content is empty");
      }
      return localaonj;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isSideAccountGroupMsgEnabled", 0) != 0) {
          break label109;
        }
        bool = true;
        localaonj.a = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubAccountConfigBean", 0, "parse configValue=" + localaonj.a);
        return localaonj;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SubAccountConfigBean", 0, "parse e:", paramString);
      return localaonj;
      label109:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonj
 * JD-Core Version:    0.7.0.1
 */