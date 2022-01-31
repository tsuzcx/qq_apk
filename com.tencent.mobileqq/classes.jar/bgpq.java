import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService.Stub;
import com.tencent.qqmini.sdk.log.QMLog;

class bgpq
  implements ServiceConnection
{
  bgpq(bgpo parambgpo) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bgpo.a(this.a, IAppMainService.Stub.asInterface(paramIBinder));
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceConnected:" + bgpo.a(this.a));
    bgpo.a(this.a, false);
    bgpo.a(this.a);
    bgpo.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bgpo.a(this.a, null);
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    bgpo.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpq
 * JD-Core Version:    0.7.0.1
 */