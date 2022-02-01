import android.os.Bundle;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bhsv
  implements bifg
{
  public bhsv(OpenAuthorityFragment paramOpenAuthorityFragment, int paramInt) {}
  
  public void a(biej parambiej)
  {
    OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, null);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket success info.uin=" + bhwf.a(parambiej.a), ", triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (OpenAuthorityFragment.i(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment)) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket success Activity Finishing");
    }
    do
    {
      return;
      OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a().a(OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), parambiej);
      if (this.jdField_a_of_type_Int == 1)
      {
        long l = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a();
        parambiej = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
        OpenAuthorityFragment.e(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, System.currentTimeMillis());
        OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a(OpenAuthorityFragment.f(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), OpenAuthorityFragment.f(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), OpenAuthorityFragment.c(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), parambiej, l, this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.a, bhwf.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity()), this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity());
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        OpenAuthorityFragment.b(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    OpenAuthorityFragment.c(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, null);
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket onFail triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (OpenAuthorityFragment.i(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    boolean bool = anhi.a().a(paramBundle);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket checkIMBlockByBundle uin: " + paramString + " isIMBlock: " + bool);
    bhwf.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity(), amtj.a(2131706961), false);
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsv
 * JD-Core Version:    0.7.0.1
 */