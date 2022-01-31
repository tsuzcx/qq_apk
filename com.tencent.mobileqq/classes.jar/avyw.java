import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.AccountPanel.18.1;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class avyw
  extends AccountObserver
{
  avyw(avyo paramavyo) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (avyo.a(this.a) != null)) {
      avyo.a(this.a).a(paramStatus);
    }
    if (!paramBoolean2) {
      return;
    }
    ThreadManager.getUIHandler().post(new AccountPanel.18.1(this, paramBoolean1, paramStatus));
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyw
 * JD-Core Version:    0.7.0.1
 */