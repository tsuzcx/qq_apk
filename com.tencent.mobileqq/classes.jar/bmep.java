import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class bmep
  implements ServiceConnection
{
  bmep(bmen parambmen) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_Loc = lod.a(paramIBinder);
    if ((this.a.jdField_a_of_type_Loc != null) && (this.a.jdField_a_of_type_Bmeo != null)) {
      this.a.jdField_a_of_type_Bmeo.a(this.a);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null or mOnReadyListener == null");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "Qav Service disconnected!");
    }
    this.a.jdField_a_of_type_Loc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmep
 * JD-Core Version:    0.7.0.1
 */