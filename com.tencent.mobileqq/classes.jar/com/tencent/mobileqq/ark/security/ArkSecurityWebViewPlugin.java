package com.tencent.mobileqq.ark.security;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class ArkSecurityWebViewPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private ArkBaseUrlChecker a = null;
  private String b = null;
  private String c = "";
  private boolean d = true;
  
  public ArkSecurityWebViewPlugin()
  {
    this.mPluginNameSpace = "ArkSecurity";
  }
  
  protected void a()
  {
    if (this.mRuntime == null) {
      return;
    }
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now jump url=");
      localStringBuilder.append(Util.b("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html", new String[0]));
      QLog.i("ArkApp.ArkSecurityWebViewPlugin", 1, localStringBuilder.toString());
      localCustomWebView.loadUrl("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html");
    }
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  public int getWebViewSchemaListIndex()
  {
    return 0;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html".equals(paramString1))
    {
      QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe now jump url=", paramString1 });
      return false;
    }
    paramString2 = this.a;
    boolean bool2;
    if (paramString2 != null)
    {
      int j = paramString2.checkURLLoose(paramString1);
      boolean bool1;
      if (j == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i;
      if (!bool1)
      {
        if (!this.d)
        {
          QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.web.set isPermitted=true,url=", Util.b(paramString1, new String[0]) });
          bool1 = true;
          i = 2;
        }
        else
        {
          i = 1;
        }
      }
      else {
        i = 0;
      }
      ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportNavigateURLAccess(this.b, paramString1, j, i, this.c);
      bool2 = bool1;
      if (!bool1)
      {
        QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.handleSchemaRequest,isPermitted=", Boolean.valueOf(bool1), ", url=", Util.b(paramString1, new String[0]) });
        a();
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2 ^ true;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    paramString1 = paramIntent.getExtras();
    if ((paramString1 != null) && (paramString1.getParcelable("h5_ark_url_web_checker") != null))
    {
      paramIntent = null;
      try
      {
        paramString1.setClassLoader(ArkSecurityWebViewPlugin.class.getClassLoader());
        this.a = ((ArkBaseUrlChecker)paramString1.getParcelable("h5_ark_url_web_checker"));
        this.b = paramString1.getString("h5_ark_app_name", null);
        this.c = paramString1.getString("h5_ark_url_web_sender_uin", "");
        this.d = paramString1.getBoolean("h5_ark_url_web_checker_enable", true);
      }
      catch (Exception paramString1)
      {
        QLog.e("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init exception:", paramString1);
      }
      paramString1 = this.b;
      boolean bool = this.d;
      paramString2 = this.c;
      ArkBaseUrlChecker localArkBaseUrlChecker = this.a;
      if (localArkBaseUrlChecker != null) {
        paramIntent = localArkBaseUrlChecker.toString();
      }
      QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.ArkSecurityWebViewPlugin init appname = ", paramString1, ",mEnableUrlCheck = ", Boolean.valueOf(bool), ", senderUin=", paramString2, ", mUrlChecker=", paramIntent });
      return true;
    }
    QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init bundle is null");
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin onDestroy");
    ChooseImageIPCModule.a().a("callDisableReport", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.security.ArkSecurityWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */