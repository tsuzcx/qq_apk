import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqle
  implements aqkr
{
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqkq paramaqkq)
  {
    if ((paramaqkq != null) && ("smart_devices_discovery_config".equals(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("OnSmartDeviceDiscoveryCfgListener", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + paramaqkq.a);
      }
    }
    try
    {
      paramInt = new JSONObject(paramaqkq.a).optInt("smart_device_discovery_config_switch");
      BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "smart_device_discovery_config_file", 0).edit().putInt("smart_device_discovery_config_switch", paramInt).apply();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString) {}finally
    {
      BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "smart_device_discovery_config_file", 0).edit().putInt("smart_device_discovery_config_switch", 1).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqle
 * JD-Core Version:    0.7.0.1
 */