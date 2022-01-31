import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1;

public class bfkm
  implements ServiceConnection
{
  bfkm(bfkl parambfkl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Bfkb = bfkc.a(paramIBinder);
    if (this.a.jdField_a_of_type_Bfkb != null)
    {
      paramComponentName = new QQIndividualityRemoteProxy.2.1(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_Bfkb = null;
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfkm
 * JD-Core Version:    0.7.0.1
 */