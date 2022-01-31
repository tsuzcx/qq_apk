import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class bkim
  implements IBinder.DeathRecipient
{
  bkim(bkil parambkil) {}
  
  public void binderDied()
  {
    bfrz.c("WadlProxyServiceManager", "wadl download process is died!");
    bkil.a(this.a).asBinder().unlinkToDeath(bkil.a(this.a), 0);
    bkil.a(this.a, null);
    if ((bkil.a(this.a) != null) && (bkil.a(this.a).a()))
    {
      bfrz.c("WadlProxyServiceManager", "download process died restart service");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkim
 * JD-Core Version:    0.7.0.1
 */