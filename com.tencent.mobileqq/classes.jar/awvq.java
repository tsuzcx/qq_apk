import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class awvq
  extends aojs
{
  public awvq(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onTroopManagerFailed result=%s", new Object[] { Integer.valueOf(paramInt2) }));
    }
    if (1 == paramInt1) {
      QQToast.a(LoginWelcomeManager.a(this.a).getApp(), 4, 2131717456, 1).a();
    }
    LoginWelcomeManager.a(this.a).removeObserver(this);
    this.a.b();
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onTroopManagerSuccess result=%s troopUin=%s", new Object[] { Integer.valueOf(paramInt2), paramString }));
    }
    Bundle localBundle;
    if (1 == paramInt1)
    {
      QQToast.a(LoginWelcomeManager.a(this.a).getApp(), 5, 2131717457, 1).a();
      localBundle = LoginWelcomeManager.a(this.a).getBundle("request");
      localBundle.putString("uin", String.valueOf(paramString));
      if (paramInt2 != 0) {
        break label120;
      }
    }
    label120:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localBundle.putInt("result", paramInt1);
      LoginWelcomeManager.a(this.a).removeObserver(this);
      this.a.b();
      return;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = LoginWelcomeManager.a(this.a).getBundle("request");
      paramString.putString("uin", String.valueOf(paramLong));
      paramString.putShort("option", paramTroopInfo.cGroupOption);
      paramString.putString("name", paramTroopInfo.troopname);
      if ((paramTroopInfo.cGroupOption != 4) && (paramTroopInfo.cGroupOption != 5)) {
        break label114;
      }
      paramString.putString("answer", paramTroopInfo.joinTroopAnswer);
      paramString.putString("question", paramTroopInfo.joinTroopQuestion);
    }
    for (;;)
    {
      this.a.b();
      LoginWelcomeManager.a(this.a).removeObserver(this);
      return;
      label114:
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "onOIDB0X88D_1_Ret err");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvq
 * JD-Core Version:    0.7.0.1
 */