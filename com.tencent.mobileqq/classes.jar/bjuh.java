import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bjuh
  implements ServiceConnection
{
  bjuh(bjuf parambjuf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bjuc.c("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    bjuf.a(this.a, lwz.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bjuc.c("CallingStateMonitor", String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    bjuf.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjuh
 * JD-Core Version:    0.7.0.1
 */