import android.os.Bundle;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

public class bizy
  extends SSOAccountObserver
{
  public bizy(AgentActivity paramAgentActivity, boolean paramBoolean) {}
  
  private void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_sso_ret", paramInt);
    localBundle.putString("uin", paramString);
    localBundle.putBoolean("is_from_login", this.jdField_a_of_type_Boolean);
    bizq.a(localBundle);
    this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.jdField_a_of_type_Boolean = true;
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.finish();
    if ((arct.a()) && (AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity) != null))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onSsoLoginComplete--unregisterReceiver");
      this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.unregisterReceiver(AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity));
      AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    }
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onFailed--", bjhh.a(paramString) });
    a(paramString, paramInt2);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onLoginSuccess--", bjhh.a(paramString) });
    bizp.a().a(paramString);
    bizq.a(paramString);
    a(paramString, 0);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onUserCancel--", bjhh.a(paramString) });
    a(paramString, 2006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bizy
 * JD-Core Version:    0.7.0.1
 */