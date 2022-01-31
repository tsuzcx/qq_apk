import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.open.wadl.WLog;
import cooperation.wadl.ipc.IWadlService;
import cooperation.wadl.ipc.WadlProxyServiceManager;

public class amqg
  implements IBinder.DeathRecipient
{
  public amqg(WadlProxyServiceManager paramWadlProxyServiceManager) {}
  
  public void binderDied()
  {
    WLog.b("WadlProxyServiceManager", "wadl download process is died!");
    WadlProxyServiceManager.a(this.a).asBinder().unlinkToDeath(WadlProxyServiceManager.a(this.a), 0);
    WadlProxyServiceManager.a(this.a, null);
    if (WadlProxyServiceManager.a(this.a))
    {
      WLog.b("WadlProxyServiceManager", "download process died restart service");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqg
 * JD-Core Version:    0.7.0.1
 */