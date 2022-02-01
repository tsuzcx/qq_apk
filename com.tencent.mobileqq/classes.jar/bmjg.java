import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class bmjg
  implements ServiceConnection
{
  bmjg(bmjf parambmjf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    bmjf.a(this.a, bmik.a(paramIBinder));
    bmjf.a(this.a, false);
    bmjf.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + paramComponentName);
    try
    {
      bmjf.a(this.a).getApplication().unbindService(bmjf.a(this.a));
      bmjf.a(this.a, null);
      bmjf.a(this.a, false);
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
 * Qualified Name:     bmjg
 * JD-Core Version:    0.7.0.1
 */