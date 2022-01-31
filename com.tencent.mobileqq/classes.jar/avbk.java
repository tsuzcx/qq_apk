import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class avbk
  implements ServiceConnection
{
  avbk(avbj paramavbj) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceConnected");
    }
    this.a.jdField_a_of_type_Avbe = avbf.a(paramIBinder);
    try
    {
      this.a.jdField_a_of_type_Avbe.a(this.a.jdField_a_of_type_Avbm);
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceConnected.");
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramComponentName.printStackTrace();
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceDisconnected");
    }
    synchronized (avbj.a(this.a))
    {
      this.a.jdField_a_of_type_Avbe = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceDisConnected.");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avbk
 * JD-Core Version:    0.7.0.1
 */