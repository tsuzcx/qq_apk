package com.tencent.featuretoggle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.featuretoggle.utils.AppUtils;
import com.tencent.featuretoggle.utils.Utils;
import java.util.HashMap;
import java.util.Map;

public final class ToggleSetting
{
  @SuppressLint({"StaticFieldLeak"})
  private static Context a;
  private static ToggleConfig b;
  private static String c = "Toggle";
  private static long d = 120000L;
  private static String e = "";
  private static volatile int f = -1;
  private static boolean g = true;
  private static boolean h = true;
  private static boolean i = true;
  private static boolean j = true;
  private static long k = 0L;
  private static boolean l = false;
  private static volatile long m = SystemClock.elapsedRealtime() - 30000L;
  private static volatile long n = SystemClock.elapsedRealtime() - 30000L;
  
  public static int A()
  {
    return f;
  }
  
  public static boolean B()
  {
    return h;
  }
  
  public static boolean C()
  {
    return i;
  }
  
  public static boolean D()
  {
    return j;
  }
  
  public static ToggleConfig a()
  {
    return b;
  }
  
  public static void a(int paramInt)
  {
    f = paramInt;
  }
  
  public static void a(long paramLong)
  {
    m = paramLong;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext;
  }
  
  public static void a(Context paramContext, ToggleConfig paramToggleConfig)
  {
    a(paramContext);
    a(paramToggleConfig);
    if (AppUtils.f(paramContext))
    {
      a(true);
      paramToggleConfig.b(true);
    }
    if (Utils.a(paramToggleConfig.d()))
    {
      String str = AppUtils.a(paramContext, "TOGGLE_CHANNEL");
      if (str != null) {
        paramToggleConfig.a(str);
      } else {
        paramToggleConfig.a("Defalut");
      }
    }
    if (Utils.a(paramToggleConfig.e())) {
      paramToggleConfig.b(AppUtils.b(paramContext));
    }
    if ((!paramToggleConfig.f()) && (AppUtils.a(paramContext, "TOGGLE_IS_DEBUG", false))) {
      paramToggleConfig.a(true);
    }
    b(paramToggleConfig.m());
  }
  
  public static void a(ToggleConfig paramToggleConfig)
  {
    b = paramToggleConfig;
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Toggle");
    localStringBuilder.append(paramString);
    c = localStringBuilder.toString();
  }
  
  public static void a(boolean paramBoolean)
  {
    l = paramBoolean;
  }
  
  public static int b()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return (int)(Runtime.getRuntime().totalMemory() / 1024L / 8L);
    }
    return localToggleConfig.o();
  }
  
  static void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if ((paramInt & 0x2) != 2) {
      c(false);
    }
    if ((paramInt & 0x4) != 4) {
      b(false);
    }
    if ((paramInt & 0x8) != 8) {
      d(false);
    }
  }
  
  public static void b(long paramLong)
  {
    n = paramLong;
  }
  
  public static void b(String paramString)
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig != null) {
      localToggleConfig.c(paramString);
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  public static String c()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.n();
  }
  
  public static void c(long paramLong)
  {
    k = paramLong;
  }
  
  public static void c(String paramString)
  {
    e = paramString;
  }
  
  public static void c(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static long d()
  {
    return m;
  }
  
  public static void d(long paramLong)
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig != null) {
      localToggleConfig.a(paramLong);
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static long e()
  {
    return n;
  }
  
  public static void e(long paramLong)
  {
    d = paramLong;
  }
  
  public static boolean f()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return true;
    }
    return localToggleConfig.h();
  }
  
  public static boolean g()
  {
    return l;
  }
  
  public static Map<String, String> h()
  {
    ToggleConfig localToggleConfig = b;
    if ((localToggleConfig != null) && (localToggleConfig.l() != null)) {
      return b.l();
    }
    return new HashMap();
  }
  
  public static long i()
  {
    return k;
  }
  
  public static Context j()
  {
    return a;
  }
  
  public static String k()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.a();
  }
  
  public static String l()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.b();
  }
  
  public static String m()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.c();
  }
  
  public static String n()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "Default";
    }
    return localToggleConfig.d();
  }
  
  public static String o()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.e();
  }
  
  public static boolean p()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return false;
    }
    return localToggleConfig.f();
  }
  
  public static boolean q()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return false;
    }
    return localToggleConfig.g();
  }
  
  public static String r()
  {
    return "1.0.7.3";
  }
  
  public static String s()
  {
    return c;
  }
  
  public static String t()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return "";
    }
    return localToggleConfig.i();
  }
  
  public static String u()
  {
    return "Android";
  }
  
  public static long v()
  {
    return 30000L;
  }
  
  public static long w()
  {
    ToggleConfig localToggleConfig = b;
    if (localToggleConfig == null) {
      return 120000L;
    }
    return localToggleConfig.j();
  }
  
  public static long x()
  {
    return d;
  }
  
  public static String y()
  {
    return e;
  }
  
  public static String z()
  {
    return b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleSetting
 * JD-Core Version:    0.7.0.1
 */