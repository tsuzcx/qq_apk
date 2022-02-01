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
  private boolean b = false;
  private String c = null;
  private String d = "";
  private WebView e;
  private String f;
  private boolean g = false;
  
  public QzonePlugin()
  {
    this.mPluginNameSpace = a;
  }
  
  private void a()
  {
    new Handler().post(new QzonePlugin.2(this));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      String str1 = this.f;
      if (str1 == null) {
        return;
      }
      if (str1 != null)
      {
        String str2 = this.d;
        if ((str2 != null) && (str2.equals(str1))) {
          return;
        }
      }
      new Handler().post(new QzonePlugin.1(this, paramArrayOfByte));
      this.d = this.f;
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
    Intent localIntent = this.mRuntime.d().getIntent();
    Bundle localBundle = localIntent.getExtras();
    byte[] arrayOfByte = localBundle.getByteArray("post_data");
    boolean bool = localBundle.getBoolean("UrlorData", true);
    this.f = paramString;
    if (localBundle.getString("originalURL") != null) {
      this.f = localBundle.getString("originalURL");
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
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getInt("resultCode") != 0) {
          break label77;
        }
        bool = true;
        this.g = bool;
        if (QLog.isColorLevel())
        {
          paramString = this.mTAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult: mPayActionSucc=");
          localStringBuilder.append(this.g);
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
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 11L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      paramString = this.c;
      if ((paramString != null) && (!"".equals(paramString)))
      {
        paramString = new Intent();
        paramString.setAction(this.c);
        paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", this.b);
        if (("com.tencent.mobileqq.opencenter.vipInfo".equals(this.c)) && (this.mRuntime.a(this.mRuntime.d()) != null)) {
          paramString.putExtra("key_pay_action_result", this.g);
        }
        this.mRuntime.d().sendBroadcast(paramString);
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase("pay://requestQzoneOpenVip")))
    {
      this.b = true;
      return true;
    }
    if ((this.mRuntime.d().getIntent().getBooleanExtra("fromQZone", false)) && ((paramString2.equals("http")) || (paramString2.equals("https")))) {
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
    this.e = null;
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.e = this.mRuntime.a();
    if (this.mRuntime.d().getIntent() != null) {
      this.c = this.mRuntime.d().getIntent().getStringExtra("broadcastAction");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin
 * JD-Core Version:    0.7.0.1
 */