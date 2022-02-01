package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.z;
import java.util.List;

public final class c
{
  public static int a = 0;
  public static boolean b = false;
  public static int c = 2;
  public static boolean d = true;
  public static int e = 20480;
  public static int f = 20480;
  public static long g = 604800000L;
  public static String h;
  public static boolean i = false;
  public static String j;
  public static int k = 5000;
  public static boolean l = true;
  public static boolean m = false;
  public static String n;
  public static String o;
  private static c r;
  public final b p;
  private final Context q;
  private final e s;
  private final NativeCrashHandler t;
  private com.tencent.bugly.crashreport.common.strategy.a u;
  private w v;
  private final com.tencent.bugly.crashreport.crash.anr.b w;
  private int x = 31;
  private boolean y = false;
  
  private c(int paramInt, Context paramContext, w paramw, boolean paramBoolean, com.tencent.bugly.proguard.a parama, f paramf, String paramString)
  {
    a = paramInt;
    paramContext = z.a(paramContext);
    this.q = paramContext;
    this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.v = paramw;
    this.p = new b(paramInt, paramContext, u.a(), p.a(), this.u, parama, paramf);
    parama = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.s = new e(paramContext, this.p, this.u, parama);
    this.t = NativeCrashHandler.getInstance(paramContext, parama, this.p, this.u, paramw, paramBoolean, paramString);
    parama.F = this.t;
    this.w = new com.tencent.bugly.crashreport.crash.anr.b(paramContext, this.u, parama, paramw, this.p);
  }
  
  public static c a()
  {
    try
    {
      c localc = r;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static c a(int paramInt, Context paramContext, boolean paramBoolean, com.tencent.bugly.proguard.a parama, f paramf, String paramString)
  {
    try
    {
      if (r == null) {
        r = new c(1003, paramContext, w.a(), paramBoolean, null, paramf, null);
      }
      paramContext = r;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void a(long paramLong)
  {
    w.a().a(new c.2(this), paramLong);
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    this.s.a(paramStrategyBean);
    this.t.onStrategyChanged(paramStrategyBean);
    this.w.c();
    w.a().a(new c.2(this), 3000L);
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean)
  {
    this.p.e(paramCrashDetailBean);
  }
  
  public final void a(f paramf)
  {
    try
    {
      if (this.p != null) {
        this.p.a = paramf;
      }
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    this.v.a(new c.1(this, false, paramThread, paramThrowable, paramString, paramArrayOfByte, false));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      this.t.testNativeCrash(paramBoolean1, paramBoolean2, paramBoolean3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    this.s.b();
  }
  
  public final void c()
  {
    this.s.a();
  }
  
  public final void d()
  {
    this.t.setUserOpened(false);
  }
  
  public final void e()
  {
    this.t.setUserOpened(true);
  }
  
  public final void f()
  {
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.w.a(true);
      return;
    }
    this.w.d();
  }
  
  public final void g()
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      this.w.a(false);
      return;
    }
    this.w.e();
  }
  
  public final boolean h()
  {
    return this.w.a();
  }
  
  public final byte[] i()
  {
    List localList = this.p.a();
    return this.p.a(localList, true);
  }
  
  public final int j()
  {
    List localList = this.p.a();
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final NativeExceptionHandler k()
  {
    return this.t.getNativeExceptionHandler();
  }
  
  public final void l()
  {
    this.t.checkUploadRecordCrash();
  }
  
  public final boolean m()
  {
    return this.y;
  }
  
  public final boolean n()
  {
    return (this.x & 0x10) > 0;
  }
  
  public final boolean o()
  {
    return (this.x & 0x8) > 0;
  }
  
  public final boolean p()
  {
    return (this.x & 0x4) > 0;
  }
  
  public final boolean q()
  {
    return (this.x & 0x2) > 0;
  }
  
  public final boolean r()
  {
    return (this.x & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.c
 * JD-Core Version:    0.7.0.1
 */