package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import bbkb;
import bfwv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
    bbkb localbbkb = new bbkb();
    QQAppInterface localQQAppInterface = null;
    if ((getActivity() instanceof BaseActivity)) {
      localQQAppInterface = ((BaseActivity)getActivity()).app;
    }
    if (localQQAppInterface == null) {
      return;
    }
    int i = 268435456;
    for (;;)
    {
      try
      {
        k = Integer.parseInt(paramString4);
        if ((0x4000000 & k) != 67108864) {
          break label311;
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
        localbbkb.a(localQQAppInterface, getActivity(), paramString1, paramString2, paramString3, i);
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
        localbbkb.a(paramString4, getActivity(), "", localQQAppInterface, paramString1, paramString3, i, paramString6);
        return;
      }
      label311:
      j = 268435456;
    }
  }
  
  @HippyMethod(name="getAppsVerionCodeBatch")
  public void getAppsVerionCodeBatch(String paramString, Promise paramPromise)
  {
    paramPromise.resolve(bfwv.d(BaseApplicationImpl.getContext(), paramString));
  }
  
  @HippyMethod(name="isAppInstalled")
  public void isAppInstalled(String paramString, Promise paramPromise)
  {
    if (paramPromise != null) {
      paramPromise.resolve(Boolean.valueOf(bfwv.a(getActivity(), paramString)));
    }
  }
  
  @HippyMethod(name="isAppInstalledBatch")
  public void isAppInstalledBatch(String paramString, Promise paramPromise)
  {
    paramPromise.resolve(bfwv.c(BaseApplicationImpl.getContext(), paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQAppModule
 * JD-Core Version:    0.7.0.1
 */