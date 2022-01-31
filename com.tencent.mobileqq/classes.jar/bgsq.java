import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class bgsq
  implements IBinder.DeathRecipient
{
  bgsq(bgsp parambgsp) {}
  
  public void binderDied()
  {
    bckd.b("WadlProxyServiceManager", "wadl download process is died!");
    bgsp.a(this.a).asBinder().unlinkToDeath(bgsp.a(this.a), 0);
    bgsp.a(this.a, null);
    if ((bgsp.a(this.a) != null) && (bgsp.a(this.a).a()))
    {
      bckd.b("WadlProxyServiceManager", "download process died restart service");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsq
 * JD-Core Version:    0.7.0.1
 */