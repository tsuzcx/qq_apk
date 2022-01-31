import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class bfga
  implements ServiceConnection
{
  bfga(bffz parambffz) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    bffz.a(this.a, bffa.a(paramIBinder));
    bffz.a(this.a, false);
    bffz.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + paramComponentName);
    try
    {
      bffz.a(this.a).getApplication().unbindService(bffz.a(this.a));
      bffz.a(this.a, null);
      bffz.a(this.a, false);
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
 * Qualified Name:     bfga
 * JD-Core Version:    0.7.0.1
 */