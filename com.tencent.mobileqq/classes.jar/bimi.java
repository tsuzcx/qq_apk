import android.os.Bundle;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bimi
  implements biyx
{
  public bimi(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(biyc parambiyc)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket success info.uin=" + bipr.a(parambiyc.a));
    if (OpenAuthorityFragment.i(this.a))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket success Activity Finishing");
      return;
    }
    OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a), parambiyc);
    long l = OpenAuthorityFragment.a(this.a).a();
    parambiyc = OpenAuthorityFragment.a(this.a);
    OpenAuthorityFragment.a(this.a).a(OpenAuthorityFragment.f(this.a), OpenAuthorityFragment.f(this.a), OpenAuthorityFragment.c(this.a), parambiyc, l, this.a.a, bipr.a(this.a.getActivity()), this.a.getActivity());
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket onFail");
    if (OpenAuthorityFragment.i(this.a))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    boolean bool = aobl.a().a(paramBundle);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket checkIMBlockByBundle uin: " + paramString + " isIMBlock: " + bool);
    this.a.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimi
 * JD-Core Version:    0.7.0.1
 */