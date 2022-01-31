import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Messenger;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class anuq
  implements IBinder.DeathRecipient
{
  anuq(anul paramanul) {}
  
  public void binderDied()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("MessengerService$IncomingHandler", 2, "-->binder died");
      MessengerService.a((MessengerService)this.a.a.get());
      MessengerService.b((MessengerService)this.a.a.get());
    }
    MessengerService localMessengerService;
    if (this.a.a != null)
    {
      localMessengerService = (MessengerService)this.a.a.get();
      if ((localMessengerService == null) || (localMessengerService.a == null)) {}
    }
    try
    {
      localMessengerService.a.getBinder().unlinkToDeath(anul.a(this.a), 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MessengerService$IncomingHandler", 1, "-->binder died unlink to death error=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anuq
 * JD-Core Version:    0.7.0.1
 */