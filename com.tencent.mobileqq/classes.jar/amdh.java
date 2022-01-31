import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

public class amdh
  extends SSOAccountObserver
{
  public amdh(Login paramLogin) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str = paramBundle.getString("error");
    try
    {
      int i = paramBundle.getInt("code");
      ReportManager.a().a("agent_login", this.a.jdField_a_of_type_Long, 0L, 0L, i, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      label72:
      if (QLog.isColorLevel()) {
        QLog.d("SSOAccountObserver", 2, "onFail:account=" + paramString + " action=" + paramInt1 + " ret=" + paramInt2);
      }
      Message localMessage = new Message();
      paramInt1 = paramBundle.getInt("code");
      if (paramInt2 == -1000) {
        localMessage.what = 1;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        QLog.d("Login", 1, "rec | cmd:  | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
        return;
        localMessage.what = 2;
        paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
        Bundle localBundle = localMessage.getData();
        localBundle.putInt("ret", paramInt2);
        localBundle.putInt("code", paramInt1);
        if (paramBundle != null) {
          localBundle.putString("OTHER_ERROR", paramBundle.getMessage());
        }
        for (;;)
        {
          if (!this.a.jdField_b_of_type_Boolean) {
            break label322;
          }
          localBundle.putBoolean("pwdblank", true);
          break;
          localBundle.putString("OTHER_ERROR", this.a.getResources().getString(2131435619));
        }
        label322:
        localBundle.putBoolean("pwdblank", false);
      }
    }
    catch (Exception localException)
    {
      break label72;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    }
    for (;;)
    {
      this.a.a(paramString, paramArrayOfByte, paramBundle);
      paramInt = paramBundle.getInt("code");
      QLog.d("Login", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success | code: " + paramInt);
      try
      {
        paramBundle = ReportManager.a();
        long l2 = this.a.jdField_a_of_type_Long;
        long l3 = this.a.jdField_b_of_type_Long;
        if (paramArrayOfByte == null) {}
        int i;
        for (long l1 = 0L;; l1 = i)
        {
          paramBundle.a("agent_login", l2, l3, l1, paramInt, Long.parseLong(paramString), "1000069", null);
          return;
          i = paramArrayOfByte.length();
        }
        paramArrayOfByte = null;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    }
    for (;;)
    {
      this.a.a(paramString, paramArrayOfByte, paramBundle);
      paramInt = paramBundle.getInt("code");
      QLog.d("Login", 1, "rec | cmd: s_s_o_l | uin : *" + AuthorityUtil.a(paramString) + " | ret : success | code: " + paramInt);
      try
      {
        paramBundle = ReportManager.a();
        long l2 = this.a.jdField_a_of_type_Long;
        long l3 = this.a.jdField_b_of_type_Long;
        if (paramArrayOfByte == null) {}
        for (long l1 = 0L;; l1 = paramInt)
        {
          paramBundle.a("agent_login", l2, l3, l1, 0, Long.parseLong(paramString), "1000069", null);
          return;
          paramInt = paramArrayOfByte.length();
        }
        paramArrayOfByte = null;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOAccountObserver", 2, "onUserCancel ssoAccount=" + paramString + " action=" + paramInt);
    }
    this.a.d();
    paramInt = paramBundle.getInt("code");
    QLog.d("Login", 1, "rec | cmd:  | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amdh
 * JD-Core Version:    0.7.0.1
 */