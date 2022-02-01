package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class LocaleManager
{
  public static boolean a = false;
  private static final SparseArray<Locale> b = new SparseArray();
  private static boolean c = false;
  private static int d = 0;
  
  static
  {
    b.put(2052, Locale.SIMPLIFIED_CHINESE);
    b.put(1033, Locale.US);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 2052) {
      return HardCodeUtil.a(2131891130);
    }
    if (paramInt == 1033) {
      return HardCodeUtil.a(2131891129);
    }
    return "";
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initializeAppLocale, sCurrentLocaleId:");
    ((StringBuilder)localObject).append(d);
    a(((StringBuilder)localObject).toString());
    if (d == 0)
    {
      localObject = PropertiesUtils.b(paramContext, "key_local_cache", "0");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initializeAppLocale, localeIdStr:");
      localStringBuilder.append((String)localObject);
      a(localStringBuilder.toString());
      if ("0".equals(localObject))
      {
        d = 2052;
        PropertiesUtils.a(paramContext, "key_local_cache", String.valueOf(d));
      }
      else
      {
        d = Integer.parseInt(((String)localObject).trim());
      }
      localObject = PropertiesUtils.b(paramContext, "key_local_last", "0");
      boolean bool3 = "0".equals(localObject);
      boolean bool2 = true;
      boolean bool1 = true;
      if (bool3)
      {
        if (d == 2052) {
          bool1 = false;
        }
        c = bool1;
      }
      else
      {
        if (Integer.parseInt((String)localObject) != d) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        c = bool1;
      }
      PropertiesUtils.a(paramContext, "key_local_last", String.valueOf(d));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initializeAppLocale, HwEngine.localeId:");
    ((StringBuilder)localObject).append(d);
    a(((StringBuilder)localObject).toString());
    com.tencent.mobileqq.highway.HwEngine.localeId = d;
    mqq.app.AppActivity.localeId = d;
    mqq.app.BaseActivity.localeId = d;
    b(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocale , localeId = ");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    PropertiesUtils.a(paramContext, "key_local_last", String.valueOf(d));
    PropertiesUtils.a(paramContext, "key_local_cache", String.valueOf(paramInt));
    d = paramInt;
    com.tencent.mobileqq.highway.HwEngine.localeId = d;
    mqq.app.AppActivity.localeId = d;
    mqq.app.BaseActivity.localeId = d;
    b(paramContext, d);
    a(paramContext, b(paramInt));
    if (b()) {
      MultiLanguageEngine.a().d(paramContext);
    }
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    if (paramContext != null)
    {
      if (paramLocale == null) {
        return;
      }
      mqq.app.AppActivity.locale = paramLocale;
      mqq.app.BaseActivity.locale = paramLocale;
      com.tencent.mobileqq.pluginsdk.PluginProxyActivity.locale = paramLocale;
      paramContext = paramContext.getResources();
      Configuration localConfiguration = paramContext.getConfiguration();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(paramContext.getDisplayMetrics());
      StringBuilder localStringBuilder;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("rconf locale set1:");
        localStringBuilder.append(paramLocale.toString());
        a(localStringBuilder.toString());
        paramLocale = new LocaleList(new Locale[] { paramLocale });
        LocaleList.setDefault(paramLocale);
        localConfiguration.setLocales(paramLocale);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("rconf locale set2:");
        localStringBuilder.append(paramLocale.toString());
        a(localStringBuilder.toString());
        Locale.setDefault(paramLocale);
        localConfiguration.locale = paramLocale;
      }
      paramContext.updateConfiguration(localConfiguration, paramContext.getDisplayMetrics());
      paramContext.getDisplayMetrics().setTo(localDisplayMetrics);
    }
  }
  
  public static void a(String paramString)
  {
    QLog.d("LocaleManager", 1, paramString);
  }
  
  public static boolean a()
  {
    return d == 2052;
  }
  
  public static boolean a(Locale paramLocale1, Locale paramLocale2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLocale1 != null)
    {
      if (paramLocale2 == null) {
        return false;
      }
      boolean bool3 = paramLocale1.getLanguage().equals(paramLocale2.getLanguage());
      boolean bool4 = paramLocale1.getCountry().equals(paramLocale2.getCountry());
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static Locale b(int paramInt)
  {
    return (Locale)b.get(paramInt);
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject1 = paramContext.getResources();
      if (localObject1 != null)
      {
        localObject1 = ((Resources)localObject1).getConfiguration();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("tryApplyLocaleIfNeeded, resLocale:");
        ((StringBuilder)localObject2).append(((Configuration)localObject1).locale.toString());
        a(((StringBuilder)localObject2).toString());
        localObject2 = e();
        if (!a((Locale)localObject2, ((Configuration)localObject1).locale))
        {
          a("tryApplyLocaleIfNeeded, called tryApplyLocale");
          a(paramContext, (Locale)localObject2);
        }
      }
    }
    else
    {
      a("called tryApplyLocaleIfNeeded, context null");
    }
  }
  
  private static void b(Context paramContext, int paramInt)
  {
    try
    {
      SettingCloneUtil.writeValueForInt(paramContext, null, null, "qqsetting_locale_id", paramInt);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMsfLocaleId, localeId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      a(((StringBuilder)localObject).toString());
      int i = 0;
      while ((i < 3) && (SettingCloneUtil.readValueForInt(paramContext, null, null, "qqsetting_locale_id", 0) != paramInt))
      {
        SettingCloneUtil.writeValueForInt(paramContext, null, null, "qqsetting_locale_id", paramInt);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateMsfLocaleId, write localeId:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", time:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        a(((StringBuilder)localObject).toString());
        Thread.sleep(10L);
        i += 1;
      }
      if (SettingCloneUtil.readValueForInt(paramContext, null, null, "qqsetting_locale_id", 0) != paramInt)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateMsfLocaleId, write failed, time:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        a(((StringBuilder)localObject).toString());
      }
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramContext = new NewIntent(paramContext, BuiltInServlet.class);
      paramContext.putExtra("action", 2212);
      paramContext.putExtra("localeId", paramInt);
      ((AppRuntime)localObject).startServlet(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("LocaleManager", 1, "updateMsfLocaleId error!", paramContext);
    }
  }
  
  public static boolean b()
  {
    return d == 1033;
  }
  
  public static void c(Context paramContext)
  {
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject1 != null) {
      paramContext = ((ActivityManager)localObject1).getRunningAppProcesses();
    } else {
      paramContext = null;
    }
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.iterator();
    Object localObject2;
    while (paramContext.hasNext())
    {
      localObject2 = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (!"com.tencent.mobileqq".equals(((ActivityManager.RunningAppProcessInfo)localObject2).processName))
      {
        Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("process killed on locale update, pid:");
        localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
        localStringBuilder.append(", name:");
        localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).processName);
        a(localStringBuilder.toString());
      }
    }
    paramContext = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject1).pid);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("process killed on locale update, pid:");
      ((StringBuilder)localObject2).append(((ActivityManager.RunningAppProcessInfo)localObject1).pid);
      ((StringBuilder)localObject2).append(", name:");
      ((StringBuilder)localObject2).append(((ActivityManager.RunningAppProcessInfo)localObject1).processName);
      a(((StringBuilder)localObject2).toString());
    }
  }
  
  public static boolean c()
  {
    return c;
  }
  
  public static int d()
  {
    return d;
  }
  
  public static Locale e()
  {
    Object localObject2 = b(d);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Locale.SIMPLIFIED_CHINESE;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("queryCurrentLocale, currentLocale:");
    ((StringBuilder)localObject2).append(((Locale)localObject1).toString());
    a(((StringBuilder)localObject2).toString());
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LocaleManager
 * JD-Core Version:    0.7.0.1
 */