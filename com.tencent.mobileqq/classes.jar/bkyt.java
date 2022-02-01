import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class bkyt
  implements ServiceConnection
{
  bkyt(bkys parambkys) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bkys.a(this.a, axqt.a(paramIBinder));
    try
    {
      if (bkys.a(this.a) != null) {
        bkys.a(this.a).a(bkys.a(this.a));
      }
      if (paramIBinder != null) {
        paramIBinder.linkToDeath(new bkyu(this, paramIBinder), 0);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("MusicPlayerProxyImpl", 2, "onServiceConnected " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + paramComponentName);
    try
    {
      if (bkys.a(this.a) != null)
      {
        bkys.a(this.a).b(bkys.a(this.a));
        bkys.a(this.a, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.i("MusicPlayerProxyImpl", 2, "onServiceDisconnected " + paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyt
 * JD-Core Version:    0.7.0.1
 */