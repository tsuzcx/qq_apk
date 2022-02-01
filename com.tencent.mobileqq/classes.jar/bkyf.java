import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.QQDeviceInfo.1;

public class bkyf
  implements ServiceConnection
{
  public bkyf(QQDeviceInfo.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = blkm.a(paramIBinder);
      try
      {
        QQDeviceInfo.access$002(paramComponentName.a());
        QQDeviceInfo.access$100("huawei_oaid", QQDeviceInfo.access$000());
        if (QLog.isColorLevel()) {
          QLog.d(QQDeviceInfo.TAG, 2, "huawei oaid = " + QQDeviceInfo.access$000());
        }
        return;
      }
      catch (SecurityException paramComponentName)
      {
        paramComponentName.printStackTrace();
        QLog.e(QQDeviceInfo.TAG, 2, paramComponentName, new Object[0]);
        return;
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      QLog.e(QQDeviceInfo.TAG, 2, "get huawei oaid throw e", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkyf
 * JD-Core Version:    0.7.0.1
 */