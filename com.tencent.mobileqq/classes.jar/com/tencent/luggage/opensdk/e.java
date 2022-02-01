package com.tencent.luggage.opensdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public class e
{
  private static Long a;
  
  public static boolean a()
  {
    boolean bool2 = c.g;
    boolean bool3 = d.b();
    boolean bool1;
    if ((bool3) && (d.a())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool4 = b();
    if ((bool2) && (bool3) && (bool1) && (bool4)) {
      return true;
    }
    o.b("Luggage.OpenSDKApiUtil", "canInvokeByOpenSdk returns false, buildConfigOpen:%b, wxApiInitialized:%b, wxInstalled:%b, wxSupported:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool4) });
    return false;
  }
  
  private static boolean b()
  {
    long l = c();
    boolean bool;
    if (l > 1341L) {
      bool = true;
    } else {
      bool = false;
    }
    o.e("Luggage.OpenSDKApiUtil", "curWechatVersionCode:%d, canRunOpensdkJsApi:%b", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
    return bool;
  }
  
  private static long c()
  {
    if (a == null) {
      try
      {
        PackageInfo localPackageInfo = r.a().getPackageManager().getPackageInfo("com.tencent.mm", 64);
        if (Build.VERSION.SDK_INT >= 28) {
          a = Long.valueOf(localPackageInfo.getLongVersionCode());
        } else {
          a = Long.valueOf(localPackageInfo.versionCode);
        }
      }
      catch (Exception localException)
      {
        o.b("Luggage.OpenSDKApiUtil", "getWechatVersionCode exception = %s", new Object[] { localException });
      }
    }
    Long localLong = a;
    if (localLong != null) {
      return localLong.longValue();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.e
 * JD-Core Version:    0.7.0.1
 */