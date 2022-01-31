import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class bgpy
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  bgpy(Runnable paramRunnable) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient == null) {}
    try
    {
      ThreadManager.post(this.a, 5, null, false);
      return;
    }
    catch (Exception paramPluginManagerClient) {}
    if (paramPluginManagerClient.isPluginInstalled("qqfav.apk"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "qqfav.apk already installed.");
      }
      bgpw.a().set(true);
      try
      {
        ThreadManager.post(this.a, 5, null, false);
        return;
      }
      catch (Exception paramPluginManagerClient)
      {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "installing plugin qqfav.apk");
    }
    paramPluginManagerClient.installPlugin("qqfav.apk", new bgpz(this));
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpy
 * JD-Core Version:    0.7.0.1
 */