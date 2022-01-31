import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.ISmartDeviceService;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.util.ArrayList;

public class amol
  implements Runnable
{
  public amol(SmartDeviceIPCHost paramSmartDeviceIPCHost) {}
  
  public void run()
  {
    for (;;)
    {
      Bundle localBundle;
      if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        localBundle = (Bundle)this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (localBundle != null) {}
      }
      else
      {
        return;
      }
      String str = localBundle.getString("notify_cmd");
      try
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "qq->plugin post to main thread doPostCachedMsg strNotifyCmd:" + str + " thread:" + Thread.currentThread());
        }
        this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", localBundle);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amol
 * JD-Core Version:    0.7.0.1
 */