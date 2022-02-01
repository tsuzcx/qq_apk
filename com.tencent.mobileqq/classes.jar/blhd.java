import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo.1;

public class blhd
  implements ServiceConnection
{
  public blhd(QQDeviceInfo.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = blvb.a(paramIBinder);
      try
      {
        blhc.d(paramComponentName.a());
        blhc.a("huawei_oaid", blhc.d());
        if (QLog.isColorLevel()) {
          QLog.d(blhc.a, 2, "huawei oaid = " + blhc.d());
        }
        return;
      }
      catch (SecurityException paramComponentName)
      {
        paramComponentName.printStackTrace();
        QLog.e(blhc.a, 2, paramComponentName, new Object[0]);
        return;
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      QLog.e(blhc.a, 2, "get huawei oaid throw e", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blhd
 * JD-Core Version:    0.7.0.1
 */