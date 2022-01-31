import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class bhwd
  implements ServiceConnection
{
  bhwd(bhwb parambhwb) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bhwb.a(this.a).removeMessages(1);
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_Bhvy = bhvz.a(paramIBinder);
    this.a.b();
    QLog.d("SmartDeviceIPCHost", 1, "plugin service connected");
    ymw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Host", 0, 1, 0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(this.a.jdField_a_of_type_AndroidContentServiceConnection);
      label20:
      this.a.jdField_a_of_type_Bhvy = null;
      this.a.jdField_a_of_type_Boolean = false;
      QLog.d("SmartDeviceIPCHost", 1, "plugin service disconnected");
      return;
    }
    catch (Exception paramComponentName)
    {
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhwd
 * JD-Core Version:    0.7.0.1
 */