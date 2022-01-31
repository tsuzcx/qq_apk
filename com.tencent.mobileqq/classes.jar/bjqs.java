import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IServiceHandler.Stub;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;

public class bjqs
  implements ServiceConnection
{
  public bjqs(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + paramComponentName + ",mActionListener:" + RemoteServiceProxy.access$000(this.a));
    }
    this.a.serviceHandler = IServiceHandler.Stub.asInterface(paramIBinder);
    if (RemoteServiceProxy.access$000(this.a) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.actionListener = RemoteServiceProxy.access$000(this.a);
      this.a.sendMsg(paramComponentName);
    }
    this.a.onBaseServiceConnected();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName + ",mActionListener:" + RemoteServiceProxy.access$000(this.a));
    }
    this.a.serviceHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqs
 * JD-Core Version:    0.7.0.1
 */