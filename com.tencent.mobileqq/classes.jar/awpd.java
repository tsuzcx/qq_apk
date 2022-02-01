import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class awpd
  extends aziq
{
  public awpd(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void a(NewerGuidePlugin.RecommendedListResp paramRecommendedListResp)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onGetRecommendedList resp=%s", new Object[] { paramRecommendedListResp }));
      }
      if (LoginWelcomeManager.a(this.a) != null)
      {
        Bundle localBundle = LoginWelcomeManager.a(this.a).getBundle("request");
        if (localBundle != null) {
          localBundle.putParcelable("result", paramRecommendedListResp);
        }
        this.a.b();
      }
      LoginWelcomeManager.a(this.a).removeObserver(LoginWelcomeManager.a(this.a));
      return;
    }
    catch (Throwable paramRecommendedListResp)
    {
      QLog.e("LoginWelcomeManager", 1, "onGetRecommendedList fail.", paramRecommendedListResp);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("ShowCommonGuideWebResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpd
 * JD-Core Version:    0.7.0.1
 */