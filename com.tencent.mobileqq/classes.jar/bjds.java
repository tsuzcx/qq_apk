import android.os.Bundle;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bjds
  implements bjqi
{
  public bjds(OpenAuthorityFragment paramOpenAuthorityFragment, int paramInt) {}
  
  public void a(bjpl parambjpl)
  {
    OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, null);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket success info.uin=" + bjhh.a(parambjpl.a), ", triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (OpenAuthorityFragment.i(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment)) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket success Activity Finishing");
    }
    do
    {
      return;
      OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a().a(OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), parambjpl);
      if (this.jdField_a_of_type_Int == 1)
      {
        long l = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a();
        parambjpl = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
        OpenAuthorityFragment.e(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, System.currentTimeMillis());
        OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a(OpenAuthorityFragment.f(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), OpenAuthorityFragment.f(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), OpenAuthorityFragment.c(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), parambjpl, l, this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.a, bjhh.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity()), this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity());
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
    if (OpenAuthorityFragment.i(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment)) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket onFail Activity Finishing");
    }
    do
    {
      return;
      boolean bool = aojy.a().a(paramBundle);
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket checkIMBlockByBundle uin: " + paramString + " isIMBlock: " + bool);
      bjhh.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity(), anvx.a(2131707307), false);
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.c(paramString);
    } while (this.jdField_a_of_type_Int != 1);
    bjhg.a(OpenAuthorityFragment.b(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), "0X800B65F");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjds
 * JD-Core Version:    0.7.0.1
 */