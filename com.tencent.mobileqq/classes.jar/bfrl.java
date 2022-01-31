import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bfrl
  implements ServiceConnection
{
  bfrl(bfrj parambfrj) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bfrg.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bfrj.a(this.a, lzh.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bfrg.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bfrj.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrl
 * JD-Core Version:    0.7.0.1
 */