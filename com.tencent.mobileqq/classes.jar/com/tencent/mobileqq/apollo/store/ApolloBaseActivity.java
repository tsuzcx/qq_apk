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

public class ApolloBaseActivity
  extends AbsBaseWebViewActivity
  implements WebUiUtils.WebStatisticsInterface, WebUiUtils.WebUiMethodInterface, WebUiUtils.WebviewReportSpeedInterface
{
  public static final String TAG = "[cmshow]ApolloBaseActivity";
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
    if (this.mOfflinePlugin == null)
    {
      Object localObject = this.mWebView;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getPluginEngine();
        if (localObject != null)
        {
          localObject = ((WebViewPluginEngine)localObject).b("offline");
          if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
            this.mOfflinePlugin = ((OfflinePlugin)localObject);
          }
        }
      }
    }
  }
  
  private void reportStep()
  {
    if (this.mReported) {
      return;
    }
    this.mReported = true;
    try
    {
      i = NetworkUtil.getSystemNetwork(getApplicationContext());
    }
    catch (Exception localException)
    {
      int i;
      label24:
      String str;
      break label24;
    }
    i = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            str = null;
          } else {
            str = "4G";
          }
        }
        else {
          str = "3G";
        }
      }
      else {
        str = "2G";
      }
    }
    else {
      str = "wifi";
    }
    i = sApolloBaseActivityCounter;
    if (!TextUtils.isEmpty(str))
    {
      if (this.mWebViewReportPreferences == null) {
        this.mWebViewReportPreferences = getSharedPreferences("apollo_WebView_Report_Step", 0);
      }
      ThreadManager.post(new ApolloBaseActivity.1(this, str, i), 5, null, false);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    reportStep();
    sApolloBaseActivityCounter -= 1;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    resetTimer(paramIntent);
    this.mFirstRequest = false;
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
      TouchWebView localTouchWebView = this.mWebView;
      localObject1 = localObject2;
      if (localTouchWebView != null) {
        localObject1 = localTouchWebView.getUrl();
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
    OfflinePlugin localOfflinePlugin = this.mOfflinePlugin;
    if (localOfflinePlugin != null) {
      return localOfflinePlugin.o;
    }
    return 0L;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    checkOfflinePlugin();
    OfflinePlugin localOfflinePlugin = this.mOfflinePlugin;
    if (localOfflinePlugin != null) {
      return localOfflinePlugin.p;
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
  
  public boolean isActivityResume()
  {
    return this.mIsResume;
  }
  
  public boolean isMainPageUseLocalFile()
  {
    checkOfflinePlugin();
    OfflinePlugin localOfflinePlugin = this.mOfflinePlugin;
    if (localOfflinePlugin != null) {
      return localOfflinePlugin.v;
    }
    return false;
  }
  
  protected boolean onBackEvent()
  {
    reportStep();
    return super.onBackEvent();
  }
  
  @TargetApi(14)
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = WebAccelerateHelper.isWebViewCache;
    boolean bool1 = true;
    if (bool2) {
      this.mIsWebViewCache = true;
    }
    this.mCurrentStep = 1;
    resetTimer(getIntent());
    super.onCreate(paramBundle);
    sApolloBaseActivityCounter += 1;
    if ((this.mWebView != null) && (Build.VERSION.SDK_INT >= 14) && (SwiftBrowserShareMenuHandler.c.length >= 1))
    {
      int i = SwiftBrowserShareMenuHandler.c[1];
      paramBundle = this.mWebView.getSettings();
      if (paramBundle != null) {
        paramBundle.setTextZoom(i);
      }
    }
    if ((this.mStatistics != null) && (this.mRuntime != null) && (this.mRuntime.getLongAccountUin() != 0L) && (SwiftBrowserStatistics.aJ != 0))
    {
      paramBundle = this.mStatistics;
      if (this.mRuntime.getLongAccountUin() % SwiftBrowserStatistics.aJ != 6L) {
        bool1 = false;
      }
      paramBundle.as = bool1;
    }
  }
  
  protected void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.mCurrentStep == 2))
    {
      this.mCurrentStep = 8;
      this.mCurrentStepTime = System.currentTimeMillis();
    }
  }
  
  protected void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
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
    if (paramIntent != null) {
      this.mClickTime = paramIntent.getLongExtra("extra_key_click_time", this.mOnCreateMilliTimeStamp);
    } else {
      this.mClickTime = System.currentTimeMillis();
    }
    this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
    this.mTimeBeforeLoadUrl = System.currentTimeMillis();
  }
  
  public void setCurrentStep(int paramInt)
  {
    this.mCurrentStep = paramInt;
  }
  
  public void setStepTime(long paramLong)
  {
    this.mCurrentStepTime = paramLong;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mClickTime->");
      localStringBuilder.append(this.mClickTime);
      localStringBuilder.append("mCurrentStepTime->");
      localStringBuilder.append(this.mCurrentStepTime);
      localStringBuilder.append(" mCurrentStep->");
      localStringBuilder.append(this.mCurrentStep);
      QLog.d("[cmshow]ApolloBaseActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void setX5Performance(JSONObject paramJSONObject) {}
  
  protected boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.mCurrentUrl = paramString;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mCurrentUrl->");
        localStringBuilder.append(this.mCurrentUrl);
        QLog.d("ApolloBaseActivity", 2, localStringBuilder.toString());
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public void showActionSheet() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity
 * JD-Core Version:    0.7.0.1
 */