import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo.1;

public class bfno
  implements ServiceConnection
{
  public bfno(QQDeviceInfo.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = bgbi.a(paramIBinder);
      try
      {
        bfnn.d(paramComponentName.a());
        bfnn.a("huawei_oaid", bfnn.c());
        if (QLog.isColorLevel()) {
          QLog.d(bfnn.a, 2, "huawei oaid = " + bfnn.c());
        }
        return;
      }
      catch (SecurityException paramComponentName)
      {
        paramComponentName.printStackTrace();
        QLog.e(bfnn.a, 2, paramComponentName, new Object[0]);
        return;
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      QLog.e(bfnn.a, 2, "get huawei oaid throw e", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfno
 * JD-Core Version:    0.7.0.1
 */