import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqdataline.ipc.IDatalineService;
import java.util.ArrayList;

public class amwf
  implements Runnable
{
  public amwf(DatalineRemoteManager paramDatalineRemoteManager) {}
  
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
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + str);
        }
        this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", localBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwf
 * JD-Core Version:    0.7.0.1
 */