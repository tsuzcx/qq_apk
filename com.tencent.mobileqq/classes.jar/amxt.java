import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface.Stub;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy;

public class amxt
  implements ServiceConnection
{
  public amxt(QQIndividualityRemoteProxy paramQQIndividualityRemoteProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_CooperationQqindividualityIpcIQQIndividualityRemoteProxyInterface = IQQIndividualityRemoteProxyInterface.Stub.a(paramIBinder);
    if (this.a.jdField_a_of_type_CooperationQqindividualityIpcIQQIndividualityRemoteProxyInterface != null)
    {
      paramComponentName = new amxu(this);
      paramComponentName.setName("QfavRemoteProxyForQQ.remoteProxyCallThread");
      paramComponentName.start();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_CooperationQqindividualityIpcIQQIndividualityRemoteProxyInterface = null;
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxt
 * JD-Core Version:    0.7.0.1
 */