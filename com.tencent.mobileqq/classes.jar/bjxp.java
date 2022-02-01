import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class bjxp
  implements ServiceConnection
{
  bjxp(bjxo parambjxo) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bjxo.a(this.a, awya.a(paramIBinder));
    try
    {
      if (bjxo.a(this.a) != null) {
        bjxo.a(this.a).a(bjxo.a(this.a));
      }
      if (paramIBinder != null) {
        paramIBinder.linkToDeath(new bjxq(this, paramIBinder), 0);
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
      if (bjxo.a(this.a) != null)
      {
        bjxo.a(this.a).b(bjxo.a(this.a));
        bjxo.a(this.a, null);
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
 * Qualified Name:     bjxp
 * JD-Core Version:    0.7.0.1
 */