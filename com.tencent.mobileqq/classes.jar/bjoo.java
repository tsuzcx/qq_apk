import android.os.Bundle;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bjoo
  implements bjzw
{
  public bjoo(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(bjzb parambjzb)
  {
    OpenSelectPermissionFragment.a(this.a, null);
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success info.uin=" + bjqq.a(parambjzb.a));
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a).a().a(OpenSelectPermissionFragment.a(this.a), parambjzb);
    OpenSelectPermissionFragment.a(this.a);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    OpenSelectPermissionFragment.a(this.a, null);
    QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail");
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a, anzj.a(2131700053), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoo
 * JD-Core Version:    0.7.0.1
 */