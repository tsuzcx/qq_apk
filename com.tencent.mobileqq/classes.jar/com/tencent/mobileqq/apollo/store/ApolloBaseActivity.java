package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebStatisticsInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import yph;

public class ApolloBaseActivity
  extends AbsBaseWebViewActivity
  implements WebUiUtils.WebStatisticsInterface, WebUiUtils.WebUiMethodInterface, WebUiUtils.WebviewReportSpeedInterface
{
  private static int b;
  public int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private OfflinePlugin jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin;
  public String a;
  private boolean jdField_a_of_type_Boolean = true;
  protected TouchWebView b;
  public long f;
  public long g;
  private boolean g;
  protected long h;
  private boolean h;
  protected long i;
  private boolean i;
  private long j;
  
  public ApolloBaseActivity()
  {
    this.jdField_i_of_type_Boolean = true;
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null) && (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null))
    {
      Object localObject = this.jdField_b_of_type_ComTencentBizUiTouchWebView.a();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("offline");
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_h_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_h_of_type_Boolean = true;
      try
      {
        k = NetworkUtil.a(getApplicationContext());
        switch (k)
        {
        default: 
          CharSequence localCharSequence = null;
          k = jdField_b_of_type_Int;
          if (TextUtils.isEmpty(localCharSequence)) {
            continue;
          }
          if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
            this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("apollo_WebView_Report_Step", 0);
          }
          ThreadManager.post(new yph(this, localCharSequence, k), 5, null, false);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int k = 0;
          continue;
          String str = "2G";
          continue;
          str = "3G";
          continue;
          str = "4G";
          continue;
          str = "wifi";
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CustomWebView a()
  {
    return this.jdField_b_of_type_ComTencentBizUiTouchWebView;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.jdField_g_of_type_Long + "mCurrentStepTime->" + this.f + " mCurrentStep->" + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = l;
    this.f = l;
    if (paramIntent != null) {}
    for (this.jdField_g_of_type_Long = paramIntent.getLongExtra("extra_key_click_time", this.jdField_a_of_type_Long);; this.jdField_g_of_type_Long = System.currentTimeMillis())
    {
      this.j = System.currentTimeMillis();
      this.jdField_i_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      a(null);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.j = System.currentTimeMillis();
    }
    if (!"about:blank".equalsIgnoreCase(paramString))
    {
      this.jdField_a_of_type_Int = 2;
      this.f = System.currentTimeMillis();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBaseActivity", 2, "mCurrentUrl->" + this.jdField_a_of_type_JavaLangString);
      }
    }
    return super.a(paramWebView, paramString);
  }
  
  public String b()
  {
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) {
        localObject1 = this.jdField_b_of_type_ComTencentBizUiTouchWebView.getUrl();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  public void b() {}
  
  protected void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_Int = 8;
      this.f = System.currentTimeMillis();
    }
  }
  
  public boolean b()
  {
    return this.mIsResume;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    e();
    jdField_b_of_type_Int -= 1;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    this.jdField_i_of_type_Boolean = false;
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    return false;
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    d();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    d();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.b;
    }
    return 0L;
  }
  
  public JSONObject getX5Performance()
  {
    return null;
  }
  
  public long getgetWebViewTime()
  {
    return 0L;
  }
  
  public long getinitBrowserTime()
  {
    return 0L;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    return 0L;
  }
  
  public boolean getisWebViewCache()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public long getmClickTime()
  {
    return this.jdField_g_of_type_Long;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    return this.j;
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    return this.jdField_i_of_type_Long;
  }
  
  public long getonCreateTime()
  {
    return this.jdField_h_of_type_Long;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    return 0L;
  }
  
  public boolean isMainPageUseLocalFile()
  {
    d();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.e;
    }
    return false;
  }
  
  protected boolean onBackEvent()
  {
    e();
    return super.onBackEvent();
  }
  
  @TargetApi(14)
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    if (WebAccelerateHelper.isWebViewCache) {
      this.jdField_g_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = 1;
    a(getIntent());
    super.onCreate(paramBundle);
    jdField_b_of_type_Int += 1;
    if ((this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) && (Build.VERSION.SDK_INT >= 14) && (SwiftBrowserShareMenuHandler.a.length >= 1))
    {
      int k = SwiftBrowserShareMenuHandler.a[1];
      paramBundle = this.jdField_b_of_type_ComTencentBizUiTouchWebView.getSettings();
      if (paramBundle != null) {
        paramBundle.setTextZoom(k);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics != null) && (this.mRuntime != null) && (this.mRuntime.getLongAccountUin() != 0L) && (SwiftBrowserStatistics.d != 0))
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      if (this.mRuntime.getLongAccountUin() % SwiftBrowserStatistics.d != 6L) {
        break label147;
      }
    }
    for (;;)
    {
      paramBundle.e = bool;
      return;
      label147:
      bool = false;
    }
  }
  
  public void setX5Performance(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity
 * JD-Core Version:    0.7.0.1
 */