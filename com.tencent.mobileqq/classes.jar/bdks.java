import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class bdks
  implements ServiceConnection
{
  bdks(bdkr parambdkr) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bdkr.a(this.a, bdkv.a(paramIBinder));
    bdnw.c("minisdk-start_AppBrandProxy", "onServiceConnected:" + bdkr.a(this.a));
    bdkr.a(this.a, false);
    bdkr.a(this.a);
    bdkr.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bdkr.a(this.a, null);
    bdnw.c("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    bdkr.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdks
 * JD-Core Version:    0.7.0.1
 */