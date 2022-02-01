import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

class aybm
  implements ServiceConnection
{
  aybm(aybl paramaybl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "onServiceConnected");
    }
    this.a.jdField_a_of_type_Aybg = aybh.a(paramIBinder);
    try
    {
      this.a.jdField_a_of_type_Aybg.a(this.a.jdField_a_of_type_Aybo);
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
    synchronized (aybl.a(this.a))
    {
      this.a.jdField_a_of_type_Aybg = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceDisConnected.");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybm
 * JD-Core Version:    0.7.0.1
 */