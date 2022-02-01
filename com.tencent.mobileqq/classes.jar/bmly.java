import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1;

public class bmly
  implements ServiceConnection
{
  bmly(bmlx parambmlx) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Bmlt = bmlu.a(paramIBinder);
    if (this.a.jdField_a_of_type_Bmlt != null)
    {
      paramComponentName = new QfavRemoteProxyForQQ.2.1(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_Bmlt = null;
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmly
 * JD-Core Version:    0.7.0.1
 */