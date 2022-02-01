import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class bkpy
  implements ServiceConnection
{
  bkpy(bkpx parambkpx) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bkpx.a(this.a, axkc.a(paramIBinder));
    try
    {
      if (bkpx.a(this.a) != null) {
        bkpx.a(this.a).a(bkpx.a(this.a));
      }
      if (paramIBinder != null) {
        paramIBinder.linkToDeath(new bkpz(this, paramIBinder), 0);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("MusicPlayerProxyImpl", 2, "onServiceConnected " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + paramComponentName);
    try
    {
      if (bkpx.a(this.a) != null)
      {
        bkpx.a(this.a).b(bkpx.a(this.a));
        bkpx.a(this.a, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpy
 * JD-Core Version:    0.7.0.1
 */