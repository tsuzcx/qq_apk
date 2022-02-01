import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class bjjt
  extends BroadcastReceiver
{
  public bjjt(AgentActivity paramAgentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.getAppInterface() != null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onReceive, intent.getAction(): " + paramIntent.getAction());
    }
    if ("action_login_sucess".equals(paramIntent.getAction())) {
      if (AgentActivity.a(this.a) != null)
      {
        paramContext = bjqq.a(paramIntent, "login_success_uin");
        if (!TextUtils.isEmpty(paramContext)) {
          AgentActivity.a(this.a).putExtra("login_success_uin", paramContext);
        }
        if (AgentActivity.a(this.a).getIntExtra("intent_router", 0) != 1) {
          break label314;
        }
        afez.a(this.a, AgentActivity.a(this.a), PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
      }
    }
    for (;;)
    {
      boolean bool = paramIntent.getBooleanExtra("forbid_quick_login_after", false);
      if ((AgentActivity.a(this.a)) && (!AgentActivity.a(this.a).isLogin()) && (!bool))
      {
        paramContext = AgentActivity.a(this.a).getAccount();
        QLog.i("SDK_LOGIN.AgentActivity", 1, "mLoginReceiver() OpenSDKAppinterface not login, logined uin= " + paramContext);
        paramIntent = AgentActivity.a(this.a).getApplication().getAllAccounts();
        if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty(paramContext)))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)paramIntent.next();
            if (paramContext.equals(localSimpleAccount.getUin()))
            {
              AgentActivity.a(this.a).login(localSimpleAccount);
              QLog.i("SDK_LOGIN.AgentActivity", 1, "mLoginReceiver() OpenSDKAppinterface do login uin= " + paramContext);
            }
          }
        }
      }
      this.a.unregisterReceiver(this);
      return;
      label314:
      this.a.startActivityForResult(AgentActivity.a(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjjt
 * JD-Core Version:    0.7.0.1
 */