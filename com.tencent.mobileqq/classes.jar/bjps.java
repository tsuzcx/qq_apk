import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class bjps
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceConnected");
    }
    if (bjpr.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      bjpr.a();
      return;
    }
    paramComponentName = (bjpt)bjpr.a().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return OnPluginManagerLoadedListener is null");
      }
      bjpr.a();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder alive");
      }
      bjpr.a = new bjov(bjqd.a(paramIBinder));
      paramComponentName.onQzonePluginClientReady(bjpr.a);
    }
    for (;;)
    {
      bjpr.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder not alive");
      }
      paramComponentName.onQzonePluginClientReady(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    if (bjpr.a != null)
    {
      bjpr.a.b();
      bjpr.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjps
 * JD-Core Version:    0.7.0.1
 */