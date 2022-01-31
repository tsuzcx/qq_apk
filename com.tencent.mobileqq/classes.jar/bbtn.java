import android.os.Bundle;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bbtn
  implements bcjv
{
  public bbtn(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, long paramLong) {}
  
  public void a()
  {
    QLog.d("AgentActivity", 1, "--> getTicketNoPasswd onFail");
    apmt.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
  }
  
  public void a(bciz parambciz)
  {
    QLog.d("AgentActivity", 1, new Object[] { "start_auth_use_time", " getTicketNoPasswd onSuccess", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    apmt.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", parambciz);
    this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.a.a().a(this.b, parambciz);
    preAuth.PreAuthRequest localPreAuthRequest = this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.a.a().a(parambciz, this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity), this.b, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.a.a().a(localPreAuthRequest, this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, parambciz, new bbto(this), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbtn
 * JD-Core Version:    0.7.0.1
 */