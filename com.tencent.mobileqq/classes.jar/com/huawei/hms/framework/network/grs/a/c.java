package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.Map;

public class c
{
  private static final String a = c.class.getSimpleName();
  private PLSharedPreferences b = null;
  
  public c() {}
  
  public c(Context paramContext)
  {
    String str = paramContext.getPackageName();
    Logger.d(a, "get pkgname from context is{%s}", new Object[] { str });
    this.b = new PLSharedPreferences(paramContext, "share_pre_grs_conf_" + str);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = Long.toString(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384).versionCode);
      String str = a("version", "");
      if (!paramContext.equals(str))
      {
        Logger.i(a, "app version changed! old version{%s} and new version{%s}", new Object[] { str, paramContext });
        b();
        b("version", paramContext);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.w(a, "get app version failed and catch NameNotFoundException");
    }
  }
  
  public String a()
  {
    return a("cp", "");
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.b.getString(paramString1, paramString2);
  }
  
  public void a(String paramString)
  {
    this.b.remove(paramString);
  }
  
  public void b()
  {
    this.b.clear();
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.b.putString(paramString1, paramString2);
  }
  
  public Map<String, ?> c()
  {
    return this.b.getAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.c
 * JD-Core Version:    0.7.0.1
 */