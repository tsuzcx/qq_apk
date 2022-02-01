package com.tencent.featuretoggle.hltxkg.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.featuretoggle.hltxkg.common.a.e;

final class b
  implements Runnable
{
  public final void run()
  {
    try
    {
      a.b = a.j().getPackageManager().getPackageInfo(a.j().getPackageName(), 0).applicationInfo.loadLabel(a.j().getPackageManager()).toString();
      label36:
      e.a();
      com.tencent.featuretoggle.hltxkg.common.e.a.a(a.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b
 * JD-Core Version:    0.7.0.1
 */