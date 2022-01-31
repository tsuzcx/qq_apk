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

public class bbtq
  extends BroadcastReceiver
{
  public bbtq(AgentActivity paramAgentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (this.a.getAppInterface() != null)) {
      QLog.d("AgentActivity", 2, "-->onReceive, intent.getAction(): " + paramIntent.getAction());
    }
    if ("action_login_sucess".equals(paramIntent.getAction())) {
      if (AgentActivity.a(this.a) != null)
      {
        paramContext = bcam.a(paramIntent, "login_success_uin");
        if (!TextUtils.isEmpty(paramContext)) {
          AgentActivity.a(this.a).putExtra("login_success_uin", paramContext);
        }
        if (AgentActivity.a(this.a).getIntExtra("intent_router", 0) != 1) {
          break label305;
        }
        abju.a(this.a, AgentActivity.a(this.a), PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
      }
    }
    for (;;)
    {
      if ((AgentActivity.a(this.a)) && (!this.a.a.isLogin()))
      {
        paramContext = this.a.a.getAccount();
        QLog.i("AgentActivity", 1, "mLonginReceiver() OpenSDKAppinterface not login, logined uin= " + paramContext);
        paramIntent = this.a.a.getApplication().getAllAccounts();
        if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty(paramContext)))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)paramIntent.next();
            if (paramContext.equals(localSimpleAccount.getUin()))
            {
              this.a.a.login(localSimpleAccount);
              QLog.i("AgentActivity", 2, "mLonginReceiver() OpenSDKAppinterface do login uin= " + paramContext);
            }
          }
        }
      }
      this.a.unregisterReceiver(this);
      return;
      label305:
      this.a.startActivityForResult(AgentActivity.a(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbtq
 * JD-Core Version:    0.7.0.1
 */