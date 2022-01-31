import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bepn
  implements ServiceConnection
{
  bepn(bepl parambepl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bepl.a(this.a, bepq.a(paramIBinder));
    betc.c("minisdk-start_AppBrandProxy", "onServiceConnected:" + bepl.a(this.a));
    bepl.a(this.a, false);
    bepl.a(this.a);
    bepl.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bepl.a(this.a, null);
    betc.c("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    bepl.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepn
 * JD-Core Version:    0.7.0.1
 */