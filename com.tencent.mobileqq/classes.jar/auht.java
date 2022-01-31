import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.AccountPanel.18.1;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class auht
  extends AccountObserver
{
  auht(auhk paramauhk) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (auhk.a(this.a) != null)) {
      auhk.a(this.a).a(paramStatus);
    }
    if (!paramBoolean2) {
      return;
    }
    ThreadManager.getUIHandler().post(new AccountPanel.18.1(this, paramBoolean1, paramStatus));
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auht
 * JD-Core Version:    0.7.0.1
 */