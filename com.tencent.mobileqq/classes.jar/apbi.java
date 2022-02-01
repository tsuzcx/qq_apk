import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class apbi
  implements ServiceConnection
{
  apbi(apbh paramapbh) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    apbh.a(this.a, apij.a(paramIBinder));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceConnected ARGlobalRemoteManager=" + apbh.a(this.a));
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    apbh.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceDisconnected ARGlobalRemoteManager=" + apbh.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbi
 * JD-Core Version:    0.7.0.1
 */