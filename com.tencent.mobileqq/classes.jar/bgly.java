import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;

class bgly
  implements OnPluginInstallListener
{
  bgly(bglx parambglx) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
      }
      axqw.b(bglx.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, paramInt, "", "", "", "");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PluginPreInstaller", 2, "PluginReinstallInWiFi finish,plugin:" + paramString);
    }
    Object localObject;
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallFinish, pluginId = " + paramString);
      }
      axqw.b(bglx.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, 0, "", "", "", "");
      localObject = (bgth)bglx.a(this.a).getManager(129);
      if (localObject != null) {
        ((bgth)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new Intent("com.tencent.mobileqq.cooperation.plugin." + paramString);
      ((Intent)localObject).putExtra("plugin", paramString);
      bglx.a(this.a).sendBroadcast((Intent)localObject);
      return;
      if ("comic_plugin.apk".equals(paramString)) {
        bgij.a(bglx.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgly
 * JD-Core Version:    0.7.0.1
 */