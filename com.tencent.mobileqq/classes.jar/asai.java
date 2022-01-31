import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class asai
  extends ajto
{
  public asai(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onCardDownload isSuccess=%s data=%s", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
    }
    if ((LoginWelcomeManager.a(this.a) == null) || ((paramBoolean) && (paramObject != null))) {}
    for (;;)
    {
      try
      {
        Object localObject = LoginWelcomeManager.a(this.a).getBundle("request");
        String str = ((Bundle)localObject).getString("uin");
        long l1 = Long.parseLong(LoginWelcomeManager.a(this.a).getCurrentAccountUin());
        long l2 = Long.parseLong(str);
        localObject = ((Bundle)localObject).getString("authSig");
        LoginWelcomeManager.a(this.a).addObserver(this.a.a);
        akhp localakhp = (akhp)LoginWelcomeManager.a(this.a).a(20);
        paramObject = localakhp.a((Card)paramObject);
        localakhp.a(str, paramObject, 1, null, (String)localObject, localakhp.a(paramObject, l1, l2), null);
        LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("LoginWelcomeManager", 1, "onCardDownload fail.", paramObject);
        continue;
      }
      this.a.b();
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    int i = 1;
    QLog.d("LoginWelcomeManager", 1, String.format("mCardObserver.onUpdateAvatar isSuccess=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    if (TextUtils.equals(LoginWelcomeManager.a(this.a).getCurrentAccountUin(), paramString)) {
      if (LoginWelcomeManager.a(this.a) != null)
      {
        paramString = LoginWelcomeManager.a(this.a).getBundle("request");
        if (paramString != null) {
          if (!paramBoolean) {
            break label130;
          }
        }
      }
    }
    for (;;)
    {
      paramString.putInt("result", i);
      paramString.putString("path", LoginWelcomeManager.a(this.a));
      LoginWelcomeManager.a(this.a, null);
      this.a.b();
      LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
      return;
      label130:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asai
 * JD-Core Version:    0.7.0.1
 */