import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class bicj
  implements IBinder.DeathRecipient
{
  bicj(bici parambici) {}
  
  public void binderDied()
  {
    bdot.b("WadlProxyServiceManager", "wadl download process is died!");
    bici.a(this.a).asBinder().unlinkToDeath(bici.a(this.a), 0);
    bici.a(this.a, null);
    if ((bici.a(this.a) != null) && (bici.a(this.a).a()))
    {
      bdot.b("WadlProxyServiceManager", "download process died restart service");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bicj
 * JD-Core Version:    0.7.0.1
 */