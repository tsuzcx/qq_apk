import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.jtcode.JtcodePluginInstallActivity;
import cooperation.plugin.IPluginManager;
import mqq.os.MqqHandler;

public class amsy
  implements Runnable
{
  public amsy(JtcodePluginInstallActivity paramJtcodePluginInstallActivity) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if ((JtcodePluginInstallActivity.a(this.a).a("wlx_jtcode.apk") == null) || (!JtcodePluginInstallActivity.a(this.a).isReady()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("JtcodePluginInstallActivity", 4, "mPluginManager.queryPlugin->pluginInfo is null");
      }
      if (!JtcodePluginInstallActivity.a(this.a))
      {
        ThreadManager.getSubThreadHandler().postDelayed(this, 3000L);
        JtcodePluginInstallActivity.a(this.a, true);
        return;
      }
      QQToast.a(this.a.getApplicationContext(), 2131438315, 0);
      JtcodePluginInstallActivity.a(this.a, false);
      this.a.finish();
      return;
    }
    long l2 = System.currentTimeMillis();
    JtcodePluginInstallActivity.a(this.a).append(" ==step4:initPluginManager queryPlugin cost=" + (l2 - l1) + ";start time=" + l1);
    ThreadManager.getUIHandler().post(new amsz(this));
    JtcodePluginInstallActivity.a(this.a).append(" ==step5:initPluginManager UIHandler().post cost=" + (System.currentTimeMillis() - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsy
 * JD-Core Version:    0.7.0.1
 */