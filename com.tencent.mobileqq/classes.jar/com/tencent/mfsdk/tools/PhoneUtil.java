package com.tencent.mfsdk.tools;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.util.QQDeviceInfo;

public class PhoneUtil
{
  private static int a = -1;
  private static String b = "";
  
  public static String a(Application paramApplication, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Object localObject2 = "";
    Context localContext = paramApplication.getApplicationContext();
    Object localObject1 = localObject2;
    if (a(paramApplication))
    {
      localObject1 = (TelephonyManager)localContext.getSystemService("phone");
      String str = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject1);
      paramApplication = (Application)localObject2;
      if (!TextUtils.isEmpty(str))
      {
        paramApplication = new StringBuilder();
        paramApplication.append("");
        paramApplication.append(str);
        paramApplication = paramApplication.toString();
      }
      localObject2 = PhoneInfoMonitor.getSubscriberId((TelephonyManager)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramApplication);
        ((StringBuilder)localObject1).append((String)localObject2);
      }
      for (paramApplication = ((StringBuilder)localObject1).toString();; paramApplication = ((StringBuilder)localObject2).toString())
      {
        localObject2 = paramApplication;
        break;
        localObject1 = ((TelephonyManager)localObject1).getSimOperator();
        localObject2 = paramApplication;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramApplication);
        ((StringBuilder)localObject2).append((String)localObject1);
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 23) {
          localObject1 = QQDeviceInfo.getSerial(paramActivity);
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramApplication = (Application)localObject1;
      if (!((String)localObject1).startsWith("012345678912345")) {}
    }
    else
    {
      paramApplication = Settings.Secure.getString(localContext.getContentResolver(), "android_id");
    }
    b = MD5.toMD5(paramApplication);
    return b;
  }
  
  private static boolean a(Application paramApplication)
  {
    int i = a;
    if (i == -1)
    {
      boolean bool = a(paramApplication, "android.permission.READ_PHONE_STATE");
      if (bool)
      {
        a = 1;
        return bool;
      }
      a = 0;
      return bool;
    }
    return i > 0;
  }
  
  private static boolean a(Application paramApplication, String paramString)
  {
    boolean bool = false;
    if (paramApplication == null) {
      return false;
    }
    PackageManager localPackageManager = paramApplication.getPackageManager();
    if (localPackageManager == null) {
      return false;
    }
    if (localPackageManager.checkPermission(paramString, paramApplication.getPackageName()) == 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.tools.PhoneUtil
 * JD-Core Version:    0.7.0.1
 */