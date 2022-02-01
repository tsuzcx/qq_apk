import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class apeu
  implements ServiceConnection
{
  apeu(apet paramapet) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    apet.a(this.a, aplu.a(paramIBinder));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceConnected ARGlobalRemoteManager=" + apet.a(this.a));
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    apet.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceDisconnected ARGlobalRemoteManager=" + apet.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeu
 * JD-Core Version:    0.7.0.1
 */