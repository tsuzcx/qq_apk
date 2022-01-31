import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;

class bgsr
  implements ServiceConnection
{
  bgsr(bgsp parambgsp) {}
  
  public void a()
  {
    if ((bgsp.a(this.a) != null) && (!bgsp.a(this.a).b())) {
      bgsp.a(this.a).b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bckd.b("WadlProxyServiceManager", "onServiceConnected success");
    this.a.a = false;
    bgsp.a(this.a, bgsi.a(paramIBinder));
    if ((bgsp.a(this.a)) || (bgsp.a(this.a) == null))
    {
      bckd.b("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=" + bgsp.a(this.a) + ",mWadlService=" + bgsp.a(this.a));
      return;
    }
    try
    {
      bgsp.a(this.a).a(bgsp.a(this.a));
      bgsp.a(this.a);
      a();
      try
      {
        bgsp.a(this.a).asBinder().linkToDeath(bgsp.a(this.a), 0);
        return;
      }
      catch (RemoteException paramComponentName)
      {
        paramComponentName.printStackTrace();
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bckd.b("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      BaseApplicationImpl.getApplication().unbindService(bgsp.a(this.a));
      if (bgsp.a(this.a) != null) {
        bgsp.a(this.a).a();
      }
      if (bgsp.a(this.a) != null) {
        bgsp.a(this.a).b(bgsp.a(this.a));
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
      bgsp.a(this.a, null);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsr
 * JD-Core Version:    0.7.0.1
 */