import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class bmkj
  implements ServiceConnection
{
  bmkj(bmkd parambmkd) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bmkk = bmkl.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (aogj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    this.a.a(paramComponentName.a(), paramComponentName.d(), paramComponentName.e(), paramComponentName.f(), paramComponentName.a());
    bmkd.d(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(bmkd.a(this.a));
    this.a.jdField_a_of_type_Bmkk = null;
    this.a.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkj
 * JD-Core Version:    0.7.0.1
 */