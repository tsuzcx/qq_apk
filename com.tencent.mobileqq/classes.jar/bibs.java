import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class bibs
  implements IBinder.DeathRecipient
{
  bibs(bibr parambibr) {}
  
  public void binderDied()
  {
    bdoe.b("WadlProxyServiceManager", "wadl download process is died!");
    bibr.a(this.a).asBinder().unlinkToDeath(bibr.a(this.a), 0);
    bibr.a(this.a, null);
    if ((bibr.a(this.a) != null) && (bibr.a(this.a).a()))
    {
      bdoe.b("WadlProxyServiceManager", "download process died restart service");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibs
 * JD-Core Version:    0.7.0.1
 */