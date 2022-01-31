import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.gvideo.IGVServiceForQQ.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoWrapper;
import cooperation.groupvideo.GroupVideoWrapper.OnGVideoReadyListener;

public class amsx
  implements ServiceConnection
{
  public amsx(GroupVideoWrapper paramGroupVideoWrapper) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoRemoteManager", 2, "Qav Service connected!");
    }
    this.a.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ = IGVServiceForQQ.Stub.a(paramIBinder);
    if ((this.a.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ != null) && (this.a.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener != null)) {
      this.a.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper$OnGVideoReadyListener.a(this.a);
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
    this.a.jdField_a_of_type_ComTencentAvGvideoIGVServiceForQQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsx
 * JD-Core Version:    0.7.0.1
 */