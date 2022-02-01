package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloBaseActivity
  extends AbsBaseWebViewActivity
  implements WebUiUtils.WebStatisticsInterface, WebUiUtils.WebUiMethodInterface, WebUiUtils.WebviewReportSpeedInterface
{
  public static final String TAG = "ApolloBaseActivity";
  private static int sApolloBaseActivityCounter;
  protected long mClickTime;
  protected int mCurrentStep;
  protected long mCurrentStepTime = 0L;
  protected String mCurrentUrl;
  private boolean mFirstRequest = true;
  private boolean mIsFirstOnPageStart = true;
  private boolean mIsWebViewCache;
  private OfflinePlugin mOfflinePlugin;
  protected long mOnCreateMilliTimeStamp = 0L;
  private boolean mReported;
  private long mStartLoadUrlMilliTimeStamp = 0L;
  protected long mTimeBeforeLoadUrl;
  protected TouchWebView mWebView;
  private SharedPreferences mWebViewReportPreferences;
  protected long onCreateTime;
  
  private void checkOfflinePlugin()
  {
    if ((this.mOfflinePlugin == null) && (this.mWebView != null))
    {
      Object localObject = this.mWebView.getPluginEngine();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("offline");
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.mOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
    }
  }
  
  private void reportStep()
  {
    if (this.mReported) {}
    for (;;)
    {
      return;
      this.mReported = true;
      try
      {
        i = NetworkUtil.a(getApplicationContext());
        switch (i)
        {
        default: 
          CharSequence localCharSequence = null;
          i = sApolloBaseActivityCounter;
          if (TextUtils.isEmpty(localCharSequence)) {
            continue;
          }
          if (this.mWebViewReportPreferences == null) {
            this.mWebViewReportPreferences = getSharedPreferences("apollo_WebView_Report_Step", 0);
          }
          ThreadManager.post(new ApolloBaseActivity.1(this, localCharSequence, i), 5, null, false);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
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
    reportStep();
    sApolloBaseActivityCounter -= 1;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    resetTimer(paramIntent);
    this.mFirstRequest = false;
  }
  
  public ApolloWebStatistics getApolloWebStatistics(boolean paramBoolean)
  {
    if (this.mWebView != null)
    {
      Object localObject = this.mWebView.getPluginEngine();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("apollo");
        if ((localObject != null) && ((localObject instanceof ApolloJsPluginImpl)))
        {
          localObject = ((ApolloJsPluginImpl)localObject).getInterceptor();
          if (localObject != null) {
            if (paramBoolean)
            {
              if (((ApolloUrlInterceptor)localObject).a()) {
                return ((ApolloUrlInterceptor)localObject).a();
              }
            }
            else {
              return ((ApolloUrlInterceptor)localObject).a();
            }
          }
        }
      }
    }
    return null;
  }
  
  public int getCurrentStep()
  {
    return this.mCurrentStep;
  }
  
  public String getCurrentUrl()
  {
    Object localObject2 = this.mCurrentUrl;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.mWebView != null) {
        localObject1 = this.mWebView.getUrl();
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
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.a;
    }
    return 0L;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.b;
    }
    return 0L;
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebView;
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
    return this.mIsWebViewCache;
  }
  
  public long getmClickTime()
  {
    return this.mClickTime;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    return this.mOnCreateMilliTimeStamp;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    return this.mFirstRequest;
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    return this.mStartLoadUrlMilliTimeStamp;
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    return this.mTimeBeforeLoadUrl;
  }
  
  public long getonCreateTime()
  {
    return this.onCreateTime;
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
  
  public void hideVirtualNavBar() {}
  
  public boolean isActivityResume()
  {
    return this.mIsResume;
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public boolean isMainPageUseLocalFile()
  {
    checkOfflinePlugin();
    if (this.mOfflinePlugin != null) {
      return this.mOfflinePlugin.f;
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    reportStep();
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
      this.mIsWebViewCache = true;
    }
    this.mCurrentStep = 1;
    resetTimer(getIntent());
    super.onCreate(paramBundle);
    sApolloBaseActivityCounter += 1;
    if ((this.mWebView != null) && (Build.VERSION.SDK_INT >= 14) && (SwiftBrowserShareMenuHandler.a.length >= 1))
    {
      int i = SwiftBrowserShareMenuHandler.a[1];
      paramBundle = this.mWebView.getSettings();
      if (paramBundle != null) {
        paramBundle.setTextZoom(i);
      }
    }
    if ((this.mStatistics != null) && (this.mRuntime != null) && (this.mRuntime.getLongAccountUin() != 0L) && (SwiftBrowserStatistics.d != 0))
    {
      paramBundle = this.mStatistics;
      if (this.mRuntime.getLongAccountUin() % SwiftBrowserStatistics.d != 6L) {
        break label147;
      }
    }
    for (;;)
    {
      paramBundle.i = bool;
      return;
      label147:
      bool = false;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.mCurrentStep == 2))
    {
      this.mCurrentStep = 8;
      this.mCurrentStepTime = System.currentTimeMillis();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (!this.mIsFirstOnPageStart)
    {
      this.mFirstRequest = false;
      resetTimer(null);
    }
    if (this.mIsFirstOnPageStart)
    {
      this.mIsFirstOnPageStart = false;
      this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
    }
    if (!"about:blank".equalsIgnoreCase(paramString))
    {
      this.mCurrentStep = 2;
      this.mCurrentStepTime = System.currentTimeMillis();
    }
  }
  
  public void resetTimer(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    this.mOnCreateMilliTimeStamp = l;
    this.mCurrentStepTime = l;
    if (paramIntent != null) {}
    for (this.mClickTime = paramIntent.getLongExtra("extra_key_click_time", this.mOnCreateMilliTimeStamp);; this.mClickTime = System.currentTimeMillis())
    {
      this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
      this.mTimeBeforeLoadUrl = System.currentTimeMillis();
      return;
    }
  }
  
  public void setBottomBarVisible(boolean paramBoolean) {}
  
  public void setCurrentStep(int paramInt)
  {
    this.mCurrentStep = paramInt;
  }
  
  public void setStepTime(long paramLong)
  {
    this.mCurrentStepTime = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.mClickTime + "mCurrentStepTime->" + this.mCurrentStepTime + " mCurrentStep->" + this.mCurrentStep);
    }
  }
  
  public void setX5Performance(JSONObject paramJSONObject) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.mCurrentUrl = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBaseActivity", 2, "mCurrentUrl->" + this.mCurrentUrl);
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public void showActionSheet() {}
  
  public void showVirtualNavBar() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity
 * JD-Core Version:    0.7.0.1
 */