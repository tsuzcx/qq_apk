import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class beow
  implements ServiceConnection
{
  beow(beou parambeou) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    beou.a(this.a, beoz.a(paramIBinder));
    besl.c("minisdk-start_AppBrandProxy", "onServiceConnected:" + beou.a(this.a));
    beou.a(this.a, false);
    beou.a(this.a);
    beou.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    beou.a(this.a, null);
    besl.c("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    beou.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beow
 * JD-Core Version:    0.7.0.1
 */