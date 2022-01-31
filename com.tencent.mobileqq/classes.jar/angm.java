import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.open.wadl.WLog;
import cooperation.wadl.ipc.IWadlProxyServiceMonitor;
import cooperation.wadl.ipc.IWadlService;
import cooperation.wadl.ipc.IWadlService.Stub;
import cooperation.wadl.ipc.WadlProxyServiceManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class angm
  implements ServiceConnection
{
  public angm(WadlProxyServiceManager paramWadlProxyServiceManager) {}
  
  public void a()
  {
    if ((WadlProxyServiceManager.a(this.a) != null) && (!WadlProxyServiceManager.a(this.a).b())) {
      WadlProxyServiceManager.a(this.a).b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WLog.b("WadlProxyServiceManager", "onServiceConnected success");
    this.a.a = false;
    WadlProxyServiceManager.a(this.a, IWadlService.Stub.a(paramIBinder));
    try
    {
      WadlProxyServiceManager.a(this.a).a(WadlProxyServiceManager.a(this.a));
      WadlProxyServiceManager.a(this.a);
      a();
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        try
        {
          WadlProxyServiceManager.a(this.a).asBinder().linkToDeath(WadlProxyServiceManager.a(this.a), 0);
          return;
        }
        catch (RemoteException paramComponentName)
        {
          paramComponentName.printStackTrace();
        }
        paramComponentName = paramComponentName;
        paramComponentName.printStackTrace();
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    WLog.b("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      WadlProxyServiceManager.a(this.a).getApplication().unbindService(WadlProxyServiceManager.a(this.a));
      if (WadlProxyServiceManager.a(this.a) != null) {
        WadlProxyServiceManager.a(this.a).a();
      }
      if (WadlProxyServiceManager.a(this.a) != null) {
        WadlProxyServiceManager.a(this.a).b(WadlProxyServiceManager.a(this.a));
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    finally
    {
      WadlProxyServiceManager.a(this.a, null);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angm
 * JD-Core Version:    0.7.0.1
 */