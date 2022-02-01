import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bjjq
  implements bjzw
{
  public bjjq(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, long paramLong, String paramString3) {}
  
  public void a(bjzb parambjzb)
  {
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " getTicketNoPasswd onSuccess", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    avcw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", parambjzb);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(this.b, parambjzb);
    AgentActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
    long l1 = ForwardUtils.a(this.b);
    long l2 = ForwardUtils.a(this.c);
    preAuth.PreAuthRequest localPreAuthRequest = AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(parambjzb, AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity), l1, l2, this.jdField_a_of_type_AndroidOsBundle);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(localPreAuthRequest, this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, parambjzb, new bjjr(this), 0);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    QLog.d("SDK_LOGIN.AgentActivity", 1, "--> getTicketNoPasswd onFail");
    avcw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjjq
 * JD-Core Version:    0.7.0.1
 */