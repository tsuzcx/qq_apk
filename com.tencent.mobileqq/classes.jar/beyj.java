import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class beyj
  implements OnPluginInstallListener
{
  public beyj(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
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
    bbmy.a(this.a.getApplicationContext(), 2131629528, 0);
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
    bbmy.a(this.a.getApplicationContext(), 2131629528, 0);
    BuscardPluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     beyj
 * JD-Core Version:    0.7.0.1
 */