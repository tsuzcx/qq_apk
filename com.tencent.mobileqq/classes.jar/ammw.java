import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.remote.IServiceHandler.Stub;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;

public class ammw
  implements ServiceConnection
{
  public ammw(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + paramComponentName + ",mActionListener:" + RemoteServiceProxy.a(this.a));
    }
    this.a.a = IServiceHandler.Stub.a(paramIBinder);
    if (RemoteServiceProxy.a(this.a) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.a = RemoteServiceProxy.a(this.a);
      this.a.b(paramComponentName);
    }
    this.a.a();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName + ",mActionListener:" + RemoteServiceProxy.a(this.a));
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammw
 * JD-Core Version:    0.7.0.1
 */