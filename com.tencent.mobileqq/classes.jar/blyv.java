import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class blyv
  implements ServiceConnection
{
  blyv(blyu paramblyu) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    blyu.a(this.a, blxz.a(paramIBinder));
    blyu.a(this.a, false);
    blyu.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + paramComponentName);
    try
    {
      blyu.a(this.a).getApplication().unbindService(blyu.a(this.a));
      blyu.a(this.a, null);
      blyu.a(this.a, false);
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blyv
 * JD-Core Version:    0.7.0.1
 */