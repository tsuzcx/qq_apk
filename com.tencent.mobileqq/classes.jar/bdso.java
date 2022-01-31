import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bdso
  implements ServiceConnection
{
  bdso(bdsm parambdsm) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bdsj.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bdsm.a(this.a, lws.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bdsj.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bdsm.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdso
 * JD-Core Version:    0.7.0.1
 */