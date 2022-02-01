import android.os.Bundle;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bhud
  implements bifg
{
  public bhud(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(biej parambiej)
  {
    OpenSelectPermissionFragment.a(this.a, null);
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success info.uin=" + bhwf.a(parambiej.a));
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a).a().a(OpenSelectPermissionFragment.a(this.a), parambiej);
    OpenSelectPermissionFragment.b(this.a);
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
    OpenSelectPermissionFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhud
 * JD-Core Version:    0.7.0.1
 */