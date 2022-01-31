import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bfvu
  implements ServiceConnection
{
  bfvu(bfvs parambfvs) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bfvp.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bfvs.a(this.a, lzh.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bfvp.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bfvs.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvu
 * JD-Core Version:    0.7.0.1
 */