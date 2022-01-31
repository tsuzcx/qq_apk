import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class bhjj
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceConnected");
    }
    if (bhji.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      bhji.a();
      return;
    }
    paramComponentName = (bhjk)bhji.a().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "return OnPluginManagerLoadedListener is null");
      }
      bhji.a();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "binder alive");
      }
      bhji.a = new bhim(bhju.a(paramIBinder));
      paramComponentName.onQzonePluginClientReady(bhji.a);
    }
    for (;;)
    {
      bhji.a();
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
    if (bhji.a != null)
    {
      bhji.a.b();
      bhji.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhjj
 * JD-Core Version:    0.7.0.1
 */