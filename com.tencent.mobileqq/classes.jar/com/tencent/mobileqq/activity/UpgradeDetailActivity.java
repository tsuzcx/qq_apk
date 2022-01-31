package com.tencent.mobileqq.activity;

import acow;
import acox;
import acoy;
import ajwc;
import ajya;
import akuz;
import akvc;
import akve;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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
import arlw;
import axqy;
import bbdj;
import bbgu;
import bdlr;
import bfnk;
import bgyp;
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
  implements akvc, Handler.Callback
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  public ProgressBar a;
  private arlw jdField_a_of_type_Arlw;
  bfnk jdField_a_of_type_Bfnk;
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
        boolean bool;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID exception:" + paramString.getMessage());
        i = j;
        continue;
        i = j;
        if (!paramString.contains("huawei")) {
          continue;
        }
        i = j;
        if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
          continue;
        }
        int k = ((PackageManager)localObject).getPackageInfo("com.huawei.appmarket", 0).versionCode;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("UpgradeDetailActivity", 2, "supportGoMarketPhoneID versioncode:" + k);
        i = j;
        if (k < 80003300) {
          continue;
        }
        i = 4;
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
        if (!paramString.contains("oppo")) {
          continue;
        }
        bool = Build.MANUFACTURER.equalsIgnoreCase("oppo");
        if (!bool) {
          continue;
        }
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
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377892);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((ProtectedWebView)findViewById(2131377894));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + bgyp.a());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new acoy(this, null));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new acox(this, null));
    this.jdField_a_of_type_Arlw = new arlw();
    this.jdField_a_of_type_Arlw.a(new UpgradeDetailActivity.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131377895));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt2 == 1)
            {
              axqy.b(null, "dc00898", "", "", "0X800AB96", "0X800AB96", 0, 0, "", "", "", "");
              return;
            }
            if (paramInt2 == 2)
            {
              axqy.b(null, "dc00898", "", "", "0X800AB97", "0X800AB97", 0, 0, "", "", "", "");
              return;
            }
          } while (paramInt2 != 3);
          axqy.b(null, "dc00898", "", "", "0X800AB98", "0X800AB98", 0, 0, "", "", "", "");
          return;
          if (paramInt2 == 1)
          {
            axqy.b(null, "dc00898", "", "", "0X800AB99", "0X800AB99", 0, 0, "", "", "", "");
            return;
          }
          if (paramInt2 == 2)
          {
            axqy.b(null, "dc00898", "", "", "0X800AB9A", "0X800AB9A", 0, 0, "", "", "", "");
            return;
          }
        } while (paramInt2 != 3);
        axqy.b(null, "dc00898", "", "", "0X800AB9B", "0X800AB9B", 0, 0, "", "", "", "");
        return;
        if (paramInt2 == 1)
        {
          axqy.b(null, "dc00898", "", "", "0X800AB9C", "0X800AB9C", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt2 == 2)
        {
          axqy.b(null, "dc00898", "", "", "0X800AB9D", "0X800AB9D", 0, 0, "", "", "", "");
          return;
        }
      } while (paramInt2 != 3);
      axqy.b(null, "dc00898", "", "", "0X800AB9E", "0X800AB9E", 0, 0, "", "", "", "");
      return;
      if (paramInt2 == 1)
      {
        axqy.b(null, "dc00898", "", "", "0X800AB9F", "0X800AB9F", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt2 == 2)
      {
        axqy.b(null, "dc00898", "", "", "0X800ABA0", "0X800ABA0", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt2 != 3);
    axqy.b(null, "dc00898", "", "", "0X800ABA1", "0X800ABA1", 0, 0, "", "", "", "");
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
  
  private void a(Context paramContext, int paramInt)
  {
    Object localObject1;
    Intent localIntent;
    Object localObject4;
    String str;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
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
    case 3: 
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + "com.tencent.mobileqq" + "&caller=" + "com.tencent.mobileqq" + "&token=273b98f0a5b2c20d&atd=true&style=0"));
      localObject4 = paramContext.getPackageManager();
      str = "";
    }
    for (;;)
    {
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
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localIntent.setPackage((String)localObject1);
          localIntent.setFlags(270532608);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
          paramContext.startActivity(localIntent);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate oppo,oppopkg:" + (String)localObject1);
        return;
      }
      catch (Throwable localThrowable1) {}
      try
      {
        localObject4 = ((PackageManager)localObject4).getPackageInfo("com.heytap.market", 0);
        localObject2 = str;
        if (localObject4 == null) {
          continue;
        }
        localObject2 = str;
        if (((PackageInfo)localObject4).applicationInfo == null) {
          continue;
        }
        localObject2 = str;
        if (!((PackageInfo)localObject4).applicationInfo.enabled) {
          continue;
        }
        localObject2 = "com.heytap.market";
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject3 = str;
      }
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("hiapplink://com.huawei.appmarket?appId=C9319&accessID=%2F687abcc2447f49059f0c8873390a1686&caller=" + "com.tencent.mobileqq"));
      ((Intent)localObject2).setPackage("com.huawei.appmarket");
      ((Intent)localObject2).setFlags(335544320);
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_appstore");
      paramContext.startActivity((Intent)localObject2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate huawei");
      return;
    }
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
  
  private void b(boolean paramBoolean)
  {
    Object localObject;
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("checkAndStartdownload");
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          break label82;
        }
      }
      label82:
      for (str1 = "null";; str1 = "iIncrementUpgrade==1")
      {
        QLog.d("UpgradeDetailActivity", 2, str1);
        akuz.a().b(false);
        return;
      }
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "checkAndStartdownload market supportMarketID:" + i);
    }
    if (i != 0)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Bfnk.obtainMessage(100, 0, 0).sendToTarget();
      }
      localObject = bbdj.a(this, 230);
      acow localacow = new acow(this, i);
      str1 = "";
      switch (i)
      {
      }
      for (;;)
      {
        String str2 = getString(2131691662, new Object[] { str1 });
        str1 = getString(2131691660, new Object[] { str1 });
        ((bbgu)localObject).setMessage(str2);
        ((bbgu)localObject).setTitle(2131691664);
        ((bbgu)localObject).setNegativeButton(2131691659, localacow);
        ((bbgu)localObject).setPositiveButton(str1, getResources().getColor(2131165297), localacow);
        ((bbgu)localObject).show();
        a(i, 1);
        return;
        str1 = getString(2131691666);
        continue;
        str1 = getString(2131691665);
        continue;
        str1 = getString(2131691663);
        continue;
        str1 = getString(2131691661);
      }
    }
    akuz.a().b(false);
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
  
  public void a(int paramInt, akuz paramakuz)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bfnk.obtainMessage(100, paramInt, 0).sendToTarget();
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
      if (this.jdField_a_of_type_Bfnk != null)
      {
        this.jdField_a_of_type_Bfnk.removeMessages(100);
        this.jdField_a_of_type_Bfnk.removeMessages(101);
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
        b(false);
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
    paramBundle = akuz.a().a();
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0))
    {
      finish();
      return;
    }
    super.setContentView(2131562571);
    removeWebViewLayerType();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = ((UpgradeDetailWrapper)localIntent.getParcelableExtra("detail_wrapper"));
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_anim", true);
    akuz.a().a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akve != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akve.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akve.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_Akve.jdField_a_of_type_Long;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4)) {
      this.jdField_a_of_type_Long = Math.min(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
    }
    String str1 = ajya.a(2131715932);
    paramBundle = null;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL;
      str2 = "fontSetting=" + ajwc.a();
      if (!paramBundle.endsWith("?")) {
        break label332;
      }
      paramBundle = paramBundle + str2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfnk = new bfnk(this);
      if (localIntent.getBooleanExtra("download_right_now", false)) {
        this.jdField_a_of_type_Bfnk.sendEmptyMessageAtTime(101, 1500L);
      }
      b(str1);
      a();
      if (paramBundle != null) {
        a(paramBundle);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
      label332:
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
      if (this.jdField_a_of_type_Bfnk != null)
      {
        this.jdField_a_of_type_Bfnk.removeMessages(100);
        this.jdField_a_of_type_Bfnk.removeMessages(101);
      }
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:onDestroy()");
      label54:
      akuz.a().b(this);
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
    this.jdField_a_of_type_Arlw.a("qqupgrade");
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
    bdlr.a().a(this);
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        a(akuz.a().a());
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