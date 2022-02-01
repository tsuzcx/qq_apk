import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhk
{
  public boolean a = true;
  
  public static aqhk a(String paramString)
  {
    aqhk localaqhk = new aqhk();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return localaqhk;
        try
        {
          localaqhk.a = new JSONObject(paramString).optBoolean("isEnable", true);
          if (QLog.isColorLevel())
          {
            QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config :" + localaqhk.a);
            return localaqhk;
          }
        }
        catch (JSONException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config init error:" + paramString);
    return localaqhk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhk
 * JD-Core Version:    0.7.0.1
 */