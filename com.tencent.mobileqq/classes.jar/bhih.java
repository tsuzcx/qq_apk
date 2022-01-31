import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class bhih
  implements ServiceConnection
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  
  public bhih(bhig parambhig, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
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
        synchronized (bhig.a(this.jdField_a_of_type_Bhig))
        {
          do
          {
            paramIBinder = (bhih)bhig.a(this.jdField_a_of_type_Bhig).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZonePluginManger", 2, "continue process");
            }
            bhig.a(this.jdField_a_of_type_Bhig, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("QZonePluginManger", 2, "unbindService, " + this);
        }
      }
      bhig.a(this.jdField_a_of_type_Bhig, false);
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
 * Qualified Name:     bhih
 * JD-Core Version:    0.7.0.1
 */