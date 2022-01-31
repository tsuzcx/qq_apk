import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;

class bkin
  implements ServiceConnection
{
  bkin(bkil parambkil) {}
  
  public void a()
  {
    if ((bkil.a(this.a) != null) && (!bkil.a(this.a).b())) {
      bkil.a(this.a).b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bfrz.c("WadlProxyServiceManager", "onServiceConnected success");
    this.a.a = false;
    bkil.a(this.a, bkie.a(paramIBinder));
    if ((bkil.a(this.a)) || (bkil.a(this.a) == null))
    {
      bfrz.c("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=" + bkil.a(this.a) + ",mWadlService=" + bkil.a(this.a));
      return;
    }
    try
    {
      bkil.a(this.a).a(bkil.a(this.a));
      bkil.a(this.a);
      a();
      try
      {
        bkil.a(this.a).asBinder().linkToDeath(bkil.a(this.a), 0);
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
    bfrz.c("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      BaseApplicationImpl.getApplication().unbindService(bkil.a(this.a));
      if (bkil.a(this.a) != null) {
        bkil.a(this.a).a();
      }
      if (bkil.a(this.a) != null) {
        bkil.a(this.a).b(bkil.a(this.a));
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
      bkil.a(this.a, null);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkin
 * JD-Core Version:    0.7.0.1
 */