import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;

public class bils
  implements OnPluginInstallListener
{
  public bils(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallBegin, pluginId:" + paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallDownloadProgress, pluginId:" + paramString + " offset:" + paramInt1 + " total: " + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    QQToast.a(this.a.getApplicationContext(), 2131695368, 0).a();
    HcePluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onInstallFinish, pluginId:" + paramString);
    }
    if (HcePluginInstallActivity.a(this.a).isPlugininstalled("vfc_plugin.apk"))
    {
      HcePluginInstallActivity.a(this.a);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 2131695368, 0).a();
    HcePluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bils
 * JD-Core Version:    0.7.0.1
 */