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
  private static final String a = "c";
  private PLSharedPreferences b = null;
  
  public c(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    Logger.d(a, "get pkgname from context is{%s}", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    this.b = new PLSharedPreferences(paramContext, localStringBuilder.toString());
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
        c();
        b("version", paramContext);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label71:
      break label71;
    }
    Logger.w(a, "get app version failed and catch NameNotFoundException");
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.b.getString(paramString1, paramString2);
  }
  
  public Map<String, ?> a()
  {
    return this.b.getAll();
  }
  
  public void a(String paramString)
  {
    this.b.remove(paramString);
  }
  
  public String b()
  {
    return a("cp", "");
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.b.putString(paramString1, paramString2);
  }
  
  public void c()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.c
 * JD-Core Version:    0.7.0.1
 */