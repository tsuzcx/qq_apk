import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class apfy
  implements ServiceConnection
{
  apfy(apfw paramapfw) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.w(apgj.a, 1, "onServiceConnected, name[" + paramComponentName + "]");
    try
    {
      this.a.a = aplo.a(paramIBinder);
      this.a.a.a(apfw.a(this.a));
      this.a.a.c();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(apgj.a, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.w(apgj.a, 1, "onServiceDisconnected, name[" + paramComponentName + "]");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfy
 * JD-Core Version:    0.7.0.1
 */