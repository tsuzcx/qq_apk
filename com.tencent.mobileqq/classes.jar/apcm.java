import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class apcm
  implements ServiceConnection
{
  apcm(apck paramapck) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.w(apcx.a, 1, "onServiceConnected, name[" + paramComponentName + "]");
    try
    {
      this.a.a = apid.a(paramIBinder);
      this.a.a.a(apck.a(this.a));
      this.a.a.c();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(apcx.a, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.w(apcx.a, 1, "onServiceDisconnected, name[" + paramComponentName + "]");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcm
 * JD-Core Version:    0.7.0.1
 */