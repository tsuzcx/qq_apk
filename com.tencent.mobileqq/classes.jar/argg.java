import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class argg
  implements arae<String>
{
  public boolean a;
  
  public void a(String paramString)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config content is empty");
    }
    for (;;)
    {
      return;
      QLog.i("OpenSdkSwitchConfig", 1, "OpenVirtual.switch.config.parse=" + paramString);
      try
      {
        if (new JSONObject(paramString).optInt("enable", 0) == 1) {
          bool = true;
        }
        this.a = bool;
        if (QLog.isColorLevel())
        {
          QLog.e("OpenSdkSwitchConfig", 2, new Object[] { "OpenVirtual.switch.config.parse=", toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config.getException.", paramString);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OpenSdkSwitchConfig={");
    localStringBuilder.append("enable:").append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argg
 * JD-Core Version:    0.7.0.1
 */