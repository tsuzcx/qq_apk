import android.os.Bundle;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class binp
  implements biyx
{
  public binp(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(biyc parambiyc)
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success info.uin=" + bipr.a(parambiyc.a));
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a).a().a(OpenSelectPermissionFragment.a(this.a), parambiyc);
    OpenSelectPermissionFragment.a(this.a);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail");
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a, anni.a(2131699946), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binp
 * JD-Core Version:    0.7.0.1
 */