package com.huawei.updatesdk.service.d.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

public final class a
{
  private static final String a = a.class.getSimpleName();
  private static String b = null;
  
  public static String a()
  {
    if (b != null) {
      return b;
    }
    label149:
    for (;;)
    {
      try
      {
        String str = com.huawei.updatesdk.a.b.a.a.a().b().getPackageName();
        localObject = com.huawei.updatesdk.a.b.a.a.a().b().getPackageManager().getPackageInfo(com.huawei.updatesdk.a.b.a.a.a().b().getPackageName(), 0);
        if (localObject == null) {
          break label149;
        }
        str = str + ((PackageInfo)localObject).versionName;
        localObject = Build.BRAND;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a(str + "_" + (String)localObject);
          str = b;
          return str;
        }
      }
      catch (Exception localException)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d(a, "getUserAgent() " + localException.toString());
        return null;
      }
      Object localObject = "other";
    }
  }
  
  private static void a(String paramString)
  {
    b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.d.a.a
 * JD-Core Version:    0.7.0.1
 */