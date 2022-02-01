package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQAppModule")
public class QQAppModule
  extends QQBaseModule
{
  static final String TAG = "QQAppModule";
  
  public QQAppModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void launchAppWithTokens(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppModule", 2, "launchAppWithTokens " + paramString3);
    }
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface == null) {
      return;
    }
    int i = 268435456;
    for (;;)
    {
      try
      {
        k = Integer.parseInt(paramString4);
        if ((0x4000000 & k) != 67108864) {
          break label292;
        }
        j = 335544320;
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
        int k;
        Intent localIntent;
        QLog.e("QQAppModule", 1, paramString4, new Object[0]);
        continue;
        localAppLaucherHelper.a(localAppInterface, getActivity(), paramString1, paramString2, paramString3, i);
        return;
      }
      k = 0;
      paramString4 = "tencentwtlogin" + paramString1 + "://";
      int j = k;
      if ("wtlogin".equals(paramString5))
      {
        paramString5 = getActivity().getPackageManager();
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramString4));
        j = k;
        if (paramString5 != null)
        {
          j = k;
          if (paramString5.queryIntentActivities(localIntent, 0).size() > 0) {
            j = 1;
          }
        }
      }
      if (j != 0)
      {
        localAppLaucherHelper.a(paramString4, getActivity(), "", localAppInterface, paramString1, paramString3, i, paramString6);
        return;
      }
      label292:
      j = 268435456;
    }
  }
  
  @HippyMethod(name="getAppsVerionCodeBatch")
  public void getAppsVerionCodeBatch(String paramString, Promise paramPromise)
  {
    paramPromise.resolve(PackageUtil.d(BaseApplicationImpl.getContext(), paramString));
  }
  
  @HippyMethod(name="isAppInstalled")
  public void isAppInstalled(String paramString, Promise paramPromise)
  {
    if (paramPromise != null) {
      paramPromise.resolve(Boolean.valueOf(PackageUtil.a(getActivity(), paramString)));
    }
  }
  
  @HippyMethod(name="isAppInstalledBatch")
  public void isAppInstalledBatch(String paramString, Promise paramPromise)
  {
    paramPromise.resolve(PackageUtil.c(BaseApplicationImpl.getContext(), paramString));
  }
  
  @HippyMethod(name="launchAppWithTokens")
  public void launchAppWithTokens(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      launchAppWithTokens(paramString.optString("appID"), paramString.optString("paramsStr"), paramString.optString("packageName"), paramString.optString("flags"), paramString.optString("type"), paramString.optString("subappid"));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QQAppModule", 1, "launchAppWithTokens, parse params error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQAppModule
 * JD-Core Version:    0.7.0.1
 */