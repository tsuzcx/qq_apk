import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class amny
  implements ServiceConnection
{
  amny(amnx paramamnx) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    amnx.a(this.a, amuy.a(paramIBinder));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceConnected ARGlobalRemoteManager=" + amnx.a(this.a));
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    amnx.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceDisconnected ARGlobalRemoteManager=" + amnx.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amny
 * JD-Core Version:    0.7.0.1
 */