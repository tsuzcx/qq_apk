import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bcny
  implements ServiceConnection
{
  bcny(bcnw parambcnw) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bcnt.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bcnw.a(this.a, lmf.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bcnt.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bcnw.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcny
 * JD-Core Version:    0.7.0.1
 */