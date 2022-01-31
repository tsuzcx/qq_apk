import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class bgkb
  implements ServiceConnection
{
  bgkb(bgjz parambgjz) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_Lot = lou.a(paramIBinder);
    if ((this.a.jdField_a_of_type_Lot != null) && (this.a.jdField_a_of_type_Bgka != null)) {
      this.a.jdField_a_of_type_Bgka.a(this.a);
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
    this.a.jdField_a_of_type_Lot = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkb
 * JD-Core Version:    0.7.0.1
 */