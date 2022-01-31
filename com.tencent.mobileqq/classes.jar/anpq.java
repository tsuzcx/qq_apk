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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class anpq
  extends abza
{
  private abwu jdField_a_of_type_Abwu;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private anpu jdField_a_of_type_Anpu = new anpu(null);
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private abwu jdField_b_of_type_Abwu;
  private String jdField_b_of_type_JavaLangString;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  private beiq a(int paramInt)
  {
    if (this.jdField_a_of_type_Abzb != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_Abzb.a();
      if (localWebViewFragment != null) {
        return (beiq)localWebViewFragment.b().a(paramInt);
      }
      if ((this.jdField_a_of_type_Abzb.a() instanceof behu)) {
        return (beiq)((behu)this.jdField_a_of_type_Abzb.a()).b().a(paramInt);
      }
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_Abzb != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_Abzb.a();
      if (localWebViewFragment != null) {
        return localWebViewFragment.b();
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, byte paramByte)
  {
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_Abzb.a();
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
    ayyy localayyy = new ayyy();
    AppInterface localAppInterface = this.jdField_a_of_type_Abzb.a();
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
      localayyy.a(localAppInterface, localActivity, paramString1, paramString2, paramString3, i);
      return;
      QLog.e("ArkWebModule", 1, "launchAppWithTokens fail for context is null");
    }
    azqs.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
    localActivity = this.jdField_a_of_type_Abzb.a();
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
      if (this.jdField_a_of_type_Abzb.a() != null)
      {
        paramString2 = this.jdField_a_of_type_Abzb.a().getUrl();
        localayyy.a(str, localActivity, paramString2, localAppInterface, paramString1, paramString3, i, paramString6);
        return;
      }
    }
    label402:
  }
  
  private void a(JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      acab.a(this.jdField_a_of_type_Abwu, -1, "no auth");
      return;
    }
    String str = String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("version", str);
      acab.a(paramabwu, paramJSONObject);
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
  
  private void b(JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      acab.a(this.jdField_a_of_type_Abwu, -1, "no auth");
      return;
    }
    this.jdField_a_of_type_Abwu = paramabwu;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      acab.a(this.jdField_a_of_type_Abwu, -5, "other");
      return;
    }
    try
    {
      this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString = paramJSONObject.optString("appID");
      this.jdField_a_of_type_Anpu.jdField_b_of_type_JavaLangString = paramJSONObject.optString("paramsStr");
      this.jdField_a_of_type_Anpu.c = paramJSONObject.optString("packageName");
      this.jdField_a_of_type_Anpu.d = paramJSONObject.optString("flags");
      this.jdField_a_of_type_Anpu.g = paramJSONObject.optString("url");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString))
      {
        QLog.e("ArkWebModule", 1, "mOpenAppinfo.appId is null");
        acab.a(this.jdField_a_of_type_Abwu, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("ArkWebModule", 1, String.format("get mOpenAppinfo json error, err=%s", new Object[] { paramJSONObject.getMessage() }));
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString))
      {
        paramJSONObject = (Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString);
        if (paramJSONObject != null)
        {
          if (paramJSONObject.intValue() == 1)
          {
            paramJSONObject = this.jdField_a_of_type_Abzb.a();
            if (!bdiv.a(paramJSONObject, this.jdField_a_of_type_Anpu.c))
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Anpu.g))
              {
                paramabwu = new Intent(paramJSONObject, QQBrowserActivity.class);
                paramabwu.putExtra("url", this.jdField_a_of_type_Anpu.g);
                paramabwu.putExtra("fromArkAppDownload", true);
                paramJSONObject.startActivity(paramabwu);
              }
              acab.a(this.jdField_a_of_type_Abwu, -4, "need to download");
              return;
            }
            a(this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anpu.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anpu.c, this.jdField_a_of_type_Anpu.d, this.jdField_a_of_type_Anpu.e, this.jdField_a_of_type_Anpu.f);
            acab.a(this.jdField_a_of_type_Abwu, abww.a);
            return;
          }
          if (paramJSONObject.intValue() == 0)
          {
            d();
            acab.a(this.jdField_a_of_type_Abwu, -3, "user canceled");
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
      paramabwu = (String)paramJSONObject.next();
    } while ((TextUtils.isEmpty(this.c)) || (!paramabwu.equals(this.c)));
    label802:
    for (paramJSONObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramabwu);; paramJSONObject = "ask")
    {
      if (paramJSONObject.equals("allow"))
      {
        paramJSONObject = this.jdField_a_of_type_Abzb.a();
        if (!bdiv.a(paramJSONObject, this.jdField_a_of_type_Anpu.c))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Anpu.g))
          {
            paramabwu = new Intent(paramJSONObject, QQBrowserActivity.class);
            paramabwu.putExtra("url", this.jdField_a_of_type_Anpu.g);
            paramabwu.putExtra("fromArkAppDownload", true);
            paramJSONObject.startActivity(paramabwu);
          }
          acab.a(this.jdField_a_of_type_Abwu, -4, "need to download");
          return;
        }
        a(this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anpu.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anpu.c, this.jdField_a_of_type_Anpu.d, this.jdField_a_of_type_Anpu.e, this.jdField_a_of_type_Anpu.f);
        acab.a(this.jdField_a_of_type_Abwu, abww.a);
        return;
      }
      if (paramJSONObject.equals("ask"))
      {
        paramJSONObject = this.jdField_a_of_type_Abzb.a();
        if ((paramJSONObject == null) || (paramJSONObject.isFinishing())) {
          break;
        }
        paramabwu = this.jdField_a_of_type_Abzb.a();
        if (paramabwu == null) {
          break;
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_Anpu.jdField_a_of_type_JavaLangString);
          zfy.a(paramabwu, this.jdField_a_of_type_Abzb.a(), paramabwu.getAccount(), l, 2000L, new anpr(this, paramJSONObject));
          return;
        }
        catch (NumberFormatException paramabwu)
        {
          QLog.e("ArkWebModule", 1, String.format("mOpenAppinfo appid to Long error, err=%s", new Object[] { paramabwu.getMessage() }));
          paramabwu = paramJSONObject.getString(2131690285);
          a(String.format(paramJSONObject.getString(2131690286), new Object[] { paramabwu }));
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
        }
      }
      if (!paramJSONObject.equals("forbidden")) {
        break;
      }
      d();
      acab.a(this.jdField_a_of_type_Abwu, -3, "user canceled");
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
        Object localObject = this.jdField_a_of_type_Abzb.a();
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
  
  private void c(JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      acab.a(this.jdField_a_of_type_Abwu, -1, "no auth");
      return;
    }
    Object localObject = this.jdField_a_of_type_Abzb.a();
    if (localObject == null)
    {
      acab.a(paramabwu, -3, "other");
      return;
    }
    beir localbeir = (beir)((WebViewFragment)localObject).a.a(4);
    if (localbeir == null)
    {
      acab.a(paramabwu, -3, "other");
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
        acab.a(this.jdField_b_of_type_Abwu, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      acab.a(paramabwu, -3, "other");
      return;
    }
    c();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "0.0.0.1";
    }
    localObject = bdjt.a(str1, str2, paramJSONObject, str4, anob.a(), null, null);
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
    paramJSONObject.setClass(localbeir.a, ForwardRecentActivity.class);
    paramJSONObject.putExtra("forward_type", 27);
    paramJSONObject.putExtra("is_ark_display_share", true);
    paramJSONObject.putExtras((Bundle)localObject);
    if (paramJSONObject != null) {
      aryv.a(localbeir.a, paramJSONObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkWebModule", 2, "buildForwardIntent: " + localObject);
    }
    bfhz.a().a("", "", "", "1000", "101", "0", false);
    azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
    acab.a(paramabwu, abww.a);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Abzb == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.jdField_a_of_type_Abzb.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    QQToast.a(localActivity, alud.a(2131701107), 0).a();
  }
  
  private void d(JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      acab.a(this.jdField_a_of_type_Abwu, -1, "no auth");
      return;
    }
    this.jdField_b_of_type_Abwu = paramabwu;
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
        localObject = this.jdField_a_of_type_Abzb.a();
        paramabwu = new Intent();
        str1 = paramJSONObject.optString("appName");
        str2 = paramJSONObject.optString("toUin");
        int i = paramJSONObject.optInt("uinType", 0);
        str3 = paramJSONObject.optString("toNickName");
        if ((str2 != null) && (str2.length() >= 5))
        {
          paramabwu.setClass((Context)localObject, DirectForwardActivity.class);
          paramabwu.putExtra("toUin", str2);
          paramabwu.putExtra("uinType", i);
          paramabwu.putExtra("nickName", str3);
          paramabwu.putExtra("shareQQType", paramJSONObject.optInt("shareQQType", 13));
          paramabwu.putExtra("forward_type", 27);
          paramabwu.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramabwu.putExtra("k_back", paramJSONObject.optBoolean("k_back", paramJSONObject.optBoolean("back", false)));
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
          acab.a(this.jdField_b_of_type_Abwu, -2, "param error");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        acab.a(this.jdField_b_of_type_Abwu, -4, "other");
        QLog.e("ArkWebModule", 1, "shareArkMsg error: " + paramJSONObject.toString());
        return;
      }
      paramabwu.putExtra("isWebCompShare", true);
      paramabwu.setClass((Context)localObject, ForwardRecentActivity.class);
    }
    String str7 = a();
    paramabwu.putExtra("forward_ark_app_name", str1);
    paramabwu.putExtra("forward_ark_app_view", str3);
    paramabwu.putExtra("forward_ark_app_desc", (String)localObject);
    paramabwu.putExtra("forward_ark_app_ver", str2);
    paramabwu.putExtra("forward_ark_app_prompt", str6);
    paramabwu.putExtra("forward_ark_app_meta", str5);
    paramabwu.putExtra("forward_ark_app_config", str4);
    paramabwu.putExtra("forward_ark_app_compat", paramJSONObject);
    paramabwu.putExtra("is_ark_display_share", true);
    paramabwu.putExtra("appName", str1);
    paramabwu.putExtra("appView", str3);
    paramabwu.putExtra("appMinVersion", str2);
    paramabwu.putExtra("metaData", str5);
    paramabwu.putExtra("scale", anob.a());
    if (!TextUtils.isEmpty(str7)) {
      paramabwu.putExtra("forward_ark_h5_from_js", str7);
    }
    a(paramabwu, (byte)0);
  }
  
  private void e(JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    boolean bool1 = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      acab.a(this.jdField_a_of_type_Abwu, -1, "no auth");
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
            paramJSONObject = this.jdField_a_of_type_Abzb.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof belm))) {
              break;
            }
            paramJSONObject = (belm)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.a(bool1);
            acab.a(paramabwu, abww.a);
          }
        }
        catch (Exception paramJSONObject)
        {
          acab.a(paramabwu, -2, "param error");
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
  
  private void f(JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    boolean bool1 = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      acab.a(this.jdField_a_of_type_Abwu, -1, "no auth");
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
            paramJSONObject = this.jdField_a_of_type_Abzb.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof belm))) {
              break;
            }
            paramJSONObject = (belm)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.b(bool1);
            acab.a(paramabwu, abww.a);
          }
        }
        catch (Exception paramJSONObject)
        {
          acab.a(paramabwu, -2, "param error");
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
  
  protected void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Abzb.a() instanceof ArkBrowserFragment)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramByte == 0) && (this.jdField_b_of_type_Abwu != null))
    {
      if (paramInt == -1) {
        acab.a(this.jdField_b_of_type_Abwu, abww.a);
      }
    }
    else {
      return;
    }
    acab.a(this.jdField_b_of_type_Abwu, -3, "user cancel");
  }
  
  protected void a(String paramString)
  {
    TextView localTextView1;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(BaseActivity.sTopActivity, 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558942);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365237);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365233);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365222);
      TextView localTextView4 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365228);
      localTextView1.setText(2131720808);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView2.setText(paramString);
      }
      localTextView4.setText(2131721454);
      localTextView4.setOnClickListener(new anps(this));
      localTextView3.setOnClickListener(new anpt(this));
      localTextView3.setText(2131690648);
    }
    do
    {
      return;
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365233);
    } while (TextUtils.isEmpty(paramString));
    localTextView1.setText(paramString);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 13: 
      a(paramJSONObject, paramabwu);
    }
    for (;;)
    {
      return true;
      c(paramJSONObject, paramabwu);
      continue;
      d(paramJSONObject, paramabwu);
      continue;
      b(paramJSONObject, paramabwu);
      continue;
      e(paramJSONObject, paramabwu);
      continue;
      f(paramJSONObject, paramabwu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpq
 * JD-Core Version:    0.7.0.1
 */