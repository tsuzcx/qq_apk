package com.tencent.mobileqq.apollo.store;

import Override;
import aabq;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import bgww;
import bgxd;
import bgzs;
import bgzu;
import bgzw;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloBaseActivity
  extends AbsBaseWebViewActivity
  implements bgzs, bgzu, bgzw
{
  private static int b;
  protected int a;
  protected long a;
  private aabq jdField_a_of_type_Aabq;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected String a;
  private boolean jdField_a_of_type_Boolean = true;
  protected TouchWebView b;
  protected long f;
  protected long g;
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
  
  private void b()
  {
    if ((this.jdField_a_of_type_Aabq == null) && (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null))
    {
      Object localObject = this.jdField_b_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("offline");
        if ((localObject != null) && ((localObject instanceof aabq))) {
          this.jdField_a_of_type_Aabq = ((aabq)localObject);
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_h_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_h_of_type_Boolean = true;
      try
      {
        k = NetworkUtil.getSystemNetwork(getApplicationContext());
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
          ThreadManager.post(new ApolloBaseActivity.1(this, localCharSequence, k), 5, null, false);
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
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
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
  
  public boolean a(WebView paramWebView, String paramString)
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
  
  public void b(WebView paramWebView, String paramString)
  {
    super.b(paramWebView, paramString);
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_Int = 8;
      this.f = System.currentTimeMillis();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    c();
    jdField_b_of_type_Int -= 1;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    this.jdField_i_of_type_Boolean = false;
  }
  
  public String getCurrentUrl()
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
    b();
    if (this.jdField_a_of_type_Aabq != null) {
      return this.jdField_a_of_type_Aabq.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    b();
    if (this.jdField_a_of_type_Aabq != null) {
      return this.jdField_a_of_type_Aabq.b;
    }
    return 0L;
  }
  
  public CustomWebView getWebView()
  {
    return this.jdField_b_of_type_ComTencentBizUiTouchWebView;
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
  
  public void hideQQBrowserButton() {}
  
  public boolean isActivityResume()
  {
    return this.mIsResume;
  }
  
  public boolean isMainPageUseLocalFile()
  {
    b();
    if (this.jdField_a_of_type_Aabq != null) {
      return this.jdField_a_of_type_Aabq.e;
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    c();
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @TargetApi(14)
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    if (WebAccelerateHelper.isWebViewCache) {
      this.jdField_g_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = 1;
    a(getIntent());
    super.onCreate(paramBundle);
    jdField_b_of_type_Int += 1;
    if ((this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) && (Build.VERSION.SDK_INT >= 14) && (bgww.a.length >= 1))
    {
      int k = bgww.a[1];
      paramBundle = this.jdField_b_of_type_ComTencentBizUiTouchWebView.getSettings();
      if (paramBundle != null) {
        paramBundle.setTextZoom(k);
      }
    }
    if ((this.jdField_a_of_type_Bgxd != null) && (this.mRuntime != null) && (this.mRuntime.getLongAccountUin() != 0L) && (bgxd.d != 0))
    {
      paramBundle = this.jdField_a_of_type_Bgxd;
      if (this.mRuntime.getLongAccountUin() % bgxd.d != 6L) {
        break label147;
      }
    }
    for (;;)
    {
      paramBundle.jdField_i_of_type_Boolean = bool;
      return;
      label147:
      bool = false;
    }
  }
  
  public void setBottomBarVisible(boolean paramBoolean) {}
  
  public void setX5Performance(JSONObject paramJSONObject) {}
  
  public void showActionSheet() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity
 * JD-Core Version:    0.7.0.1
 */