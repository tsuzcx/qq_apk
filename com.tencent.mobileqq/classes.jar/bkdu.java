import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bkdu
  implements ServiceConnection
{
  bkdu(bkds parambkds) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bkdp.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bkds.a(this.a, lxb.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bkdp.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bkds.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdu
 * JD-Core Version:    0.7.0.1
 */