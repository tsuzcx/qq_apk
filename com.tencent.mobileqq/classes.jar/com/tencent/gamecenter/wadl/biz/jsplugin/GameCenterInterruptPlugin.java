package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.ApkInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.net.URL;

public class GameCenterInterruptPlugin
  extends WebViewPlugin
{
  public GameCenterInterruptPlugin()
  {
    QLog.d("Wadl_GameCenterInterruptPlugin", 1, "GameCenterInterruptPlugin init");
    this.mPluginNameSpace = "gameCenter";
    QRoute.api(IQQGameConfigService.class);
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (!paramString1.contains("apk")) {
          return false;
        }
        Object localObject3 = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
        localObject1 = null;
        Object localObject2 = null;
        if (localObject3 == null) {
          break label699;
        }
        paramString2 = ((WadlCommConfig)localObject3).b(paramString1);
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("handleSchemaRequest url=");
        ((StringBuilder)localObject4).append(paramString1);
        ((StringBuilder)localObject4).append(" apkInfo=");
        ((StringBuilder)localObject4).append(paramString2);
        QLog.d("Wadl_GameCenterInterruptPlugin", 1, ((StringBuilder)localObject4).toString());
        if ((paramString2 != null) && (!PackageUtil.a(BaseApplication.getContext(), paramString2.c)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("interrupt url downLoad apk channelId=");
          ((StringBuilder)localObject1).append(paramString2.d);
          ((StringBuilder)localObject1).append(" pkgName=");
          ((StringBuilder)localObject1).append(paramString2.c);
          ((StringBuilder)localObject1).append(", appid=");
          ((StringBuilder)localObject1).append(paramString2.a);
          ((StringBuilder)localObject1).append(",gameName=");
          ((StringBuilder)localObject1).append(paramString2.b);
          ((StringBuilder)localObject1).append(",url=");
          ((StringBuilder)localObject1).append(paramString1);
          QLog.i("Wadl_GameCenterInterruptPlugin", 1, ((StringBuilder)localObject1).toString());
          if (this.mRuntime == null) {
            break label704;
          }
          paramString1 = this.mRuntime.d();
          localObject1 = this.mRuntime.a();
          if (localObject1 != null)
          {
            if (paramString1 != null) {
              localObject2 = paramString1.getIntent();
            }
            localObject4 = GameCenterUtil.a((Intent)localObject2);
            paramString1 = new StringBuilder();
            paramString1.append("originalUrl=");
            paramString1.append(((CustomWebView)localObject1).getOriginalUrl());
            paramString1.append(",sessionInfo=");
            paramString1.append(localObject4);
            paramString1.append(",url=");
            paramString1.append(((CustomWebView)localObject1).getUrl());
            QLog.i("Wadl_GameCenterInterruptPlugin", 1, paramString1.toString());
            paramString1 = ((CustomWebView)localObject1).getUrl();
            localObject2 = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              localObject2 = ((CustomWebView)localObject1).getOriginalUrl();
            }
            paramString1 = new WadlParams(paramString2.a, paramString2.c);
            paramString1.c = 2;
            paramString1.b = false;
            paramString1.i = paramString2.d;
            paramString1.u = paramString2.b;
            paramString1.k = paramString2.e;
            paramString1.w = "GameCenterIntterup";
            paramString1.h = 6;
            paramString1.x = ((String)localObject2);
            WadlProxyServiceUtil.a().b(paramString1);
            if (localObject3 == null) {
              break label711;
            }
            paramString1 = ((WadlCommConfig)localObject3).c;
            localObject3 = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              localObject3 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
            }
            ((CustomWebView)localObject1).loadUrl((String)localObject3);
            new WadlReportBuilder().a("dc00087").h("558").c("205758").b(paramString2.a).a(1, "55801").a(11, "4").a(12, "430").a(2, String.valueOf(((Pair)localObject4).first)).a(3, (String)((Pair)localObject4).second).a(4, paramString2.d).a(5, paramString2.e).a(6, (String)localObject2).a();
            return true;
          }
        }
        else
        {
          localObject2 = WadlReportInfo.a();
          try
          {
            paramString2 = new URL(paramString1).getHost();
          }
          catch (Throwable paramString2)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("parseUrl fail,url=");
            ((StringBuilder)localObject3).append(paramString1);
            QLog.e("Wadl_GameCenterInterruptPlugin", 1, ((StringBuilder)localObject3).toString(), paramString2);
            paramString2 = (String)localObject1;
          }
          ((WadlReportInfo)localObject2).h = paramString1;
          ((WadlReportInfo)localObject2).i = paramString2;
          ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportDC("205925", "20", (WadlReportInfo)localObject2, "08a00036462");
          return false;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleSchemaRequest error =");
        paramString2.append(paramString1.toString());
        QLog.e("Wadl_GameCenterInterruptPlugin", 1, paramString2.toString());
      }
      return false;
      label699:
      paramString2 = null;
      continue;
      label704:
      paramString1 = null;
      Object localObject1 = paramString1;
      continue;
      label711:
      paramString1 = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.jsplugin.GameCenterInterruptPlugin
 * JD-Core Version:    0.7.0.1
 */