import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bhpe
  implements bifg
{
  public bhpe(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, long paramLong, String paramString3, int paramInt) {}
  
  public void a(biej parambiej)
  {
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " getTicketNoPasswd onSuccess", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", parambiej);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(this.b, parambiej);
    AgentActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
    long l1 = ForwardUtils.parseLong(this.b);
    long l2 = ForwardUtils.parseLong(this.c);
    preAuth.PreAuthRequest localPreAuthRequest = AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(parambiej, AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity), l1, l2, this.jdField_a_of_type_AndroidOsBundle);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(localPreAuthRequest, this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, parambiej, new bhpf(this), 0);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    QLog.d("SDK_LOGIN.AgentActivity", 1, "--> getTicketNoPasswd onFail");
    atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpe
 * JD-Core Version:    0.7.0.1
 */