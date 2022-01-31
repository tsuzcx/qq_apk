import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class bgga
  implements OnPluginInstallListener
{
  public bgga(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    bcpw.a(this.a.getApplicationContext(), 2131695209, 0);
    BuscardPluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = System.currentTimeMillis();
    BuscardPluginInstallActivity.a(this.a).append(" ==step8: onInstallFinish, cost=" + (l - this.a.a));
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "onInstallFinish, pluginId:" + paramString);
    }
    boolean bool = BuscardPluginInstallActivity.a(this.a).isPlugininstalled("BuscardPlugin.apk");
    BuscardPluginInstallActivity.a(this.a).append(" ==step9: onInstallFinish, isPlugininstalled cost=" + (System.currentTimeMillis() - l));
    if (bool)
    {
      BuscardPluginInstallActivity.a(this.a);
      return;
    }
    bcpw.a(this.a.getApplicationContext(), 2131695209, 0);
    BuscardPluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgga
 * JD-Core Version:    0.7.0.1
 */