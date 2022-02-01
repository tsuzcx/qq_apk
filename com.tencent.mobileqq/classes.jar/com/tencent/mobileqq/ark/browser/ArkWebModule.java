package com.tencent.mobileqq.ark.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.AbsWVModule;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.AbsWVModule.WebViewRuntimeCompat;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebEventInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkWebModule
  extends AbsWVModule
{
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private APICallback jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = null;
  private ArkWebModule.OpenAppInfo jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo = new ArkWebModule.OpenAppInfo(null);
  private String jdField_a_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private APICallback jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback = null;
  private String jdField_b_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private String c = null;
  private String d = null;
  private String e = null;
  
  private SwiftBrowserSetting a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
      if (localWebViewFragment != null) {
        return (SwiftBrowserSetting)localWebViewFragment.getComponentProvider().a(paramInt);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
        return (SwiftBrowserSetting)((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a()).getComponentProvider().a(paramInt);
      }
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
      if (localWebViewFragment != null) {
        return localWebViewFragment.getCurrentUrl();
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, byte paramByte)
  {
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    if (localWebViewFragment != null) {
      localWebViewFragment.startActivityForResult(paramIntent, paramByte);
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("ArkWebModule", 4, "startActivityForResult not called, webViewFragment != null");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkWebModule", 2, "launchAppWithTokens " + paramString3);
    }
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    if (localAppInterface == null) {
      return;
    }
    int j = 268435456;
    try
    {
      k = Integer.parseInt(paramString4);
      if ((0x4000000 & k) == 67108864) {
        j = 335544320;
      }
      i = j;
      if ((0x20000000 & k) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((k & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
      i = j;
    }
    catch (Exception paramString4)
    {
      int i;
      Activity localActivity;
      for (;;)
      {
        int k;
        String str;
        i = 268435456;
        continue;
        paramString2 = paramString4;
        if (QLog.isColorLevel())
        {
          QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
          paramString2 = paramString4;
        }
      }
      if (localActivity == null) {
        break label402;
      }
      localAppLaucherHelper.a(localAppInterface, localActivity, paramString1, paramString2, paramString3, i);
      return;
      QLog.e("ArkWebModule", 1, "launchAppWithTokens fail for context is null");
    }
    ReportController.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
    localActivity = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    if ((localActivity != null) && ((localActivity instanceof QQBrowserActivity)) && (((QQBrowserActivity)localActivity).app == null)) {
      ((QQBrowserActivity)localActivity).updateAppRuntime();
    }
    k = 0;
    str = "tencentwtlogin" + paramString1 + "://";
    j = k;
    if ("wtlogin".equals(paramString5))
    {
      paramString4 = localActivity.getPackageManager();
      paramString5 = new Intent("android.intent.action.VIEW");
      paramString5.setData(Uri.parse(str));
      j = k;
      if (paramString4 != null)
      {
        j = k;
        if (paramString4.queryIntentActivities(paramString5, 0).size() > 0) {
          j = 1;
        }
      }
    }
    if (j != 0)
    {
      paramString4 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a() != null)
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a().getUrl();
        localAppLaucherHelper.a(str, localActivity, paramString2, localAppInterface, paramString1, paramString3, i, paramString6);
        return;
      }
    }
    label402:
  }
  
  private void a(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "no auth");
      return;
    }
    String str = String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("version", str);
      DoraemonUtil.a(paramAPICallback, paramJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ArkWebModule", 1, "getArkSDKVersion error e = ", localException);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ArkWebModule", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("web-view-open-app-config");
        if (paramString == null) {
          continue;
        }
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = paramString.get(str);
          if (((localObject instanceof String)) && (localObject != null)) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, (String)localObject);
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkWebModule", 1, String.format("decodeArkH5Config, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
      }
    }
  }
  
  private void b(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "no auth");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -5, "other");
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("appID");
      this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("paramsStr");
      this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.c = paramJSONObject.optString("packageName");
      this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.d = paramJSONObject.optString("flags");
      this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.g = paramJSONObject.optString("url");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString))
      {
        QLog.e("ArkWebModule", 1, "mOpenAppinfo.appId is null");
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("ArkWebModule", 1, String.format("get mOpenAppinfo json error, err=%s", new Object[] { paramJSONObject.getMessage() }));
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString))
      {
        paramJSONObject = (Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString);
        if (paramJSONObject != null)
        {
          if (paramJSONObject.intValue() == 1)
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
            if (!PackageUtil.a(paramJSONObject, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.c))
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.g))
              {
                paramAPICallback = new Intent(paramJSONObject, QQBrowserActivity.class);
                paramAPICallback.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.g);
                paramAPICallback.putExtra("fromArkAppDownload", true);
                paramJSONObject.startActivity(paramAPICallback);
              }
              DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -4, "need to download");
              return;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.c, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.d, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.e, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.f);
            DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, APIParam.a);
            return;
          }
          if (paramJSONObject.intValue() == 0)
          {
            d();
            DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -3, "user canceled");
            return;
          }
        }
      }
      c();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        break label802;
      }
    }
    paramJSONObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    do
    {
      if (!paramJSONObject.hasNext()) {
        break;
      }
      paramAPICallback = (String)paramJSONObject.next();
    } while ((TextUtils.isEmpty(this.c)) || (!paramAPICallback.equals(this.c)));
    label802:
    for (paramJSONObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAPICallback);; paramJSONObject = "ask")
    {
      if (paramJSONObject.equals("allow"))
      {
        paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
        if (!PackageUtil.a(paramJSONObject, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.c))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.g))
          {
            paramAPICallback = new Intent(paramJSONObject, QQBrowserActivity.class);
            paramAPICallback.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.g);
            paramAPICallback.putExtra("fromArkAppDownload", true);
            paramJSONObject.startActivity(paramAPICallback);
          }
          DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -4, "need to download");
          return;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.c, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.d, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.e, this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.f);
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, APIParam.a);
        return;
      }
      if (paramJSONObject.equals("ask"))
      {
        paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
        if ((paramJSONObject == null) || (paramJSONObject.isFinishing())) {
          break;
        }
        paramAPICallback = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
        if (paramAPICallback == null) {
          break;
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule$OpenAppInfo.jdField_a_of_type_JavaLangString);
          Share.a(paramAPICallback, this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a(), paramAPICallback.getAccount(), l, 2000L, new ArkWebModule.1(this, paramJSONObject));
          return;
        }
        catch (NumberFormatException paramAPICallback)
        {
          QLog.e("ArkWebModule", 1, String.format("mOpenAppinfo appid to Long error, err=%s", new Object[] { paramAPICallback.getMessage() }));
          paramAPICallback = paramJSONObject.getString(2131690242);
          a(String.format(paramJSONObject.getString(2131690243), new Object[] { paramAPICallback }));
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
        }
      }
      if (!paramJSONObject.equals("forbidden")) {
        break;
      }
      d();
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -3, "user canceled");
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        ArkAppCenter.b(true);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
        if (localObject == null) {
          continue;
        }
        localObject = ((WebViewFragment)localObject).getArguments();
        if (localObject == null) {
          continue;
        }
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject == null) {
          continue;
        }
        this.c = ((Bundle)localObject).getString("h5_ark_app_name");
        this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("h5_ark_app_path");
        this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("h5_ark_app_des");
        b(((Bundle)localObject).getString("h5_ark_check_config"));
        this.d = ((Bundle)localObject).getString("h5_ark_nation_code");
        this.e = ((Bundle)localObject).getString("h5_ark_phone_number");
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ArkWebModule", 1, String.format("setupArkEnvironment error, err=%s", new Object[] { localException.getMessage() }));
        }
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "no auth");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    if (localObject == null)
    {
      DoraemonUtil.a(paramAPICallback, -3, "other");
      return;
    }
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)((WebViewFragment)localObject).mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler == null)
    {
      DoraemonUtil.a(paramAPICallback, -3, "other");
      return;
    }
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    try
    {
      str1 = paramJSONObject.optString("appName");
      str2 = paramJSONObject.optString("appView");
      localObject = paramJSONObject.optString("appMinVersion");
      str3 = paramJSONObject.optString("appConfig");
      str4 = paramJSONObject.optString("metaData");
      str5 = paramJSONObject.optString("appDesc");
      str6 = paramJSONObject.optString("promptText");
      str7 = paramJSONObject.optString("compatibleText");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        DoraemonUtil.a(this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      DoraemonUtil.a(paramAPICallback, -3, "other");
      return;
    }
    c();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "0.0.0.1";
    }
    localObject = QQCustomArkDialog.AppInfo.a(str1, str2, paramJSONObject, str4, ArkAppCenterUtil.a(), null, null);
    ((Bundle)localObject).putBoolean("forward_ark_app_direct", false);
    ((Bundle)localObject).putString("forward_ark_app_name", str1);
    ((Bundle)localObject).putString("forward_ark_app_view", str2);
    ((Bundle)localObject).putString("forward_ark_app_desc", str5);
    ((Bundle)localObject).putString("forward_ark_app_ver", paramJSONObject);
    ((Bundle)localObject).putString("forward_ark_app_meta", str4);
    ((Bundle)localObject).putString("forward_ark_app_prompt", str6);
    ((Bundle)localObject).putString("forward_ark_app_config", str3);
    ((Bundle)localObject).putString("forward_ark_app_compat", str7);
    ((Bundle)localObject).putBoolean("forward_ark_from_h5", true);
    paramJSONObject = new Intent();
    paramJSONObject.setClass(localSwiftBrowserShareMenuHandler.a, ForwardRecentActivity.class);
    paramJSONObject.putExtra("forward_type", 27);
    paramJSONObject.putExtra("is_ark_display_share", true);
    paramJSONObject.putExtras((Bundle)localObject);
    if (paramJSONObject != null) {
      ForwardBaseOption.a(localSwiftBrowserShareMenuHandler.a, paramJSONObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkWebModule", 2, "buildForwardIntent: " + localObject);
    }
    ReportCenter.a().a("", "", "", "1000", "101", "0", false);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
    DoraemonUtil.a(paramAPICallback, APIParam.a);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    QQToast.a(localActivity, HardCodeUtil.a(2131700803), 0).a();
  }
  
  private void d(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "no auth");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
    Object localObject;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
        paramAPICallback = new Intent();
        str1 = paramJSONObject.optString("appName");
        str2 = paramJSONObject.optString("toUin");
        int i = paramJSONObject.optInt("uinType", 0);
        str3 = paramJSONObject.optString("toNickName");
        if ((str2 != null) && (str2.length() >= 5))
        {
          paramAPICallback.setClass((Context)localObject, DirectForwardActivity.class);
          paramAPICallback.putExtra("toUin", str2);
          paramAPICallback.putExtra("uinType", i);
          paramAPICallback.putExtra("nickName", str3);
          paramAPICallback.putExtra("shareQQType", paramJSONObject.optInt("shareQQType", 13));
          paramAPICallback.putExtra("forward_type", 27);
          paramAPICallback.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramAPICallback.putExtra("k_back", paramJSONObject.optBoolean("k_back", paramJSONObject.optBoolean("back", false)));
          localObject = paramJSONObject.optString("appDesc");
          str2 = paramJSONObject.optString("appMinVersion");
          str3 = paramJSONObject.optString("appView");
          str4 = paramJSONObject.optString("appConfig");
          str5 = paramJSONObject.optString("metaData");
          str6 = paramJSONObject.optString("promptText");
          paramJSONObject = paramJSONObject.optString("compatibleText");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3))) {
            break;
          }
          DoraemonUtil.a(this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback, -2, "param error");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        DoraemonUtil.a(this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback, -4, "other");
        QLog.e("ArkWebModule", 1, "shareArkMsg error: " + paramJSONObject.toString());
        return;
      }
      paramAPICallback.putExtra("isWebCompShare", true);
      paramAPICallback.setClass((Context)localObject, ForwardRecentActivity.class);
    }
    String str7 = a();
    paramAPICallback.putExtra("forward_ark_app_name", str1);
    paramAPICallback.putExtra("forward_ark_app_view", str3);
    paramAPICallback.putExtra("forward_ark_app_desc", (String)localObject);
    paramAPICallback.putExtra("forward_ark_app_ver", str2);
    paramAPICallback.putExtra("forward_ark_app_prompt", str6);
    paramAPICallback.putExtra("forward_ark_app_meta", str5);
    paramAPICallback.putExtra("forward_ark_app_config", str4);
    paramAPICallback.putExtra("forward_ark_app_compat", paramJSONObject);
    paramAPICallback.putExtra("is_ark_display_share", true);
    paramAPICallback.putExtra("appName", str1);
    paramAPICallback.putExtra("appView", str3);
    paramAPICallback.putExtra("appMinVersion", str2);
    paramAPICallback.putExtra("metaData", str5);
    paramAPICallback.putExtra("scale", ArkAppCenterUtil.a());
    if (!TextUtils.isEmpty(str7)) {
      paramAPICallback.putExtra("forward_ark_h5_from_js", str7);
    }
    a(paramAPICallback, (byte)0);
  }
  
  private void e(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    boolean bool1 = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "no auth");
      return;
    }
    boolean bool2;
    label94:
    do
    {
      for (;;)
      {
        try
        {
          if (paramJSONObject.has("enable"))
          {
            bool2 = paramJSONObject.optBoolean("enable");
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.WebEventInterface))) {
              break;
            }
            paramJSONObject = (WebUiUtils.WebEventInterface)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.a(bool1);
            DoraemonUtil.a(paramAPICallback, APIParam.a);
          }
        }
        catch (Exception paramJSONObject)
        {
          DoraemonUtil.a(paramAPICallback, -2, "param error");
          return;
        }
        bool1 = false;
      }
      paramJSONObject = a(-1);
    } while (paramJSONObject == null);
    if (!bool2) {}
    for (bool1 = true;; bool1 = false)
    {
      paramJSONObject.a("image_long_click", bool1);
      break;
    }
  }
  
  private void f(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    boolean bool1 = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "no auth");
      return;
    }
    boolean bool2;
    label94:
    do
    {
      for (;;)
      {
        try
        {
          if (paramJSONObject.has("enable"))
          {
            bool2 = paramJSONObject.optBoolean("enable");
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.WebEventInterface))) {
              break;
            }
            paramJSONObject = (WebUiUtils.WebEventInterface)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.b(bool1);
            DoraemonUtil.a(paramAPICallback, APIParam.a);
          }
        }
        catch (Exception paramJSONObject)
        {
          DoraemonUtil.a(paramAPICallback, -2, "param error");
          return;
        }
        bool1 = false;
      }
      paramJSONObject = a(-1);
    } while (paramJSONObject == null);
    if (!bool2) {}
    for (bool1 = true;; bool1 = false)
    {
      paramJSONObject.a("web_view_long_click", bool1);
      break;
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a() instanceof ArkBrowserFragment)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramByte == 0) && (this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback != null))
    {
      if (paramInt == -1) {
        DoraemonUtil.a(this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback, APIParam.a);
      }
    }
    else {
      return;
    }
    DoraemonUtil.a(this.jdField_b_of_type_ComTencentMobileqqDoraemonAPICallback, -3, "user cancel");
  }
  
  protected void a(String paramString)
  {
    TextView localTextView1;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(BaseActivity.sTopActivity, 2131755842);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559084);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365811);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365796);
      TextView localTextView4 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365802);
      localTextView1.setText(2131719900);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView2.setText(paramString);
      }
      localTextView4.setText(2131720671);
      localTextView4.setOnClickListener(new ArkWebModule.2(this));
      localTextView3.setOnClickListener(new ArkWebModule.3(this));
      localTextView3.setText(2131690800);
    }
    do
    {
      return;
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807);
    } while (TextUtils.isEmpty(paramString));
    localTextView1.setText(paramString);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 13: 
      a(paramJSONObject, paramAPICallback);
    }
    for (;;)
    {
      return true;
      c(paramJSONObject, paramAPICallback);
      continue;
      d(paramJSONObject, paramAPICallback);
      continue;
      b(paramJSONObject, paramAPICallback);
      continue;
      e(paramJSONObject, paramAPICallback);
      continue;
      f(paramJSONObject, paramAPICallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkWebModule
 * JD-Core Version:    0.7.0.1
 */