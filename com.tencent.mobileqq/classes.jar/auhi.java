import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class auhi
  extends AccountObserver
{
  public auhi(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onOnlineStatusChanged, isSuccess: " + paramBoolean1 + " , mIsUpdateStatus: " + AccountOnlineStateActivity.a(this.a) + ", isUserSet: " + paramBoolean2);
    }
    if (AccountOnlineStateActivity.a(this.a))
    {
      AccountOnlineStateActivity.a(this.a, false);
      if (paramBoolean1) {
        AccountOnlineStateActivity.a(this.a, true, 0);
      }
    }
    else
    {
      return;
    }
    AccountOnlineStateActivity.a(this.a, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhi
 * JD-Core Version:    0.7.0.1
 */