package com.huawei.hms.framework.network.grs.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

public class a
{
  public static String a()
  {
    return "4.0.20.301";
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.w("AgentUtil", "", paramContext);
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      paramContext = Locale.ROOT;
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("/%s");
      return String.format(paramContext, paramString2.toString(), new Object[] { a() });
    }
    String str1 = paramContext.getPackageName();
    String str2 = a(paramContext);
    String str3 = Build.VERSION.RELEASE;
    String str4 = Build.MODEL;
    Locale localLocale = Locale.ROOT;
    paramContext = new StringBuilder();
    paramContext.append("%s/%s (Linux; Android %s; %s) ");
    paramContext.append(paramString1);
    paramContext.append("/%s %s");
    paramString1 = paramContext.toString();
    String str5 = a();
    paramContext = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramContext = "no_service_name";
    }
    return String.format(localLocale, paramString1, new Object[] { str1, str2, str3, str4, str5, paramContext });
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d.a
 * JD-Core Version:    0.7.0.1
 */