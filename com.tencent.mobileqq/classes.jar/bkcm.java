import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class bkcm
  implements ServiceConnection
{
  bkcm(bkck parambkck) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bkck.a(this.a).removeMessages(1);
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bkch = bkci.a(paramIBinder);
    this.a.b();
    QLog.d("SmartDeviceIPCHost", 1, "plugin service connected");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      aagb.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Host", 0, 1, 0);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(this.a.jdField_a_of_type_AndroidContentServiceConnection);
      }
      label30:
      this.a.jdField_a_of_type_Bkch = null;
      this.a.jdField_a_of_type_Boolean = false;
      QLog.d("SmartDeviceIPCHost", 1, "plugin service disconnected");
      return;
    }
    catch (Exception paramComponentName)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcm
 * JD-Core Version:    0.7.0.1
 */