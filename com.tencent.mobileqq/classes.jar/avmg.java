import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.2.2;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;

public final class avmg
  extends birs
{
  avmg(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        QLog.i("QQGameHelper", 1, "SwiftBrowserIdleTask--> do preloadsw ");
        if (!avme.a()) {
          return 0;
        }
        avme.a(NetConnInfoCenter.getServerTimeMillis());
        QQGamePubWebView localQQGamePubWebView = new QQGamePubWebView(BaseApplicationImpl.sApplication);
        WebSettings localWebSettings = localQQGamePubWebView.getSettings();
        String str = localWebSettings.getUserAgentString();
        if (localQQGamePubWebView.getX5WebViewExtension() != null)
        {
          bool = true;
          localWebSettings.setUserAgentString(birz.a(str, "", bool));
          localWebSettings.setJavaScriptEnabled(true);
          localQQGamePubWebView.loadUrl(avmc.d());
          QLog.i("QQGameHelper", 1, "SwiftBrowserIdleTask--> loadUrl " + avmc.d());
          localQQGamePubWebView.setWebChromeClient(new avmh(this));
          ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameHelper.2.2(this, localQQGamePubWebView), 15000L);
          return 0;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGameHelper", 1, QLog.getStackTraceString(localThrowable));
        return 0;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmg
 * JD-Core Version:    0.7.0.1
 */