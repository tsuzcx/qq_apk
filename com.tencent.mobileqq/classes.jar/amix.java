import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;
import cooperation.plugin.IPluginManager;
import mqq.os.MqqHandler;

public class amix
  implements Runnable
{
  public amix(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if ((BuscardPluginInstallActivity.a(this.a).a("BuscardPlugin.apk") == null) || (!BuscardPluginInstallActivity.a(this.a).isReady()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("BuscardPluginInstallActivity", 4, "mPluginManager.queryPlugin->pluginInfo is null");
      }
      if (!BuscardPluginInstallActivity.a(this.a))
      {
        ThreadManager.getSubThreadHandler().postDelayed(this, 3000L);
        BuscardPluginInstallActivity.a(this.a, true);
        return;
      }
      QQToast.a(this.a.getApplicationContext(), 2131438295, 0);
      BuscardPluginInstallActivity.a(this.a, false);
      this.a.finish();
      return;
    }
    long l2 = System.currentTimeMillis();
    BuscardPluginInstallActivity.a(this.a).append(" ==step4:initPluginManager queryPlugin cost=" + (l2 - l1) + ";start time=" + l1);
    ThreadManager.getUIHandler().post(new amiy(this));
    BuscardPluginInstallActivity.a(this.a).append(" ==step5:initPluginManager UIHandler().post cost=" + (System.currentTimeMillis() - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amix
 * JD-Core Version:    0.7.0.1
 */