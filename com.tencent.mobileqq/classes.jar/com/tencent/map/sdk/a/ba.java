package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

final class ba
  implements Runnable
{
  public final void run()
  {
    try
    {
      PackageInfo localPackageInfo = ac.i().getPackageManager().getPackageInfo(ac.i().getPackageName(), 0);
      ac.a = localPackageInfo.versionName;
      int i = localPackageInfo.versionCode;
      ac.b = localPackageInfo.applicationInfo.loadLabel(ac.i().getPackageManager()).toString();
      label50:
      ao.a();
      de.a(ac.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ba
 * JD-Core Version:    0.7.0.1
 */