package com.tencent.mobileqq.ark.security;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class ArkSecurityWebViewPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private ArkBaseUrlChecker jdField_a_of_type_ComTencentArkOpenSecurityArkBaseUrlChecker = null;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = true;
  private String b = "";
  
  public ArkSecurityWebViewPlugin()
  {
    this.mPluginNameSpace = "ArkSecurity";
  }
  
  protected void a()
  {
    if (this.mRuntime == null) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    QLog.i("ArkApp.ArkSecurityWebViewPlugin", 1, "now jump url=" + Util.b("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html", new String[0]));
    localCustomWebView.loadUrl("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html");
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  public int getWebViewSchemaListIndex()
  {
    return 0;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool3 = true;
    if ("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html".equals(paramString1))
    {
      QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe now jump url=", paramString1 });
      return false;
    }
    boolean bool1;
    int i;
    if (this.jdField_a_of_type_ComTencentArkOpenSecurityArkBaseUrlChecker != null)
    {
      int j = this.jdField_a_of_type_ComTencentArkOpenSecurityArkBaseUrlChecker.checkURLLoose(paramString1);
      if (j == 0)
      {
        bool1 = true;
        if (bool1) {
          break label201;
        }
        if (this.jdField_a_of_type_Boolean) {
          break label196;
        }
        QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.web.set isPermitted=true,url=", Util.b(paramString1, new String[0]) });
        i = 2;
        bool1 = true;
        label101:
        ArkSecurityReporter.c(this.jdField_a_of_type_JavaLangString, paramString1, j, i, this.b);
        bool2 = bool1;
        if (!bool1)
        {
          QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.handleSchemaRequest,isPermitted=", Boolean.valueOf(bool1), ", url=", Util.b(paramString1, new String[0]) });
          a();
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (!bool2) {}
      for (bool1 = bool3;; bool1 = false)
      {
        return bool1;
        bool1 = false;
        break;
      }
      label196:
      i = 1;
      break label101;
      label201:
      i = 0;
      break label101;
    }
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    paramIntent = paramIntent.getExtras();
    if ((paramIntent == null) || (paramIntent.getParcelable("h5_ark_url_web_checker") == null))
    {
      QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init bundle is null");
      return false;
    }
    try
    {
      paramIntent.setClassLoader(ArkSecurityWebViewPlugin.class.getClassLoader());
      this.jdField_a_of_type_ComTencentArkOpenSecurityArkBaseUrlChecker = ((ArkBaseUrlChecker)paramIntent.getParcelable("h5_ark_url_web_checker"));
      this.jdField_a_of_type_JavaLangString = paramIntent.getString("h5_ark_app_name", null);
      this.b = paramIntent.getString("h5_ark_url_web_sender_uin", "");
      this.jdField_a_of_type_Boolean = paramIntent.getBoolean("h5_ark_url_web_checker_enable", true);
      paramString1 = this.jdField_a_of_type_JavaLangString;
      boolean bool = this.jdField_a_of_type_Boolean;
      paramString2 = this.b;
      if (this.jdField_a_of_type_ComTencentArkOpenSecurityArkBaseUrlChecker != null)
      {
        paramIntent = this.jdField_a_of_type_ComTencentArkOpenSecurityArkBaseUrlChecker.toString();
        QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.ArkSecurityWebViewPlugin init appname = ", paramString1, ",mEnableUrlCheck = ", Boolean.valueOf(bool), ", senderUin=", paramString2, ", mUrlChecker=", paramIntent });
        return true;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QLog.e("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init exception:", paramIntent);
        continue;
        paramIntent = null;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
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