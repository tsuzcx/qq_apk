import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;

class bibt
  implements ServiceConnection
{
  bibt(bibr parambibr) {}
  
  public void a()
  {
    if ((bibr.a(this.a) != null) && (!bibr.a(this.a).b())) {
      bibr.a(this.a).b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bdoe.b("WadlProxyServiceManager", "onServiceConnected success");
    this.a.a = false;
    bibr.a(this.a, bibk.a(paramIBinder));
    if ((bibr.a(this.a)) || (bibr.a(this.a) == null))
    {
      bdoe.b("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=" + bibr.a(this.a) + ",mWadlService=" + bibr.a(this.a));
      return;
    }
    try
    {
      bibr.a(this.a).a(bibr.a(this.a));
      bibr.a(this.a);
      a();
      try
      {
        bibr.a(this.a).asBinder().linkToDeath(bibr.a(this.a), 0);
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
    bdoe.b("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      BaseApplicationImpl.getApplication().unbindService(bibr.a(this.a));
      if (bibr.a(this.a) != null) {
        bibr.a(this.a).a();
      }
      if (bibr.a(this.a) != null) {
        bibr.a(this.a).b(bibr.a(this.a));
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
      bibr.a(this.a, null);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibt
 * JD-Core Version:    0.7.0.1
 */