import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qqfav.QfavHelper.4;

public class bivg
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public bivg(QfavHelper.4 param4) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    try
    {
      if (!paramPluginManagerClient.isPluginInstalled("qqfav.apk"))
      {
        if (this.a.a == null)
        {
          paramPluginManagerClient.installPlugin("qqfav.apk");
          return;
        }
        paramPluginManagerClient.installPlugin("qqfav.apk", this.a.a);
        return;
      }
    }
    catch (Exception paramPluginManagerClient)
    {
      if (this.a.a != null)
      {
        try
        {
          this.a.a.onInstallError("qqfav.apk", -1);
          return;
        }
        catch (RemoteException paramPluginManagerClient)
        {
          paramPluginManagerClient.printStackTrace();
          return;
        }
        paramPluginManagerClient = this.a.a;
        if (paramPluginManagerClient != null) {
          try
          {
            this.a.a.onInstallFinish("qqfav.apk");
            return;
          }
          catch (RemoteException paramPluginManagerClient)
          {
            paramPluginManagerClient.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bivg
 * JD-Core Version:    0.7.0.1
 */