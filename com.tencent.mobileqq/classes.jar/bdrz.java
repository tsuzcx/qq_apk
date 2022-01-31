import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bdrz
  implements ServiceConnection
{
  bdrz(bdrx parambdrx) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bdru.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bdrx.a(this.a, lwx.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bdru.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bdrx.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdrz
 * JD-Core Version:    0.7.0.1
 */