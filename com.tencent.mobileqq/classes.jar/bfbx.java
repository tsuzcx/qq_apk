import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.SSOAccountObserver;

public class bfbx
  extends SSOAccountObserver
{
  public bfbx(AuthorityActivity paramAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.i = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      bfng.a().a("agent_login", this.a.d, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      bfnj.a().a(1, "LOGIN_GETTICKT", paramString, AuthorityActivity.jdField_e_of_type_JavaLangString, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      bfhz.a().a(paramString, "", AuthorityActivity.jdField_e_of_type_JavaLangString, "1", "1", "" + paramInt1, false);
      bfhz.a().a(paramString, "", AuthorityActivity.jdField_e_of_type_JavaLangString, "1", "6", "" + paramInt1, false);
      aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
      aseh.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.a.jdField_a_of_type_Long, null, true);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + bfii.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        this.a.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
        bflp.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.jdField_e_of_type_Long - this.a.d));
        if ((paramInt1 == 1002) && (this.a.b < 2))
        {
          paramString = this.a;
          paramString.b += 1;
          this.a.f();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bflp.c("Authority_Report", "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131695065));
      paramString = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131695065);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramString);
      return;
    }
    this.a.c(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramBundle.getBoolean("fake_callback");
    if ((!bool) && (paramInt == 4096)) {
      bfnz.a(paramString, l);
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
      ((Bundle)localObject).putString("intext_5", "" + (l - AuthorityActivity.a(this.a).jdField_a_of_type_Long));
      bfhz.a().a((Bundle)localObject, AuthorityActivity.jdField_e_of_type_JavaLangString, paramString, false);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + bfii.a(paramString) + " | ret : success | code: " + i);
      bflp.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.jdField_e_of_type_Long - this.a.d));
    }
    try
    {
      bfng.a().a("agent_login", this.a.d, this.a.jdField_a_of_type_JavaLangString.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null);
      bfnj.a().a(0, "LOGIN_GETTICKT", paramString, AuthorityActivity.jdField_e_of_type_JavaLangString, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      bfhz.a().a(paramString, "", AuthorityActivity.jdField_e_of_type_JavaLangString, "1", "1", "0", false);
      this.a.i = false;
      this.a.b = 0;
      localObject = null;
      if (paramInt == 4096) {
        localObject = new String(paramArrayOfByte);
      }
      this.a.a(paramString, (String)localObject, paramBundle);
      this.a.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bflp.c("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    this.a.b = 0;
    this.a.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
    bflp.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.jdField_e_of_type_Long - this.a.d));
    aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
    aseh.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, this.a.jdField_a_of_type_Long, null, false);
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + bfii.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbx
 * JD-Core Version:    0.7.0.1
 */