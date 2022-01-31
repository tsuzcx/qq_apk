import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class auhh
  extends ajto
{
  public auhh(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  protected void onGetAutoReplyList(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, String.format("onGetAutoReplyList, isSuccess: %s, selectId: %s, replyList: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
    }
    if (AccountOnlineStateActivity.a(this.a) != null) {
      AccountOnlineStateActivity.a(this.a).runOnUiThread(new AccountOnlineStateActivity.4.1(this, paramBoolean, paramList));
    }
  }
  
  protected void onSetAutoReplyList(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aujj localaujj = AccountOnlineStateActivity.a(this.a).a();
      AppRuntime.Status localStatus = aujc.a().a(localaujj);
      if ((localStatus != null) && (localaujj.a != aujc.a().a(AccountOnlineStateActivity.a(this.a))))
      {
        AccountOnlineStateActivity.a(this.a, true);
        AccountOnlineStateActivity.a(this.a).a(localStatus, localaujj.a);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onSetAutoReplyList, isSuccess: " + paramBoolean);
      }
      return;
      AccountOnlineStateActivity.a(this.a, true, 0);
      continue;
      AccountOnlineStateActivity.a(this.a, false, -2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhh
 * JD-Core Version:    0.7.0.1
 */