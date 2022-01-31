import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService.Stub;
import com.tencent.qqmini.sdk.log.QMLog;

class bgtx
  implements ServiceConnection
{
  bgtx(bgtv parambgtv) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bgtv.a(this.a, IAppMainService.Stub.asInterface(paramIBinder));
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceConnected:" + bgtv.a(this.a));
    bgtv.a(this.a, false);
    bgtv.a(this.a);
    bgtv.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bgtv.a(this.a, null);
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    bgtv.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtx
 * JD-Core Version:    0.7.0.1
 */