import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.AccountPanel.17.1;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class ayzo
  extends AccountObserver
{
  ayzo(ayzg paramayzg) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (ayzg.a(this.a) != null)) {
      ayzg.a(this.a).a(paramStatus);
    }
    if (!paramBoolean2) {
      return;
    }
    ThreadManager.getUIHandler().post(new AccountPanel.17.1(this, paramBoolean1, paramStatus));
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzo
 * JD-Core Version:    0.7.0.1
 */