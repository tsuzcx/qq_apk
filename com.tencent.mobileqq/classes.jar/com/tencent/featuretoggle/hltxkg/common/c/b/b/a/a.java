package com.tencent.featuretoggle.hltxkg.common.c.b.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class a
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e;
  
  public a()
  {
    try
    {
      this.a = com.tencent.featuretoggle.hltxkg.common.a.a().getPackageName();
      PackageInfo localPackageInfo = com.tencent.featuretoggle.hltxkg.common.a.a().getPackageManager().getPackageInfo(this.a, 0);
      this.b = localPackageInfo.versionCode;
      this.c = localPackageInfo.versionName;
      this.e = com.tencent.featuretoggle.hltxkg.common.a.c();
      this.d = "";
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */