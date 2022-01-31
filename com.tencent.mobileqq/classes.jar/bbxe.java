import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.SSOAccountObserver;

public class bbxe
  extends SSOAccountObserver
{
  public bbxe(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "ssoLoginObserver onFailed");
    this.a.i = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      bcfk.a().a("agent_login", this.a.d, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      bcfn.a().a(1, "LOGIN_GETTICKT", paramString, OpenAuthorityFragment.a(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      bcad.a().a(paramString, "", OpenAuthorityFragment.a(this.a), "1", "1", "" + paramInt1, false);
      bcad.a().a(paramString, "", OpenAuthorityFragment.a(this.a), "1", "6", "" + paramInt1, false);
      apmt.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.a.jdField_a_of_type_Long, null, false);
      apmt.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + bcam.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        this.a.e = SystemClock.elapsedRealtime();
        bcds.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.e - this.a.d));
        if ((paramInt1 == 1002) && (this.a.b < 2))
        {
          paramString = this.a;
          paramString.b += 1;
          this.a.e();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bcds.c("Authority_Report", "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131629228));
      paramString = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131629228);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramString);
      return;
    }
    this.a.c(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "ssoLoginObserver onGetTicketNoPasswd");
    long l = System.currentTimeMillis();
    boolean bool = paramBundle.getBoolean("fake_callback");
    if ((!bool) && (paramInt == 4096)) {
      bcgd.a(paramString, l);
    }
    int i;
    Object localObject;
    if (!bool)
    {
      i = paramBundle.getInt("code");
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "103");
      ((Bundle)localObject).putString("act_type", "10");
      ((Bundle)localObject).putString("stringext_1", "GetTicketNoPassword");
      ((Bundle)localObject).putString("intext_2", "" + i);
      ((Bundle)localObject).putString("intext_5", "" + (l - OpenAuthorityFragment.a(this.a).jdField_a_of_type_Long));
      bcad.a().a((Bundle)localObject, OpenAuthorityFragment.a(this.a), paramString, false);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + bcam.a(paramString) + " | ret : success | code: " + i);
      bcds.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.e - this.a.d));
    }
    try
    {
      bcfk.a().a("agent_login", this.a.d, this.a.jdField_a_of_type_JavaLangString.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null);
      bcfn.a().a(0, "LOGIN_GETTICKT", paramString, OpenAuthorityFragment.a(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      bcad.a().a(paramString, "", OpenAuthorityFragment.a(this.a), "1", "1", "0", false);
      this.a.i = false;
      this.a.b = 0;
      localObject = null;
      if (paramInt == 4096) {
        localObject = new String(paramArrayOfByte);
      }
      this.a.a(paramString, (String)localObject, paramBundle);
      this.a.e = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bcds.c("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "ssoLoginObserver onUserCancel");
    paramInt = paramBundle.getInt("code");
    this.a.b = 0;
    this.a.e = SystemClock.elapsedRealtime();
    bcds.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.e - this.a.d));
    apmt.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.a.jdField_a_of_type_Long, null, false);
    apmt.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + bcam.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbxe
 * JD-Core Version:    0.7.0.1
 */