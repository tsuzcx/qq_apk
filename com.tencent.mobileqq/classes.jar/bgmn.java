import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.remote.SendMsg;

class bgmn
  implements ServiceConnection
{
  bgmn(bgmm parambgmm) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceConnected service:" + paramComponentName + ",mActionListener:" + bgmm.a(this.a));
    }
    this.a.a = bgmj.a(paramIBinder);
    if (bgmm.a(this.a) != null)
    {
      paramComponentName = new SendMsg("cmd.registerListener");
      paramComponentName.a = bgmm.a(this.a);
      this.a.b(paramComponentName);
    }
    this.a.a();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName + ",mActionListener:" + bgmm.a(this.a));
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmn
 * JD-Core Version:    0.7.0.1
 */