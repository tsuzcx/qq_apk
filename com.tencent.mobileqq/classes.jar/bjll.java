import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class bjll
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceConnected");
    }
    if (bjlk.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      bjlk.a();
      return;
    }
    paramComponentName = (bjlm)bjlk.a().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return OnPluginManagerLoadedListener is null");
      }
      bjlk.a();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder alive");
      }
      bjlk.a = new bjko(bjlw.a(paramIBinder));
      paramComponentName.onQzonePluginClientReady(bjlk.a);
    }
    for (;;)
    {
      bjlk.a();
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
    if (bjlk.a != null)
    {
      bjlk.a.b();
      bjlk.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjll
 * JD-Core Version:    0.7.0.1
 */