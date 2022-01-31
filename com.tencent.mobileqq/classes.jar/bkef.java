import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class bkef
  implements IBinder.DeathRecipient
{
  bkef(bkee parambkee) {}
  
  public void binderDied()
  {
    bfnq.c("WadlProxyServiceManager", "wadl download process is died!");
    bkee.a(this.a).asBinder().unlinkToDeath(bkee.a(this.a), 0);
    bkee.a(this.a, null);
    if ((bkee.a(this.a) != null) && (bkee.a(this.a).a()))
    {
      bfnq.c("WadlProxyServiceManager", "download process died restart service");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkef
 * JD-Core Version:    0.7.0.1
 */