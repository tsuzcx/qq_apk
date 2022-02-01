import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.remote.SendMsg;

class blxw
  implements ServiceConnection
{
  blxw(blxv paramblxv) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + paramComponentName + ",mActionListener:" + blxv.a(this.a));
    }
    this.a.a = blxs.a(paramIBinder);
    if (blxv.a(this.a) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.a = blxv.a(this.a);
      this.a.b(paramComponentName);
    }
    this.a.a();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName + ",mActionListener:" + blxv.a(this.a));
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxw
 * JD-Core Version:    0.7.0.1
 */