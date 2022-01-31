import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1;

public class bgrd
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Bgqz = bgra.a(paramIBinder);
    if (this.a.jdField_a_of_type_Bgqz != null)
    {
      paramComponentName = new QfavRemoteProxyForQQ.2.1(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_Bgqz = null;
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrd
 * JD-Core Version:    0.7.0.1
 */