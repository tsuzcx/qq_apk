import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class bneb
  implements ServiceConnection
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  
  public bneb(bnea parambnea, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
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
        synchronized (bnea.a(this.jdField_a_of_type_Bnea))
        {
          do
          {
            paramIBinder = (bneb)bnea.a(this.jdField_a_of_type_Bnea).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZonePluginManger", 2, "continue process");
            }
            bnea.a(this.jdField_a_of_type_Bnea, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("QZonePluginManger", 2, "unbindService, " + this);
        }
      }
      bnea.a(this.jdField_a_of_type_Bnea, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneb
 * JD-Core Version:    0.7.0.1
 */