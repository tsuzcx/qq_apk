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
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
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
  private Dialog c = null;
  private boolean d = false;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private ConcurrentHashMap<String, String> j = new ConcurrentHashMap();
  private boolean k = false;
  private APICallback l = null;
  private ArkWebModule.OpenAppInfo m = new ArkWebModule.OpenAppInfo(null);
  private ConcurrentHashMap<String, Integer> n = new ConcurrentHashMap();
  private APICallback o = null;
  
  private SwiftBrowserSetting a(int paramInt)
  {
    if (this.b != null)
    {
      WebViewFragment localWebViewFragment = this.b.e();
      if (localWebViewFragment != null) {
        return (SwiftBrowserSetting)localWebViewFragment.getComponentProvider().a(paramInt);
      }
      if ((this.b.c() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
        return (SwiftBrowserSetting)((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)this.b.c()).getComponentProvider().a(paramInt);
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, byte paramByte)
  {
    WebViewFragment localWebViewFragment = this.b.e();
    if (localWebViewFragment != null)
    {
      localWebViewFragment.startActivityForResult(paramIntent, paramByte);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ArkWebModule", 4, "startActivityForResult not called, webViewFragment != null");
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("launchAppWithTokens ");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.d("ArkWebModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new AppLaucherHelper();
    AppInterface localAppInterface = this.b.b();
    if (localAppInterface == null) {
      return;
    }
    int i2 = 268435456;
    try
    {
      i3 = Integer.parseInt(paramString4);
      if ((i3 & 0x4000000) == 67108864) {
        i2 = 335544320;
      }
      i1 = i2;
      if ((i3 & 0x20000000) == 536870912) {
        i1 = i2 | 0x20000000;
      }
      i2 = i1;
      if ((i3 & 0x400000) == 4194304) {
        i2 = i1 | 0x400000;
      }
      i1 = i2;
    }
    catch (Exception paramString4)
    {
      int i3;
      int i1;
      label142:
      Object localObject2;
      boolean bool;
      Intent localIntent;
      break label142;
    }
    i1 = 268435456;
    ReportController.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
    paramString4 = this.b.c();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tencentwtlogin");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("://");
    localObject2 = ((StringBuilder)localObject2).toString();
    bool = "wtlogin".equals(paramString5);
    i3 = 0;
    i2 = i3;
    if (bool)
    {
      paramString5 = paramString4.getPackageManager();
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse((String)localObject2));
      i2 = i3;
      if (paramString5 != null)
      {
        i2 = i3;
        if (paramString5.queryIntentActivities(localIntent, 0).size() > 0) {
          i2 = 1;
        }
      }
    }
    if (i2 != 0)
    {
      if (this.b.a() != null)
      {
        paramString2 = this.b.a().getUrl();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
        }
        paramString2 = "";
      }
      ((AppLaucherHelper)localObject1).a((String)localObject2, paramString4, paramString2, localAppInterface, paramString1, paramString3, i1, paramString6);
      return;
    }
    if (paramString4 != null)
    {
      ((AppLaucherHelper)localObject1).a(localAppInterface, paramString4, paramString1, paramString2, paramString3, i1);
      return;
    }
    QLog.e("ArkWebModule", 1, "launchAppWithTokens fail for context is null");
  }
  
  private void a(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.k)
    {
      DoraemonUtil.a(this.l, -1, "no auth");
      return;
    }
    String str = String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("version", str);
    }
    catch (Exception localException)
    {
      QLog.e("ArkWebModule", 1, "getArkSDKVersion error e = ", localException);
    }
    DoraemonUtil.a(paramAPICallback, paramJSONObject);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ArkWebModule", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
      return;
    }
    this.j.clear();
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("web-view-open-app-config");
      if (paramString != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = paramString.get(str);
          if (((localObject instanceof String)) && (localObject != null)) {
            this.j.put(str, (String)localObject);
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ArkWebModule", 1, String.format("decodeArkH5Config, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  private void b(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.k)
    {
      DoraemonUtil.a(this.l, -1, "no auth");
      return;
    }
    this.l = paramAPICallback;
    paramAPICallback = this.c;
    if ((paramAPICallback != null) && (paramAPICallback.isShowing()))
    {
      DoraemonUtil.a(this.l, -5, "other");
      return;
    }
    try
    {
      this.m.a = paramJSONObject.optString("appID");
      this.m.b = paramJSONObject.optString("paramsStr");
      this.m.c = paramJSONObject.optString("packageName");
      this.m.d = paramJSONObject.optString("flags");
      this.m.g = paramJSONObject.optString("url");
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("ArkWebModule", 1, String.format("get mOpenAppinfo json error, err=%s", new Object[] { paramJSONObject.getMessage() }));
    }
    if (TextUtils.isEmpty(this.m.a))
    {
      QLog.e("ArkWebModule", 1, "mOpenAppinfo.appId is null");
      DoraemonUtil.a(this.l, -2, "param error");
      return;
    }
    if (this.n.containsKey(this.m.a))
    {
      paramJSONObject = (Integer)this.n.get(this.m.a);
      if (paramJSONObject != null)
      {
        if (paramJSONObject.intValue() == 1)
        {
          paramJSONObject = this.b.c();
          if (!PackageUtil.a(paramJSONObject, this.m.c))
          {
            if (!TextUtils.isEmpty(this.m.g))
            {
              paramAPICallback = new Intent(paramJSONObject, QQBrowserActivity.class);
              paramAPICallback.putExtra("url", this.m.g);
              paramAPICallback.putExtra("fromArkAppDownload", true);
              paramJSONObject.startActivity(paramAPICallback);
            }
            DoraemonUtil.a(this.l, -4, "need to download");
            return;
          }
          a(this.m.a, this.m.b, this.m.c, this.m.d, this.m.e, this.m.f);
          DoraemonUtil.a(this.l, APIParam.a);
          return;
        }
        if (paramJSONObject.intValue() == 0)
        {
          d();
          DoraemonUtil.a(this.l, -3, "user canceled");
          return;
        }
      }
    }
    c();
    paramJSONObject = this.j;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.keySet().iterator();
      while (paramJSONObject.hasNext())
      {
        paramAPICallback = (String)paramJSONObject.next();
        if ((!TextUtils.isEmpty(this.g)) && (paramAPICallback.equals(this.g)))
        {
          paramJSONObject = (String)this.j.get(paramAPICallback);
          break label483;
        }
      }
    }
    paramJSONObject = "ask";
    label483:
    if (paramJSONObject.equals("allow"))
    {
      paramJSONObject = this.b.c();
      if (!PackageUtil.a(paramJSONObject, this.m.c))
      {
        if (!TextUtils.isEmpty(this.m.g))
        {
          paramAPICallback = new Intent(paramJSONObject, QQBrowserActivity.class);
          paramAPICallback.putExtra("url", this.m.g);
          paramAPICallback.putExtra("fromArkAppDownload", true);
          paramJSONObject.startActivity(paramAPICallback);
        }
        DoraemonUtil.a(this.l, -4, "need to download");
        return;
      }
      a(this.m.a, this.m.b, this.m.c, this.m.d, this.m.e, this.m.f);
      DoraemonUtil.a(this.l, APIParam.a);
      return;
    }
    if (paramJSONObject.equals("ask"))
    {
      paramJSONObject = this.b.c();
      if (paramJSONObject != null)
      {
        if (paramJSONObject.isFinishing()) {
          return;
        }
        paramAPICallback = this.b.b();
        if (paramAPICallback == null) {
          return;
        }
        try
        {
          long l1 = Long.parseLong(this.m.a);
          Share.a(paramAPICallback, this.b.c(), paramAPICallback.getAccount(), l1, 2000L, new ArkWebModule.1(this, paramJSONObject));
          return;
        }
        catch (NumberFormatException paramAPICallback)
        {
          QLog.e("ArkWebModule", 1, String.format("mOpenAppinfo appid to Long error, err=%s", new Object[] { paramAPICallback.getMessage() }));
          paramAPICallback = paramJSONObject.getString(2131887057);
          a(String.format(paramJSONObject.getString(2131887058), new Object[] { paramAPICallback }));
          this.c.show();
          return;
        }
      }
      return;
    }
    if (paramJSONObject.equals("forbidden"))
    {
      d();
      DoraemonUtil.a(this.l, -3, "user canceled");
    }
  }
  
  private void c()
  {
    if (this.d) {
      return;
    }
    try
    {
      ArkMultiProcUtil.a();
    }
    catch (Exception localException)
    {
      QLog.e("ArkWebModule", 1, String.format("setupArkEnvironment error, err=%s", new Object[] { localException.getMessage() }));
    }
    Object localObject = this.b.e();
    if (localObject != null)
    {
      localObject = ((WebViewFragment)localObject).getArguments();
      if (localObject != null)
      {
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject != null)
        {
          this.g = ((Bundle)localObject).getString("h5_ark_app_name");
          this.e = ((Bundle)localObject).getString("h5_ark_app_path");
          this.f = ((Bundle)localObject).getString("h5_ark_app_des");
          b(((Bundle)localObject).getString("h5_ark_check_config"));
          this.h = ((Bundle)localObject).getString("h5_ark_nation_code");
          this.i = ((Bundle)localObject).getString("h5_ark_phone_number");
          this.d = true;
        }
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    Object localObject = this;
    if (!((ArkWebModule)localObject).k)
    {
      DoraemonUtil.a(((ArkWebModule)localObject).l, -1, "no auth");
      return;
    }
    localObject = ((ArkWebModule)localObject).b.e();
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
      bool = TextUtils.isEmpty(str1);
      if (bool) {}
    }
    catch (Exception paramJSONObject)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      boolean bool;
      float f1;
      label465:
      label472:
      label492:
      label499:
      label503:
      break label499;
    }
    try
    {
      if (!TextUtils.isEmpty(str2))
      {
        c();
        bool = TextUtils.isEmpty((CharSequence)localObject);
        paramJSONObject = (JSONObject)localObject;
        if (bool) {
          paramJSONObject = "0.0.0.1";
        }
        f1 = ArkAppCenterUtil.d();
      }
    }
    catch (Exception paramJSONObject)
    {
      break label472;
    }
    try
    {
      localObject = QQCustomArkDialog.AppInfo.a(str1, str2, paramJSONObject, str4, f1, null, null);
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
      paramJSONObject.setClass(localSwiftBrowserShareMenuHandler.d, ForwardRecentActivity.class);
      paramJSONObject.putExtra("forward_type", 27);
      paramJSONObject.putExtra("is_ark_display_share", true);
      paramJSONObject.putExtras((Bundle)localObject);
      ForwardBaseOption.a(localSwiftBrowserShareMenuHandler.d, paramJSONObject);
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("buildForwardIntent: ");
        paramJSONObject.append(localObject);
        QLog.i("ArkWebModule", 2, paramJSONObject.toString());
      }
      ReportCenter.a().a("", "", "", "1000", "101", "0", false);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label465;
    }
    paramJSONObject = "other";
    break label503;
    paramJSONObject = "other";
    try
    {
      DoraemonUtil.a(this.o, -2, "param error");
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label492;
    }
    paramJSONObject = "other";
    break label503;
    paramJSONObject = "other";
    DoraemonUtil.a(paramAPICallback, -3, paramJSONObject);
  }
  
  private void d()
  {
    if (this.b == null) {
      return;
    }
    Activity localActivity = this.b.c();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      QQToast.makeText(localActivity, HardCodeUtil.a(2131898971), 0).show();
    }
  }
  
  private void d(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    Object localObject1 = this;
    if (!((ArkWebModule)localObject1).k)
    {
      DoraemonUtil.a(((ArkWebModule)localObject1).l, -1, "no auth");
      return;
    }
    ((ArkWebModule)localObject1).o = paramAPICallback;
    label539:
    for (;;)
    {
      try
      {
        Object localObject2 = ((ArkWebModule)localObject1).b.c();
        paramAPICallback = new Intent();
        localObject1 = paramJSONObject.optString("appName");
        String str1 = paramJSONObject.optString("toUin");
        int i1 = paramJSONObject.optInt("uinType", 0);
        String str2 = paramJSONObject.optString("toNickName");
        if (str1 == null) {
          break label539;
        }
        try
        {
          if (str1.length() >= 5)
          {
            paramAPICallback.setClass((Context)localObject2, DirectForwardActivity.class);
            paramAPICallback.putExtra("toUin", str1);
            paramAPICallback.putExtra("uinType", i1);
            paramAPICallback.putExtra("nickName", str2);
          }
          else
          {
            paramAPICallback.putExtra("isWebCompShare", true);
            paramAPICallback.setClass((Context)localObject2, ForwardRecentActivity.class);
          }
          paramAPICallback.putExtra("shareQQType", paramJSONObject.optInt("shareQQType", 13));
          paramAPICallback.putExtra("forward_type", 27);
          paramAPICallback.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramAPICallback.putExtra("k_back", paramJSONObject.optBoolean("k_back", paramJSONObject.optBoolean("back", false)));
          localObject2 = paramJSONObject.optString("appDesc");
          str1 = paramJSONObject.optString("appMinVersion");
          str2 = paramJSONObject.optString("appView");
          String str3 = paramJSONObject.optString("appConfig");
          String str4 = paramJSONObject.optString("metaData");
          String str5 = paramJSONObject.optString("promptText");
          paramJSONObject = paramJSONObject.optString("compatibleText");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str2)))
          {
            String str6 = e();
            paramAPICallback.putExtra("forward_ark_app_name", (String)localObject1);
            paramAPICallback.putExtra("forward_ark_app_view", str2);
            paramAPICallback.putExtra("forward_ark_app_desc", (String)localObject2);
            paramAPICallback.putExtra("forward_ark_app_ver", str1);
            paramAPICallback.putExtra("forward_ark_app_prompt", str5);
            paramAPICallback.putExtra("forward_ark_app_meta", str4);
            paramAPICallback.putExtra("forward_ark_app_config", str3);
            paramAPICallback.putExtra("forward_ark_app_compat", paramJSONObject);
            paramAPICallback.putExtra("is_ark_display_share", true);
            paramAPICallback.putExtra("appName", (String)localObject1);
            paramAPICallback.putExtra("appView", str2);
            paramAPICallback.putExtra("appMinVersion", str1);
            paramAPICallback.putExtra("metaData", str4);
            paramAPICallback.putExtra("scale", ArkAppCenterUtil.d());
            if (!TextUtils.isEmpty(str6)) {
              paramAPICallback.putExtra("forward_ark_h5_from_js", str6);
            }
            a(paramAPICallback, (byte)0);
            return;
          }
          DoraemonUtil.a(this.o, -2, "param error");
          return;
        }
        catch (Exception paramJSONObject) {}
        DoraemonUtil.a(this.o, -4, "other");
      }
      catch (Exception paramJSONObject) {}
      paramAPICallback = new StringBuilder();
      paramAPICallback.append("shareArkMsg error: ");
      paramAPICallback.append(paramJSONObject.toString());
      QLog.e("ArkWebModule", 1, paramAPICallback.toString());
      return;
    }
  }
  
  private String e()
  {
    if (this.b != null)
    {
      WebViewFragment localWebViewFragment = this.b.e();
      if (localWebViewFragment != null) {
        return localWebViewFragment.getCurrentUrl();
      }
    }
    return null;
  }
  
  private void e(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.k)
    {
      DoraemonUtil.a(this.l, -1, "no auth");
      return;
    }
    try
    {
      if (!paramJSONObject.has("enable")) {
        break label121;
      }
      bool3 = paramJSONObject.optBoolean("enable");
      paramJSONObject = this.b.d();
      bool2 = true;
      bool1 = true;
      if ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.WebEventInterface))) {
        break label84;
      }
      paramJSONObject = (WebUiUtils.WebEventInterface)paramJSONObject;
      if (bool3) {
        break label135;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool2;
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    paramJSONObject.a(bool1);
    break label113;
    label84:
    paramJSONObject = a(-1);
    if (paramJSONObject != null)
    {
      if (!bool3)
      {
        bool1 = bool2;
        paramJSONObject.a("image_long_click", bool1);
      }
    }
    else
    {
      label113:
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      return;
      label121:
      DoraemonUtil.a(paramAPICallback, -2, "param error");
      return;
    }
  }
  
  private void f(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (!this.k)
    {
      DoraemonUtil.a(this.l, -1, "no auth");
      return;
    }
    try
    {
      if (!paramJSONObject.has("enable")) {
        break label121;
      }
      bool3 = paramJSONObject.optBoolean("enable");
      paramJSONObject = this.b.d();
      bool2 = true;
      bool1 = true;
      if ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.WebEventInterface))) {
        break label84;
      }
      paramJSONObject = (WebUiUtils.WebEventInterface)paramJSONObject;
      if (bool3) {
        break label135;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool2;
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    paramJSONObject.b(bool1);
    break label113;
    label84:
    paramJSONObject = a(-1);
    if (paramJSONObject != null)
    {
      if (!bool3)
      {
        bool1 = bool2;
        paramJSONObject.a("web_view_long_click", bool1);
      }
    }
    else
    {
      label113:
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      return;
      label121:
      DoraemonUtil.a(paramAPICallback, -2, "param error");
      return;
    }
  }
  
  protected void a()
  {
    super.a();
    if ((this.b.e() instanceof ArkBrowserFragment)) {
      this.k = true;
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 0)
    {
      paramIntent = this.o;
      if (paramIntent != null)
      {
        if (paramInt == -1)
        {
          DoraemonUtil.a(paramIntent, APIParam.a);
          return;
        }
        DoraemonUtil.a(paramIntent, -3, "user cancel");
      }
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      this.c = new ReportDialog(BaseActivity.sTopActivity, 2131953338);
      this.c.setContentView(2131624611);
      localObject = (TextView)this.c.findViewById(2131431880);
      TextView localTextView1 = (TextView)this.c.findViewById(2131431876);
      TextView localTextView2 = (TextView)this.c.findViewById(2131431864);
      TextView localTextView3 = (TextView)this.c.findViewById(2131431870);
      ((TextView)localObject).setText(2131917233);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView1.setText(paramString);
      }
      localTextView3.setText(2131918066);
      localTextView3.setOnClickListener(new ArkWebModule.2(this));
      localTextView2.setOnClickListener(new ArkWebModule.3(this));
      localTextView2.setText(2131887648);
      return;
    }
    localObject = (TextView)((Dialog)localObject).findViewById(2131431876);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 16: 
      d(paramJSONObject, paramAPICallback);
      break;
    case 15: 
      c(paramJSONObject, paramAPICallback);
      break;
    case 14: 
      b(paramJSONObject, paramAPICallback);
      break;
    case 13: 
      a(paramJSONObject, paramAPICallback);
      break;
    case 12: 
      f(paramJSONObject, paramAPICallback);
      break;
    case 11: 
      e(paramJSONObject, paramAPICallback);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkWebModule
 * JD-Core Version:    0.7.0.1
 */