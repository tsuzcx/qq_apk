import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.net.URL;

public class avep
  extends WebViewPlugin
{
  public avep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterInterruptPlugin", 2, "GameCenterInterruptPlugin init");
    }
    this.mPluginNameSpace = "gameCenter";
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (!paramString1.contains("apk")) {
          break label591;
        }
        localObject4 = (bjqr)bjqs.a().a("comminfo");
        if (localObject4 == null) {
          break label593;
        }
        paramString2 = ((bjqr)localObject4).a(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterInterruptPlugin", 1, "handleSchemaRequest url=" + paramString1 + " apkInfo=" + paramString2);
        }
        if ((paramString2 == null) || (bhfn.a(BaseApplication.getContext(), paramString2.c)))
        {
          localObject3 = bjrd.a();
          paramString2 = null;
        }
      }
      catch (Exception paramString1)
      {
        Object localObject4;
        Object localObject3;
        Object localObject1;
        Pair localPair;
        QLog.e("GameCenterInterruptPlugin", 1, "handleSchemaRequest error =" + paramString1.toString());
      }
      try
      {
        localObject1 = new URL(paramString1).getHost();
        paramString2 = (String)localObject1;
      }
      catch (Throwable localThrowable)
      {
        continue;
        continue;
        paramString1 = null;
        Object localObject2 = null;
        continue;
      }
      ((bjrd)localObject3).g = paramString1;
      ((bjrd)localObject3).h = paramString2;
      bmqt.a().a("205925", "20", (bjrd)localObject3, "08a00036462");
      return false;
      QLog.i("GameCenterInterruptPlugin", 1, "interrupt url downLoad apk channelId=" + paramString2.d + " pkgName=" + paramString2.c + ", appid=" + paramString2.a + ",gameName=" + paramString2.b + ",url=" + paramString1);
      if (this.mRuntime != null)
      {
        paramString1 = this.mRuntime.a();
        localObject1 = this.mRuntime.a();
        if (localObject1 != null)
        {
          localObject3 = null;
          if (paramString1 != null) {
            localObject3 = paramString1.getIntent();
          }
          localPair = abuf.a((Intent)localObject3);
          QLog.i("GameCenterInterruptPlugin", 1, "originalUrl=" + ((CustomWebView)localObject1).getOriginalUrl() + ",sessionInfo=" + localPair + ",url=" + ((CustomWebView)localObject1).getUrl());
          paramString1 = new Bundle();
          paramString1.putInt("from", 6);
          paramString1.putInt("flags", 7);
          paramString1.putString("packageName", paramString2.c);
          paramString1.putString("apkChannel", paramString2.d);
          paramString1.putString("appName", paramString2.b);
          paramString1.putString("apkUrl", paramString2.e);
          paramString1.putString("via", "GameCenterIntterup");
          localObject3 = ((CustomWebView)localObject1).getUrl();
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = ((CustomWebView)localObject1).getOriginalUrl();
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              paramString1.putString("ext", (String)localObject3);
              paramString1.putString("fromWebUrl", (String)localObject3);
            }
            aveq.a(paramString1, paramString2.a, false, 0);
            if (localObject4 != null)
            {
              paramString1 = ((bjqr)localObject4).c;
              localObject4 = paramString1;
              if (TextUtils.isEmpty(paramString1)) {
                localObject4 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
              }
              ((CustomWebView)localObject1).loadUrl((String)localObject4);
              abuf.a(null, "558", "205758", paramString2.a, "55801", "4", "430", new String[] { String.valueOf(localPair.first), (String)localPair.second, paramString2.d, paramString2.e, localObject3 });
              return true;
            }
            paramString1 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      label591:
      return false;
      label593:
      paramString2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avep
 * JD-Core Version:    0.7.0.1
 */