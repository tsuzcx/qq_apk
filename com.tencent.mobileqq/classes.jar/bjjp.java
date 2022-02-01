import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;

public class bjjp
  extends BroadcastReceiver
{
  public bjjp(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "registerExpiredReceiver onReceive null == intent");
    }
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("serviceCmd");
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "registerExpiredReceiver onReceive serviceCmd=", paramContext });
    } while (!"QQConnectLogin.pre_auth".equals(paramContext));
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjjp
 * JD-Core Version:    0.7.0.1
 */