import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class blzy
  implements ServiceConnection
{
  blzy(blzs paramblzs) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_Blzz = bmaa.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (aocn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    this.a.a(paramComponentName.a(), paramComponentName.d(), paramComponentName.e(), paramComponentName.f(), paramComponentName.a());
    blzs.d(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(blzs.a(this.a));
    this.a.jdField_a_of_type_Blzz = null;
    this.a.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzy
 * JD-Core Version:    0.7.0.1
 */