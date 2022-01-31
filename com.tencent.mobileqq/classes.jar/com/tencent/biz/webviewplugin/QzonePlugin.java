package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import pco;
import pcp;

public class QzonePlugin
  extends WebViewPlugin
{
  public static final String a;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c = "";
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = QzonePlugin.class.getSimpleName();
  }
  
  public QzonePlugin()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private void a()
  {
    new Handler().post(new pcp(this));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (this.d == null)) {}
    while ((this.d != null) && (this.c != null) && (this.c.equals(this.d))) {
      return;
    }
    new Handler().post(new pco(this, paramArrayOfByte));
    this.c = this.d;
  }
  
  public boolean a(String paramString)
  {
    Intent localIntent = this.mRuntime.a().getIntent();
    Bundle localBundle = localIntent.getExtras();
    byte[] arrayOfByte = localBundle.getByteArray("post_data");
    boolean bool = localBundle.getBoolean("UrlorData", true);
    this.d = paramString;
    if (localBundle.getString("originalURL") != null) {
      this.d = localBundle.getString("originalURL");
    }
    if (arrayOfByte == null)
    {
      if (bool) {
        return false;
      }
      a();
      return true;
    }
    a(arrayOfByte);
    localIntent.removeExtra("post_data");
    return true;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934601L) && (this.b != null) && (!"".equals(this.b)))
    {
      paramString = new Intent();
      paramString.setAction(this.b);
      paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", this.jdField_a_of_type_Boolean);
      if ("com.tencent.mobileqq.opencenter.vipInfo".equals(this.b))
      {
        paramMap = this.mRuntime.a(this.mRuntime.a());
        if ((paramMap != null) && ((paramMap instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
          paramString.putExtra("key_pay_action_result", ((WebUiUtils.QQBrowserBaseActivityInterface)paramMap).e());
        }
      }
      this.mRuntime.a().sendBroadcast(paramString);
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase("pay://requestQzoneOpenVip")))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    if ((this.mRuntime.a().getIntent().getBooleanExtra("fromQZone", false)) && ((paramString2.equals("http")) || (paramString2.equals("https")))) {
      return a(paramString1);
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    if (this.mRuntime.a().getIntent() != null) {
      this.b = this.mRuntime.a().getIntent().getStringExtra("broadcastAction");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin
 * JD-Core Version:    0.7.0.1
 */