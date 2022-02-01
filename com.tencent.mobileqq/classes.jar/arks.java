import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arks
{
  public boolean a = true;
  
  public static arks a(String paramString)
  {
    arks localarks = new arks();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return localarks;
        try
        {
          localarks.a = new JSONObject(paramString).optBoolean("isEnable", true);
          if (QLog.isColorLevel())
          {
            QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config :" + localarks.a);
            return localarks;
          }
        }
        catch (JSONException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config init error:" + paramString);
    return localarks;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arks
 * JD-Core Version:    0.7.0.1
 */