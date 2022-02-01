package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.IPostCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class QzonePlugin
  extends WebViewPlugin
  implements IPostCreatePluginChecker, IPreCreatePluginChecker
{
  public static final String a = "QzonePlugin";
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private String c = "";
  private String d;
  
  public QzonePlugin()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private void a()
  {
    new Handler().post(new QzonePlugin.2(this));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      String str1 = this.d;
      if (str1 == null) {
        return;
      }
      if (str1 != null)
      {
        String str2 = this.c;
        if ((str2 != null) && (str2.equals(str1))) {
          return;
        }
      }
      new Handler().post(new QzonePlugin.1(this, paramArrayOfByte));
      this.c = this.d;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getInt("resultCode") != 0) {
          break label77;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel())
        {
          paramString = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult: mPayActionSucc=");
          localStringBuilder.append(this.jdField_b_of_type_Boolean);
          QLog.d(paramString, 2, localStringBuilder.toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label77:
      boolean bool = false;
    }
  }
  
  public boolean a(Intent paramIntent, CopyOnWriteArrayList<WebViewPlugin> paramCopyOnWriteArrayList)
  {
    if (!paramIntent.getBooleanExtra("fromQZone", false)) {
      return false;
    }
    paramIntent = paramCopyOnWriteArrayList.iterator();
    while (paramIntent.hasNext()) {
      if (((WebViewPlugin)paramIntent.next() instanceof QzonePlugin)) {
        return false;
      }
    }
    return true;
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
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 11L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      paramString = this.jdField_b_of_type_JavaLangString;
      if ((paramString != null) && (!"".equals(paramString)))
      {
        paramString = new Intent();
        paramString.setAction(this.jdField_b_of_type_JavaLangString);
        paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", this.jdField_a_of_type_Boolean);
        if (("com.tencent.mobileqq.opencenter.vipInfo".equals(this.jdField_b_of_type_JavaLangString)) && (this.mRuntime.a(this.mRuntime.a()) != null)) {
          paramString.putExtra("key_pay_action_result", this.jdField_b_of_type_Boolean);
        }
        this.mRuntime.a().sendBroadcast(paramString);
      }
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
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent.getBooleanExtra("fromQZone", false)) {
      if (!paramString2.equals("http"))
      {
        bool1 = bool2;
        if (!paramString2.equals("https")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
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
      this.jdField_b_of_type_JavaLangString = this.mRuntime.a().getIntent().getStringExtra("broadcastAction");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin
 * JD-Core Version:    0.7.0.1
 */