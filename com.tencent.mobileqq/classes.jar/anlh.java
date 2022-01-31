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

public class anlh
  extends abul
{
  private absf jdField_a_of_type_Absf;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private anll jdField_a_of_type_Anll = new anll(null);
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private absf jdField_b_of_type_Absf;
  private String jdField_b_of_type_JavaLangString;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  private beeh a(int paramInt)
  {
    if (this.jdField_a_of_type_Abum != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_Abum.a();
      if (localWebViewFragment != null) {
        return (beeh)localWebViewFragment.b().a(paramInt);
      }
      if ((this.jdField_a_of_type_Abum.a() instanceof bedl)) {
        return (beeh)((bedl)this.jdField_a_of_type_Abum.a()).b().a(paramInt);
      }
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_Abum != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_Abum.a();
      if (localWebViewFragment != null) {
        return localWebViewFragment.b();
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, byte paramByte)
  {
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_Abum.a();
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
    ayup localayup = new ayup();
    AppInterface localAppInterface = this.jdField_a_of_type_Abum.a();
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
      localayup.a(localAppInterface, localActivity, paramString1, paramString2, paramString3, i);
      return;
      QLog.e("ArkWebModule", 1, "launchAppWithTokens fail for context is null");
    }
    azmj.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
    localActivity = this.jdField_a_of_type_Abum.a();
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
      if (this.jdField_a_of_type_Abum.a() != null)
      {
        paramString2 = this.jdField_a_of_type_Abum.a().getUrl();
        localayup.a(str, localActivity, paramString2, localAppInterface, paramString1, paramString3, i, paramString6);
        return;
      }
    }
    label402:
  }
  
  private void a(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      abvm.a(this.jdField_a_of_type_Absf, -1, "no auth");
      return;
    }
    String str = String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("version", str);
      abvm.a(paramabsf, paramJSONObject);
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
  
  private void b(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      abvm.a(this.jdField_a_of_type_Absf, -1, "no auth");
      return;
    }
    this.jdField_a_of_type_Absf = paramabsf;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      abvm.a(this.jdField_a_of_type_Absf, -5, "other");
      return;
    }
    try
    {
      this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString = paramJSONObject.optString("appID");
      this.jdField_a_of_type_Anll.jdField_b_of_type_JavaLangString = paramJSONObject.optString("paramsStr");
      this.jdField_a_of_type_Anll.c = paramJSONObject.optString("packageName");
      this.jdField_a_of_type_Anll.d = paramJSONObject.optString("flags");
      this.jdField_a_of_type_Anll.g = paramJSONObject.optString("url");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString))
      {
        QLog.e("ArkWebModule", 1, "mOpenAppinfo.appId is null");
        abvm.a(this.jdField_a_of_type_Absf, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("ArkWebModule", 1, String.format("get mOpenAppinfo json error, err=%s", new Object[] { paramJSONObject.getMessage() }));
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString))
      {
        paramJSONObject = (Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString);
        if (paramJSONObject != null)
        {
          if (paramJSONObject.intValue() == 1)
          {
            paramJSONObject = this.jdField_a_of_type_Abum.a();
            if (!bdem.a(paramJSONObject, this.jdField_a_of_type_Anll.c))
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Anll.g))
              {
                paramabsf = new Intent(paramJSONObject, QQBrowserActivity.class);
                paramabsf.putExtra("url", this.jdField_a_of_type_Anll.g);
                paramabsf.putExtra("fromArkAppDownload", true);
                paramJSONObject.startActivity(paramabsf);
              }
              abvm.a(this.jdField_a_of_type_Absf, -4, "need to download");
              return;
            }
            a(this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anll.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anll.c, this.jdField_a_of_type_Anll.d, this.jdField_a_of_type_Anll.e, this.jdField_a_of_type_Anll.f);
            abvm.a(this.jdField_a_of_type_Absf, absh.a);
            return;
          }
          if (paramJSONObject.intValue() == 0)
          {
            d();
            abvm.a(this.jdField_a_of_type_Absf, -3, "user canceled");
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
      paramabsf = (String)paramJSONObject.next();
    } while ((TextUtils.isEmpty(this.c)) || (!paramabsf.equals(this.c)));
    label802:
    for (paramJSONObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramabsf);; paramJSONObject = "ask")
    {
      if (paramJSONObject.equals("allow"))
      {
        paramJSONObject = this.jdField_a_of_type_Abum.a();
        if (!bdem.a(paramJSONObject, this.jdField_a_of_type_Anll.c))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Anll.g))
          {
            paramabsf = new Intent(paramJSONObject, QQBrowserActivity.class);
            paramabsf.putExtra("url", this.jdField_a_of_type_Anll.g);
            paramabsf.putExtra("fromArkAppDownload", true);
            paramJSONObject.startActivity(paramabsf);
          }
          abvm.a(this.jdField_a_of_type_Absf, -4, "need to download");
          return;
        }
        a(this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anll.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anll.c, this.jdField_a_of_type_Anll.d, this.jdField_a_of_type_Anll.e, this.jdField_a_of_type_Anll.f);
        abvm.a(this.jdField_a_of_type_Absf, absh.a);
        return;
      }
      if (paramJSONObject.equals("ask"))
      {
        paramJSONObject = this.jdField_a_of_type_Abum.a();
        if ((paramJSONObject == null) || (paramJSONObject.isFinishing())) {
          break;
        }
        paramabsf = this.jdField_a_of_type_Abum.a();
        if (paramabsf == null) {
          break;
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_Anll.jdField_a_of_type_JavaLangString);
          zbj.a(paramabsf, this.jdField_a_of_type_Abum.a(), paramabsf.getAccount(), l, 2000L, new anli(this, paramJSONObject));
          return;
        }
        catch (NumberFormatException paramabsf)
        {
          QLog.e("ArkWebModule", 1, String.format("mOpenAppinfo appid to Long error, err=%s", new Object[] { paramabsf.getMessage() }));
          paramabsf = paramJSONObject.getString(2131690285);
          a(String.format(paramJSONObject.getString(2131690286), new Object[] { paramabsf }));
          this.jdField_a_of_type_AndroidAppDialog.show();
          return;
        }
      }
      if (!paramJSONObject.equals("forbidden")) {
        break;
      }
      d();
      abvm.a(this.jdField_a_of_type_Absf, -3, "user canceled");
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
        Object localObject = this.jdField_a_of_type_Abum.a();
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
  
  private void c(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      abvm.a(this.jdField_a_of_type_Absf, -1, "no auth");
      return;
    }
    Object localObject = this.jdField_a_of_type_Abum.a();
    if (localObject == null)
    {
      abvm.a(paramabsf, -3, "other");
      return;
    }
    beei localbeei = (beei)((WebViewFragment)localObject).a.a(4);
    if (localbeei == null)
    {
      abvm.a(paramabsf, -3, "other");
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
        abvm.a(this.jdField_b_of_type_Absf, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      abvm.a(paramabsf, -3, "other");
      return;
    }
    c();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "0.0.0.1";
    }
    localObject = bdfk.a(str1, str2, paramJSONObject, str4, anjs.a(), null, null);
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
    paramJSONObject.setClass(localbeei.a, ForwardRecentActivity.class);
    paramJSONObject.putExtra("forward_type", 27);
    paramJSONObject.putExtra("is_ark_display_share", true);
    paramJSONObject.putExtras((Bundle)localObject);
    if (paramJSONObject != null) {
      arum.a(localbeei.a, paramJSONObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkWebModule", 2, "buildForwardIntent: " + localObject);
    }
    bfdq.a().a("", "", "", "1000", "101", "0", false);
    azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
    abvm.a(paramabsf, absh.a);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Abum == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.jdField_a_of_type_Abum.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    QQToast.a(localActivity, alpo.a(2131701095), 0).a();
  }
  
  private void d(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      abvm.a(this.jdField_a_of_type_Absf, -1, "no auth");
      return;
    }
    this.jdField_b_of_type_Absf = paramabsf;
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
        localObject = this.jdField_a_of_type_Abum.a();
        paramabsf = new Intent();
        str1 = paramJSONObject.optString("appName");
        str2 = paramJSONObject.optString("toUin");
        int i = paramJSONObject.optInt("uinType", 0);
        str3 = paramJSONObject.optString("toNickName");
        if ((str2 != null) && (str2.length() >= 5))
        {
          paramabsf.setClass((Context)localObject, DirectForwardActivity.class);
          paramabsf.putExtra("toUin", str2);
          paramabsf.putExtra("uinType", i);
          paramabsf.putExtra("nickName", str3);
          paramabsf.putExtra("shareQQType", paramJSONObject.optInt("shareQQType", 13));
          paramabsf.putExtra("forward_type", 27);
          paramabsf.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramabsf.putExtra("k_back", paramJSONObject.optBoolean("k_back", paramJSONObject.optBoolean("back", false)));
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
          abvm.a(this.jdField_b_of_type_Absf, -2, "param error");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        abvm.a(this.jdField_b_of_type_Absf, -4, "other");
        QLog.e("ArkWebModule", 1, "shareArkMsg error: " + paramJSONObject.toString());
        return;
      }
      paramabsf.putExtra("isWebCompShare", true);
      paramabsf.setClass((Context)localObject, ForwardRecentActivity.class);
    }
    String str7 = a();
    paramabsf.putExtra("forward_ark_app_name", str1);
    paramabsf.putExtra("forward_ark_app_view", str3);
    paramabsf.putExtra("forward_ark_app_desc", (String)localObject);
    paramabsf.putExtra("forward_ark_app_ver", str2);
    paramabsf.putExtra("forward_ark_app_prompt", str6);
    paramabsf.putExtra("forward_ark_app_meta", str5);
    paramabsf.putExtra("forward_ark_app_config", str4);
    paramabsf.putExtra("forward_ark_app_compat", paramJSONObject);
    paramabsf.putExtra("is_ark_display_share", true);
    paramabsf.putExtra("appName", str1);
    paramabsf.putExtra("appView", str3);
    paramabsf.putExtra("appMinVersion", str2);
    paramabsf.putExtra("metaData", str5);
    paramabsf.putExtra("scale", anjs.a());
    if (!TextUtils.isEmpty(str7)) {
      paramabsf.putExtra("forward_ark_h5_from_js", str7);
    }
    a(paramabsf, (byte)0);
  }
  
  private void e(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    boolean bool1 = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      abvm.a(this.jdField_a_of_type_Absf, -1, "no auth");
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
            paramJSONObject = this.jdField_a_of_type_Abum.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof behd))) {
              break;
            }
            paramJSONObject = (behd)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.a(bool1);
            abvm.a(paramabsf, absh.a);
          }
        }
        catch (Exception paramJSONObject)
        {
          abvm.a(paramabsf, -2, "param error");
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
  
  private void f(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    boolean bool1 = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      abvm.a(this.jdField_a_of_type_Absf, -1, "no auth");
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
            paramJSONObject = this.jdField_a_of_type_Abum.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof behd))) {
              break;
            }
            paramJSONObject = (behd)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.b(bool1);
            abvm.a(paramabsf, absh.a);
          }
        }
        catch (Exception paramJSONObject)
        {
          abvm.a(paramabsf, -2, "param error");
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
    if ((this.jdField_a_of_type_Abum.a() instanceof ArkBrowserFragment)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramByte == 0) && (this.jdField_b_of_type_Absf != null))
    {
      if (paramInt == -1) {
        abvm.a(this.jdField_b_of_type_Absf, absh.a);
      }
    }
    else {
      return;
    }
    abvm.a(this.jdField_b_of_type_Absf, -3, "user cancel");
  }
  
  protected void a(String paramString)
  {
    TextView localTextView1;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(BaseActivity.sTopActivity, 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558943);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365235);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365231);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365220);
      TextView localTextView4 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365226);
      localTextView1.setText(2131720796);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView2.setText(paramString);
      }
      localTextView4.setText(2131721441);
      localTextView4.setOnClickListener(new anlj(this));
      localTextView3.setOnClickListener(new anlk(this));
      localTextView3.setText(2131690648);
    }
    do
    {
      return;
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365231);
    } while (TextUtils.isEmpty(paramString));
    localTextView1.setText(paramString);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 13: 
      a(paramJSONObject, paramabsf);
    }
    for (;;)
    {
      return true;
      c(paramJSONObject, paramabsf);
      continue;
      d(paramJSONObject, paramabsf);
      continue;
      b(paramJSONObject, paramabsf);
      continue;
      e(paramJSONObject, paramabsf);
      continue;
      f(paramJSONObject, paramabsf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlh
 * JD-Core Version:    0.7.0.1
 */