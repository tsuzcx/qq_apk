package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class bh
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e;
  
  public bh()
  {
    try
    {
      this.a = l.a().getPackageName();
      PackageInfo localPackageInfo = l.a().getPackageManager().getPackageInfo(this.a, 0);
      this.b = localPackageInfo.versionCode;
      this.c = localPackageInfo.versionName;
      this.e = l.c();
      this.d = "";
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bh
 * JD-Core Version:    0.7.0.1
 */