import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;

class bkeg
  implements ServiceConnection
{
  bkeg(bkee parambkee) {}
  
  public void a()
  {
    if ((bkee.a(this.a) != null) && (!bkee.a(this.a).b())) {
      bkee.a(this.a).b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bfnq.c("WadlProxyServiceManager", "onServiceConnected success");
    this.a.a = false;
    bkee.a(this.a, bkdx.a(paramIBinder));
    if ((bkee.a(this.a)) || (bkee.a(this.a) == null))
    {
      bfnq.c("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=" + bkee.a(this.a) + ",mWadlService=" + bkee.a(this.a));
      return;
    }
    try
    {
      bkee.a(this.a).a(bkee.a(this.a));
      bkee.a(this.a);
      a();
      try
      {
        bkee.a(this.a).asBinder().linkToDeath(bkee.a(this.a), 0);
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
    bfnq.c("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      BaseApplicationImpl.getApplication().unbindService(bkee.a(this.a));
      if (bkee.a(this.a) != null) {
        bkee.a(this.a).a();
      }
      if (bkee.a(this.a) != null) {
        bkee.a(this.a).b(bkee.a(this.a));
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
      bkee.a(this.a, null);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkeg
 * JD-Core Version:    0.7.0.1
 */