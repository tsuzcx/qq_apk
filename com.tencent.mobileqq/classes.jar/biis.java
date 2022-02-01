import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;

class biis
  implements biyy
{
  biis(biir parambiir) {}
  
  public void a()
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "preAuthWithRetry onSuccess");
    AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "preAuthWithRetry onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    if ((paramInt == 110530) || (paramInt == 1002))
    {
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, false);
      return;
    }
    if (paramInt == 110509)
    {
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b);
      return;
    }
    if (paramInt == 110513)
    {
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, 0, "", "");
      return;
    }
    String str;
    if (paramInt == -1) {
      str = this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity.getResources().getString(2131694142);
    }
    for (;;)
    {
      ForwardUtils.a(str, this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, new biit(this, paramInt, paramString));
      return;
      if (TextUtils.isEmpty(paramString)) {
        str = String.format(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity.getResources().getString(2131694131), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = String.format(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity.getResources().getString(2131695788), new Object[] { paramString, Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biis
 * JD-Core Version:    0.7.0.1
 */