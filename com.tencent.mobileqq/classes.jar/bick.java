import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;

class bick
  implements ServiceConnection
{
  bick(bici parambici) {}
  
  public void a()
  {
    if ((bici.a(this.a) != null) && (!bici.a(this.a).b())) {
      bici.a(this.a).b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bdot.b("WadlProxyServiceManager", "onServiceConnected success");
    this.a.a = false;
    bici.a(this.a, bicb.a(paramIBinder));
    if ((bici.a(this.a)) || (bici.a(this.a) == null))
    {
      bdot.b("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=" + bici.a(this.a) + ",mWadlService=" + bici.a(this.a));
      return;
    }
    try
    {
      bici.a(this.a).a(bici.a(this.a));
      bici.a(this.a);
      a();
      try
      {
        bici.a(this.a).asBinder().linkToDeath(bici.a(this.a), 0);
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
    bdot.b("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      BaseApplicationImpl.getApplication().unbindService(bici.a(this.a));
      if (bici.a(this.a) != null) {
        bici.a(this.a).a();
      }
      if (bici.a(this.a) != null) {
        bici.a(this.a).b(bici.a(this.a));
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
      bici.a(this.a, null);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bick
 * JD-Core Version:    0.7.0.1
 */