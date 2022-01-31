import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqdataline.ipc.IDatalineService.Stub;
import mqq.app.MobileQQ;

public class amor
  implements ServiceConnection
{
  public amor(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = IDatalineService.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    this.a.a(paramComponentName.a(), paramComponentName.g(), paramComponentName.h(), paramComponentName.i(), paramComponentName.a());
    DatalineRemoteManager.c(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(DatalineRemoteManager.a(this.a));
    this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = null;
    this.a.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amor
 * JD-Core Version:    0.7.0.1
 */