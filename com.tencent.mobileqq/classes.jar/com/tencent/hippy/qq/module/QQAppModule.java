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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchAppWithTokens ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("QQAppModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AppLaucherHelper();
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface == null) {
      return;
    }
    int j = 268435456;
    int k = 1;
    int i;
    try
    {
      int m = Integer.parseInt(paramString4);
      if ((m & 0x4000000) == 67108864) {
        j = 335544320;
      }
      i = j;
      if ((m & 0x20000000) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((m & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
      i = j;
    }
    catch (Exception paramString4)
    {
      QLog.e("QQAppModule", 1, paramString4, new Object[0]);
      i = 268435456;
    }
    paramString4 = new StringBuilder();
    paramString4.append("tencentwtlogin");
    paramString4.append(paramString1);
    paramString4.append("://");
    paramString4 = paramString4.toString();
    if ("wtlogin".equals(paramString5))
    {
      paramString5 = getActivity().getPackageManager();
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString4));
      if ((paramString5 != null) && (paramString5.queryIntentActivities(localIntent, 0).size() > 0))
      {
        j = k;
        break label271;
      }
    }
    j = 0;
    label271:
    if (j != 0)
    {
      ((AppLaucherHelper)localObject).a(paramString4, getActivity(), "", localAppInterface, paramString1, paramString3, i, paramString6);
      return;
    }
    ((AppLaucherHelper)localObject).a(localAppInterface, getActivity(), paramString1, paramString2, paramString3, i);
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
      label50:
      break label50;
    }
    QLog.e("QQAppModule", 1, "launchAppWithTokens, parse params error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQAppModule
 * JD-Core Version:    0.7.0.1
 */