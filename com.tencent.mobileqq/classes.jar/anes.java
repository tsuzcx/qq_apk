import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class anes
  implements ServiceConnection
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  
  public anes(aneq paramaneq, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
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
        synchronized (aneq.a(this.jdField_a_of_type_Aneq))
        {
          do
          {
            paramIBinder = (anes)aneq.a(this.jdField_a_of_type_Aneq).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZonePluginManger", 2, "continue process");
            }
            aneq.a(this.jdField_a_of_type_Aneq, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("QZonePluginManger", 2, "unbindService, " + this);
        }
      }
      aneq.a(this.jdField_a_of_type_Aneq, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anes
 * JD-Core Version:    0.7.0.1
 */