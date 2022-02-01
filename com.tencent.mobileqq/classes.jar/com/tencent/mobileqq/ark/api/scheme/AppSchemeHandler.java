package com.tencent.mobileqq.ark.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.module.SchemeHandler;
import com.tencent.mobileqq.ark.util.StringUtil;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class AppSchemeHandler
  implements SchemeHandler
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    int j = 268435456;
    try
    {
      int k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) == 67108864) {
        j = 335544320;
      }
      int i = j;
      if ((k & 0x20000000) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((k & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
    }
    catch (Exception paramString4)
    {
      label79:
      break label79;
    }
    j = 268435456;
    localAppLaucherHelper.a(a(), paramContext, paramString1, paramString2, paramString3, j);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
      return paramContext != null;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$");
    ((StringBuilder)localObject1).append("&big_brother_source_key=");
    ((StringBuilder)localObject1).append(paramString3);
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = localObject3;
    try
    {
      Object localObject4 = StringUtil.a(new JSONObject(paramString2));
      localObject1 = localObject3;
      Object localObject5 = ((Map)localObject4).get("url");
      paramString2 = (String)localObject2;
      if (localObject5 != null)
      {
        paramString2 = (String)localObject2;
        localObject1 = localObject3;
        if ((localObject5 instanceof String))
        {
          localObject1 = localObject3;
          paramString2 = (String)localObject5;
        }
      }
      localObject1 = paramString2;
      localObject4 = ((Map)localObject4).get("data");
      localObject2 = paramString2;
      localObject3 = str;
      if (localObject4 == null) {
        break label408;
      }
      localObject2 = paramString2;
      localObject3 = str;
      localObject1 = paramString2;
      if (!(localObject4 instanceof Map)) {
        break label408;
      }
      localObject1 = paramString2;
      localObject3 = (Map)localObject4;
      localObject1 = paramString2;
      localObject2 = new StringBuilder();
      localObject1 = paramString2;
      localObject3 = ((Map)localObject3).entrySet().iterator();
      for (;;)
      {
        localObject1 = paramString2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = paramString2;
        localObject5 = (Map.Entry)((Iterator)localObject3).next();
        localObject1 = paramString2;
        localObject4 = ((Map.Entry)localObject5).getKey();
        localObject1 = paramString2;
        localObject5 = ((Map.Entry)localObject5).getValue();
        if (localObject4 != null)
        {
          localObject1 = paramString2;
          if (((localObject4 instanceof String)) && (localObject5 != null))
          {
            localObject1 = paramString2;
            ((StringBuilder)localObject2).append("&");
            localObject1 = paramString2;
            ((StringBuilder)localObject2).append(localObject4);
            localObject1 = paramString2;
            ((StringBuilder)localObject2).append("=");
            localObject1 = paramString2;
            ((StringBuilder)localObject2).append(localObject5.toString());
          }
        }
      }
      localObject1 = paramString2;
      localObject3 = new StringBuilder();
      localObject1 = paramString2;
      ((StringBuilder)localObject3).append(str);
      localObject1 = paramString2;
      ((StringBuilder)localObject3).append(localObject2);
      localObject1 = paramString2;
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = paramString2;
    }
    catch (JSONException paramString2)
    {
      label378:
      break label378;
    }
    localObject2 = localObject1;
    localObject3 = str;
    if (QLog.isColorLevel())
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.jsonParseError");
      localObject3 = str;
      localObject2 = localObject1;
    }
    label408:
    if (!a(localBaseActivity, paramString4))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString1 = new Intent(localBaseActivity, QQBrowserActivity.class);
        paramString1.putExtra("url", (String)localObject2);
        ArkAppCenter.a(paramString1, paramString3);
        paramString1.putExtra("fromArkAppDownload", true);
        localBaseActivity.startActivity(paramString1);
        return true;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler, download url is empty");
        return true;
      }
    }
    else
    {
      a(localBaseActivity, paramString1, (String)localObject3, paramString4, "0");
    }
    return true;
  }
  
  protected QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString3 = "biz_src_jc_ark";
    if (paramJSONObject == null) {
      paramJSONObject = paramString3;
    } else {
      paramJSONObject = paramJSONObject.optString("businessId", "biz_src_jc_ark");
    }
    paramString3 = BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).getString(paramString1, null);
    if ((paramString3 != null) && (paramString3.length() > 0) && (a(localBaseActivity, paramString3)))
    {
      a(paramString1, paramString2, paramJSONObject, paramString3);
      return true;
    }
    paramString3 = a();
    if (paramString3 == null)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate app is null.");
      return false;
    }
    paramString3 = ((IArkService)paramString3.getRuntimeService(IArkService.class, "all")).getSSO();
    if (paramString3 == null)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate sso is null.");
      return false;
    }
    paramString3.a(paramString1, this, new AppSchemeHandler.1(this, paramString2, paramJSONObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.AppSchemeHandler
 * JD-Core Version:    0.7.0.1
 */