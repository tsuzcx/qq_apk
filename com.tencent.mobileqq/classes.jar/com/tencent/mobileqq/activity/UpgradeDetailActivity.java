package com.tencent.mobileqq.activity;

import acem;
import acen;
import ajia;
import ajjy;
import akgo;
import akgr;
import akgt;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqrc;
import bchb;
import beez;
import bfpr;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ProtectedWebView;
import protocol.KQQConfig.UpgradeInfo;

@SuppressLint({"SetJavaScriptEnabled"})
public class UpgradeDetailActivity
  extends IphoneTitleBarActivity
  implements akgr, Handler.Callback
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  public ProgressBar a;
  private aqrc jdField_a_of_type_Aqrc;
  beez jdField_a_of_type_Beez;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  public WebView a;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  private int a(String paramString)
  {
    j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID,jumpMarketSupportPhone," + paramString + ",manufacture:" + Build.MANUFACTURER);
      }
    }
    for (;;)
    {
      try
      {
        localObject = getPackageManager();
        if ((!paramString.contains("vivo")) || (!Build.MANUFACTURER.equalsIgnoreCase("vivo"))) {
          continue;
        }
        k = ((PackageManager)localObject).getPackageInfo("com.bbk.appstore", 0).versionCode;
        if (QLog.isColorLevel()) {
          QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID versioncode:" + k);
        }
        i = j;
        if (k >= 3100) {
          i = 1;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        int k;
        boolean bool;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID exception:" + paramString.getMessage());
        i = j;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID returnid:" + i);
      }
      return i;
      if ((paramString.contains("xiaomi")) && (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")))
      {
        i = j;
        if (((PackageManager)localObject).getPackageInfo("com.xiaomi.market", 0) != null) {
          i = 2;
        }
      }
      else
      {
        i = j;
        if (paramString.contains("oppo"))
        {
          bool = Build.MANUFACTURER.equalsIgnoreCase("oppo");
          i = j;
          if (bool)
          {
            try
            {
              paramString = ((PackageManager)localObject).getPackageInfo("com.oppo.market", 0);
              i = j;
              if (paramString == null) {
                continue;
              }
              i = j;
              if (paramString.applicationInfo == null) {
                continue;
              }
              i = j;
              if (!paramString.applicationInfo.enabled) {
                continue;
              }
              k = paramString.versionCode;
              if (QLog.isColorLevel()) {
                QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID oppo market versioncode:" + k);
              }
              i = j;
              if (k <= 6300) {
                continue;
              }
              i = 3;
            }
            catch (Throwable paramString)
            {
              try
              {
                localObject = ((PackageManager)localObject).getPackageInfo("com.heytap.market", 0);
                if (QLog.isColorLevel()) {
                  QLog.i("UpgradeDetailActivity", 2, "oppo.market exception:" + paramString.getMessage());
                }
                i = j;
                if (localObject == null) {
                  continue;
                }
                i = j;
                if (((PackageInfo)localObject).applicationInfo == null) {
                  continue;
                }
                bool = ((PackageInfo)localObject).applicationInfo.enabled;
                i = j;
                if (!bool) {
                  continue;
                }
                i = 3;
              }
              catch (Throwable paramString)
              {
                i = j;
              }
            }
            if (QLog.isColorLevel())
            {
              QLog.i("UpgradeDetailActivity", 2, "heytap.market exception:" + paramString.getMessage());
              i = j;
            }
          }
        }
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131312065);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((ProtectedWebView)findViewById(2131312067));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + bfpr.a());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new acen(this, null));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new acem(this, null));
    this.jdField_a_of_type_Aqrc = new aqrc();
    this.jdField_a_of_type_Aqrc.a(new UpgradeDetailActivity.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131312068));
  }
  
  public static void a(Activity paramActivity, UpgradeDetailWrapper paramUpgradeDetailWrapper, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, UpgradeDetailActivity.class);
    localIntent.putExtra("detail_wrapper", paramUpgradeDetailWrapper);
    localIntent.putExtra("is_anim", paramBoolean1);
    localIntent.putExtra("download_right_now", paramBoolean2);
    localIntent.putExtra("need_left_back", paramBoolean3);
    paramActivity.startActivity(localIntent);
    if (paramBoolean1) {
      paramActivity.overridePendingTransition(2130771979, 2130771980);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).setData(Uri.parse("vivomarket://details?id=" + "com.tencent.mobileqq" + "&th_name=self_update"));
          ((Intent)localObject1).setPackage("com.bbk.appstore");
          ((Intent)localObject1).setFlags(335544320);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
          paramContext.startActivity((Intent)localObject1);
        } while (!QLog.isColorLevel());
        QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate vivo");
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setData(Uri.parse("mimarket://details?id=" + "com.tencent.mobileqq" + "&ref=com.tencent.mobileqq_selfupdate&startDownload=true"));
        ((Intent)localObject1).setPackage("com.xiaomi.market");
        ((Intent)localObject1).setFlags(335544320);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
        paramContext.startActivity((Intent)localObject1);
      } while (!QLog.isColorLevel());
      QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate xiaomi");
      return;
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + "com.tencent.mobileqq" + "&caller=" + "com.tencent.mobileqq" + "&token=273b98f0a5b2c20d&atd=true&style=0"));
      localObject4 = paramContext.getPackageManager();
      str = "";
      try
      {
        PackageInfo localPackageInfo = ((PackageManager)localObject4).getPackageInfo("com.oppo.market", 0);
        localObject1 = str;
        if (localPackageInfo != null)
        {
          localObject1 = str;
          if (localPackageInfo.applicationInfo != null)
          {
            localObject1 = str;
            if (localPackageInfo.applicationInfo.enabled) {
              localObject1 = "com.oppo.market";
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            localObject4 = ((PackageManager)localObject4).getPackageInfo("com.heytap.market", 0);
            Object localObject2 = str;
            if (localObject4 != null)
            {
              localObject2 = str;
              if (((PackageInfo)localObject4).applicationInfo != null)
              {
                localObject2 = str;
                if (((PackageInfo)localObject4).applicationInfo.enabled) {
                  localObject2 = "com.heytap.market";
                }
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            Object localObject3 = str;
          }
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localIntent.setPackage((String)localObject1);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
        paramContext.startActivity(localIntent);
      }
    } while (!QLog.isColorLevel());
    QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate oppo,oppopkg:" + (String)localObject1);
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack()) {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      label38:
      this.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
      bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  private void b(String paramString)
  {
    if ((!getIntent().getBooleanExtra("need_left_back", true)) && (this.leftView != null)) {
      this.leftView.setVisibility(4);
    }
    setTitle(paramString);
    removeWebViewLayerType();
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "invokeDownloadStateToWebView: " + paramInt);
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:onDownloadStateChanged(" + paramInt + ")");
  }
  
  public void a(int paramInt, akgo paramakgo)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Beez.obtainMessage(100, paramInt, 0).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      label7:
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeDetailActivity", 2, "loadUrl: " + paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      break label7;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearView();
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish start");
    }
    super.finish();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Beez != null)
      {
        this.jdField_a_of_type_Beez.removeMessages(100);
        this.jdField_a_of_type_Beez.removeMessages(101);
      }
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:onDestroy()");
      label74:
      if (this.jdField_b_of_type_Boolean) {
        overridePendingTransition(2130771977, 2130771978);
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish stop");
      }
      return;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      a(paramMessage.arg1);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 101) {
        akgo.a().a(false, a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_b_of_type_JavaLangString));
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = akgo.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return;
    }
    super.setContentView(2131496972);
    removeWebViewLayerType();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = ((UpgradeDetailWrapper)localIntent.getParcelableExtra("detail_wrapper"));
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_anim", true);
    akgo.a().a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Long;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4)) {
      this.jdField_a_of_type_Long = Math.min(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
    }
    String str1 = ajjy.a(2131650130);
    paramBundle = null;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL;
      str2 = "fontSetting=" + ajia.a();
      if (!paramBundle.endsWith("?")) {
        break label330;
      }
      paramBundle = paramBundle + str2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Beez = new beez(this);
      if (localIntent.getBooleanExtra("download_right_now", false)) {
        this.jdField_a_of_type_Beez.sendEmptyMessageAtTime(101, 1500L);
      }
      b(str1);
      a();
      if (paramBundle != null) {
        a(paramBundle);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
      label330:
      if (paramBundle.contains("?")) {
        paramBundle = paramBundle + "&" + str2;
      } else {
        paramBundle = paramBundle + "?" + str2;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Beez != null)
      {
        this.jdField_a_of_type_Beez.removeMessages(100);
        this.jdField_a_of_type_Beez.removeMessages(101);
      }
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:onDestroy()");
      label54:
      akgo.a().b(this);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Aqrc.a("qqupgrade");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearView();
      try
      {
        label27:
        this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label27;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (a())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    bchb.a().a(this);
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        a(akgo.a().a());
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeDetailActivity
 * JD-Core Version:    0.7.0.1
 */