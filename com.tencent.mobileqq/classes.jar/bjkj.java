import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class bjkj
  implements ServiceConnection
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  
  public bjkj(bjki parambjki, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    do
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.getApplicationContext().unbindService(this);
        if (QLog.isColorLevel()) {
          QLog.i("QZonePluginManger", 2, "onServiceConnected, " + this);
        }
        this.jdField_a_of_type_AndroidContentServiceConnection.onServiceConnected(???, paramIBinder);
      }
      catch (Exception localException)
      {
        synchronized (bjki.a(this.jdField_a_of_type_Bjki))
        {
          do
          {
            paramIBinder = (bjkj)bjki.a(this.jdField_a_of_type_Bjki).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZonePluginManger", 2, "continue process");
            }
            bjki.a(this.jdField_a_of_type_Bjki, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("QZonePluginManger", 2, "unbindService, " + this);
        }
      }
      bjki.a(this.jdField_a_of_type_Bjki, false);
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "queue empty");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "onServiceDisconnected, " + this);
    }
    this.jdField_a_of_type_AndroidContentServiceConnection.onServiceDisconnected(paramComponentName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjkj
 * JD-Core Version:    0.7.0.1
 */