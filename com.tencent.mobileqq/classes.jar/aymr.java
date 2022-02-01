import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qphone.base.util.QLog;

public class aymr
  extends aypl
{
  public aymr(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, new Object[] { "onSetOnlineStatus, isSuccess: ", Boolean.valueOf(paramBoolean), " , mIsUpdateStatus: ", Boolean.valueOf(AccountOnlineStateActivity.a(this.a)) });
    }
    if (AccountOnlineStateActivity.a(this.a))
    {
      AccountOnlineStateActivity.a(this.a, false);
      if (paramBoolean) {
        AccountOnlineStateActivity.a(this.a, true, 0);
      }
    }
    else
    {
      return;
    }
    AccountOnlineStateActivity.a(this.a, false, -1);
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    int i = paramBundle.getInt("StatusId");
    if (!paramBoolean) {
      AccountOnlineStateActivity.a(this.a, false, -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, new Object[] { "onSetExtInfo: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean), " statusId", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymr
 * JD-Core Version:    0.7.0.1
 */