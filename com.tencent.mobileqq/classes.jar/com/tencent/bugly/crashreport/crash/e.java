package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements Thread.UncaughtExceptionHandler
{
  private static String h;
  private static final Object i = new Object();
  private Context a;
  private b b;
  private com.tencent.bugly.crashreport.common.strategy.a c;
  private com.tencent.bugly.crashreport.common.info.a d;
  private Thread.UncaughtExceptionHandler e;
  private Thread.UncaughtExceptionHandler f;
  private boolean g = false;
  private int j;
  
  public e(Context paramContext, b paramb, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  private static String a(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable == null) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    try
    {
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int m = paramThrowable.length;
        int k = 0;
        while (k < m)
        {
          Object localObject = paramThrowable[k];
          if ((paramInt > 0) && (localStringBuilder.length() >= paramInt))
          {
            paramThrowable = new StringBuilder("\n[Stack over limit size :");
            paramThrowable.append(paramInt);
            paramThrowable.append(" , has been cutted !]");
            localStringBuilder.append(paramThrowable.toString());
            return localStringBuilder.toString();
          }
          localStringBuilder.append(localObject.toString());
          localStringBuilder.append("\n");
          k += 1;
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable paramThrowable)
    {
      x.e("gen stack error %s", new Object[] { paramThrowable.toString() });
    }
  }
  
  private static boolean a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    if (paramUncaughtExceptionHandler == null) {
      return true;
    }
    paramUncaughtExceptionHandler = paramUncaughtExceptionHandler.getClass().getName();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int m = arrayOfStackTraceElement.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = arrayOfStackTraceElement[k];
      String str = ((StackTraceElement)localObject).getClassName();
      localObject = ((StackTraceElement)localObject).getMethodName();
      if ((paramUncaughtExceptionHandler.equals(str)) && ("uncaughtException".equals(localObject))) {
        return false;
      }
      k += 1;
    }
    return true;
  }
  
  private static boolean a(Thread paramThread)
  {
    synchronized (i)
    {
      if (h != null)
      {
        boolean bool = paramThread.getName().equals(h);
        if (bool) {
          return true;
        }
      }
      h = paramThread.getName();
      return false;
    }
  }
  
  private CrashDetailBean b(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    if (paramThrowable == null)
    {
      x.d("We can do nothing with a null throwable.", new Object[0]);
      return null;
    }
    boolean bool = c.a().h();
    Object localObject1;
    if ((bool) && (paramBoolean)) {
      localObject1 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      localObject1 = "";
    }
    if ((bool) && (paramBoolean)) {
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
    localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
    localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
    localCrashDetailBean.F = this.d.n();
    localCrashDetailBean.G = this.d.m();
    localCrashDetailBean.H = this.d.o();
    localCrashDetailBean.w = z.a(this.a, c.e, c.h);
    localCrashDetailBean.y = y.a();
    if (localCrashDetailBean.y == null) {
      k = 0;
    } else {
      k = localCrashDetailBean.y.length;
    }
    x.a("user log size:%d", new Object[] { Integer.valueOf(k) });
    if (paramBoolean) {
      k = 0;
    } else {
      k = 2;
    }
    localCrashDetailBean.b = k;
    localCrashDetailBean.e = this.d.g();
    localCrashDetailBean.f = this.d.m;
    localCrashDetailBean.g = this.d.u();
    localCrashDetailBean.m = this.d.f();
    String str3 = paramThrowable.getClass().getName();
    String str2 = b(paramThrowable, 1000);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    int k = paramThrowable.getStackTrace().length;
    if (paramThrowable.getCause() != null) {
      bool = true;
    } else {
      bool = false;
    }
    x.e("stack frame :%d, has cause %b", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool) });
    if (paramThrowable.getStackTrace().length > 0) {
      str2 = paramThrowable.getStackTrace()[0].toString();
    } else {
      str2 = "";
    }
    for (Object localObject2 = paramThrowable; (localObject2 != null) && (((Throwable)localObject2).getCause() != null); localObject2 = ((Throwable)localObject2).getCause()) {}
    if ((localObject2 != null) && (localObject2 != paramThrowable))
    {
      localCrashDetailBean.n = localObject2.getClass().getName();
      localCrashDetailBean.o = b((Throwable)localObject2, 1000);
      if (localCrashDetailBean.o == null) {
        localCrashDetailBean.o = "";
      }
      if (((Throwable)localObject2).getStackTrace().length > 0) {
        localCrashDetailBean.p = localObject2.getStackTrace()[0].toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str3);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("\n......");
      ((StringBuilder)localObject1).append("\nCaused by:\n");
      ((StringBuilder)localObject1).append(localCrashDetailBean.n);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localCrashDetailBean.o);
      ((StringBuilder)localObject1).append("\n");
      paramThrowable = a((Throwable)localObject2, c.f);
      ((StringBuilder)localObject1).append(paramThrowable);
      localCrashDetailBean.q = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localCrashDetailBean.n = str3;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append((String)localObject1);
      localCrashDetailBean.o = ((StringBuilder)localObject2).toString();
      if (localCrashDetailBean.o == null) {
        localCrashDetailBean.o = "";
      }
      localCrashDetailBean.p = str2;
      paramThrowable = a(paramThrowable, c.f);
      localCrashDetailBean.q = paramThrowable;
    }
    localCrashDetailBean.r = System.currentTimeMillis();
    localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
    for (;;)
    {
      try
      {
        localCrashDetailBean.z = z.a(c.f, false);
        localCrashDetailBean.A = this.d.d;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramThread.getName());
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramThread.getId());
        ((StringBuilder)localObject1).append(")");
        localCrashDetailBean.B = ((StringBuilder)localObject1).toString();
        localCrashDetailBean.z.put(localCrashDetailBean.B, paramThrowable);
        localCrashDetailBean.I = this.d.w();
        localCrashDetailBean.h = this.d.t();
        localCrashDetailBean.i = this.d.H();
        localCrashDetailBean.M = this.d.a;
        localCrashDetailBean.N = this.d.a();
        if (paramBoolean)
        {
          this.b.d(localCrashDetailBean);
        }
        else
        {
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label1039;
          }
          k = 1;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1045;
          }
          m = 1;
          if (k != 0)
          {
            localCrashDetailBean.O = new HashMap(1);
            localCrashDetailBean.O.put("UserData", paramString);
          }
          if (m != 0) {
            localCrashDetailBean.U = paramArrayOfByte;
          }
        }
        localCrashDetailBean.Q = this.d.F();
        localCrashDetailBean.R = this.d.G();
        localCrashDetailBean.S = this.d.z();
        localCrashDetailBean.T = this.d.E();
        return localCrashDetailBean;
      }
      catch (Throwable paramThread)
      {
        x.e("handle crash error %s", new Object[] { paramThread.toString() });
        return localCrashDetailBean;
      }
      label1039:
      k = 0;
      continue;
      label1045:
      int m = 0;
    }
  }
  
  private static String b(Throwable paramThrowable, int paramInt)
  {
    if (paramThrowable.getMessage() == null) {
      return "";
    }
    if (paramThrowable.getMessage().length() <= 1000) {
      return paramThrowable.getMessage();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getMessage().substring(0, 1000));
    localStringBuilder.append("\n[Message over limit size:1000");
    localStringBuilder.append(", has been cutted!]");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    try
    {
      if (this.j >= 10)
      {
        x.a("java crash handler over %d, no need set.", new Object[] { Integer.valueOf(10) });
        return;
      }
      this.g = true;
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null)
      {
        boolean bool = getClass().getName().equals(localUncaughtExceptionHandler.getClass().getName());
        if (bool) {
          return;
        }
        if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(localUncaughtExceptionHandler.getClass().getName()))
        {
          x.a("backup system java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
          this.f = localUncaughtExceptionHandler;
          this.e = localUncaughtExceptionHandler;
        }
        else
        {
          x.a("backup java handler: %s", new Object[] { localUncaughtExceptionHandler.toString() });
          this.e = localUncaughtExceptionHandler;
        }
      }
      Thread.setDefaultUncaughtExceptionHandler(this);
      this.j += 1;
      x.a("registered java monitor: %s", new Object[] { toString() });
      return;
    }
    finally {}
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean != null) {
      try
      {
        if (paramStrategyBean.f != this.g)
        {
          x.a("java changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.f) });
          if (paramStrategyBean.f)
          {
            a();
            return;
          }
          b();
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +105 -> 106
    //   4: ldc_w 428
    //   7: iconst_2
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: invokevirtual 124	java/lang/Thread:getName	()Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_1
    //   21: invokevirtual 299	java/lang/Thread:getId	()J
    //   24: invokestatic 433	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   27: aastore
    //   28: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokestatic 435	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread;)Z
    //   36: ifeq +81 -> 117
    //   39: ldc_w 437
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 215	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aload_0
    //   51: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   54: ifnull +28 -> 82
    //   57: ldc_w 439
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 215	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_0
    //   69: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   72: aload_1
    //   73: aload_2
    //   74: invokeinterface 442 3 0
    //   79: goto +38 -> 117
    //   82: ldc_w 444
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: invokestatic 449	android/os/Process:myPid	()I
    //   96: invokestatic 452	android/os/Process:killProcess	(I)V
    //   99: iconst_1
    //   100: invokestatic 455	java/lang/System:exit	(I)V
    //   103: goto +14 -> 117
    //   106: ldc_w 457
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload_0
    //   118: getfield 36	com/tencent/bugly/crashreport/crash/e:g	Z
    //   121: ifne +156 -> 277
    //   124: ldc_w 459
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 461	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   134: pop
    //   135: iload_3
    //   136: ifeq +140 -> 276
    //   139: aload_0
    //   140: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   143: astore 4
    //   145: aload 4
    //   147: ifnull +45 -> 192
    //   150: aload 4
    //   152: invokestatic 463	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread$UncaughtExceptionHandler;)Z
    //   155: ifeq +37 -> 192
    //   158: ldc_w 465
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   173: aload_1
    //   174: aload_2
    //   175: invokeinterface 442 3 0
    //   180: ldc_w 467
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   190: pop
    //   191: return
    //   192: aload_0
    //   193: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   196: ifnull +37 -> 233
    //   199: ldc_w 469
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   209: pop
    //   210: aload_0
    //   211: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   214: aload_1
    //   215: aload_2
    //   216: invokeinterface 442 3 0
    //   221: ldc_w 471
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   231: pop
    //   232: return
    //   233: ldc_w 473
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   243: pop
    //   244: ldc_w 444
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   254: pop
    //   255: invokestatic 449	android/os/Process:myPid	()I
    //   258: invokestatic 452	android/os/Process:killProcess	(I)V
    //   261: iconst_1
    //   262: invokestatic 455	java/lang/System:exit	(I)V
    //   265: ldc_w 475
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   275: pop
    //   276: return
    //   277: aload_0
    //   278: getfield 42	com/tencent/bugly/crashreport/crash/e:c	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   281: invokevirtual 479	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   284: ifne +14 -> 298
    //   287: ldc_w 481
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 129	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   297: pop
    //   298: aload_0
    //   299: getfield 42	com/tencent/bugly/crashreport/crash/e:c	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   302: invokevirtual 484	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   305: getfield 419	com/tencent/bugly/crashreport/common/strategy/StrategyBean:f	Z
    //   308: istore 6
    //   310: iload 6
    //   312: ifne +202 -> 514
    //   315: aload_0
    //   316: getfield 42	com/tencent/bugly/crashreport/crash/e:c	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   319: invokevirtual 479	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   322: ifeq +192 -> 514
    //   325: ldc_w 486
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   335: pop
    //   336: iload_3
    //   337: ifeq +883 -> 1220
    //   340: ldc_w 488
    //   343: astore 4
    //   345: goto +3 -> 348
    //   348: aload 4
    //   350: invokestatic 490	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 44	com/tencent/bugly/crashreport/crash/e:d	Lcom/tencent/bugly/crashreport/common/info/a;
    //   357: getfield 291	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   360: aload_1
    //   361: invokevirtual 124	java/lang/Thread:getName	()Ljava/lang/String;
    //   364: aload_2
    //   365: invokestatic 493	com/tencent/bugly/proguard/z:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   368: aconst_null
    //   369: invokestatic 496	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   372: iload_3
    //   373: ifeq +140 -> 513
    //   376: aload_0
    //   377: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   380: astore 4
    //   382: aload 4
    //   384: ifnull +45 -> 429
    //   387: aload 4
    //   389: invokestatic 463	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread$UncaughtExceptionHandler;)Z
    //   392: ifeq +37 -> 429
    //   395: ldc_w 465
    //   398: iconst_0
    //   399: anewarray 4	java/lang/Object
    //   402: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   405: pop
    //   406: aload_0
    //   407: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   410: aload_1
    //   411: aload_2
    //   412: invokeinterface 442 3 0
    //   417: ldc_w 467
    //   420: iconst_0
    //   421: anewarray 4	java/lang/Object
    //   424: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   427: pop
    //   428: return
    //   429: aload_0
    //   430: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   433: ifnull +37 -> 470
    //   436: ldc_w 469
    //   439: iconst_0
    //   440: anewarray 4	java/lang/Object
    //   443: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   446: pop
    //   447: aload_0
    //   448: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   451: aload_1
    //   452: aload_2
    //   453: invokeinterface 442 3 0
    //   458: ldc_w 471
    //   461: iconst_0
    //   462: anewarray 4	java/lang/Object
    //   465: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   468: pop
    //   469: return
    //   470: ldc_w 473
    //   473: iconst_0
    //   474: anewarray 4	java/lang/Object
    //   477: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   480: pop
    //   481: ldc_w 444
    //   484: iconst_0
    //   485: anewarray 4	java/lang/Object
    //   488: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   491: pop
    //   492: invokestatic 449	android/os/Process:myPid	()I
    //   495: invokestatic 452	android/os/Process:killProcess	(I)V
    //   498: iconst_1
    //   499: invokestatic 455	java/lang/System:exit	(I)V
    //   502: ldc_w 475
    //   505: iconst_0
    //   506: anewarray 4	java/lang/Object
    //   509: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   512: pop
    //   513: return
    //   514: aload_0
    //   515: aload_1
    //   516: aload_2
    //   517: iload_3
    //   518: aload 4
    //   520: aload 5
    //   522: invokespecial 498	com/tencent/bugly/crashreport/crash/e:b	(Ljava/lang/Thread;Ljava/lang/Throwable;ZLjava/lang/String;[B)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   525: astore 5
    //   527: aload 5
    //   529: ifnonnull +156 -> 685
    //   532: ldc_w 500
    //   535: iconst_0
    //   536: anewarray 4	java/lang/Object
    //   539: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   542: pop
    //   543: iload_3
    //   544: ifeq +140 -> 684
    //   547: aload_0
    //   548: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   551: astore 4
    //   553: aload 4
    //   555: ifnull +45 -> 600
    //   558: aload 4
    //   560: invokestatic 463	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread$UncaughtExceptionHandler;)Z
    //   563: ifeq +37 -> 600
    //   566: ldc_w 465
    //   569: iconst_0
    //   570: anewarray 4	java/lang/Object
    //   573: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   576: pop
    //   577: aload_0
    //   578: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   581: aload_1
    //   582: aload_2
    //   583: invokeinterface 442 3 0
    //   588: ldc_w 467
    //   591: iconst_0
    //   592: anewarray 4	java/lang/Object
    //   595: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   598: pop
    //   599: return
    //   600: aload_0
    //   601: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   604: ifnull +37 -> 641
    //   607: ldc_w 469
    //   610: iconst_0
    //   611: anewarray 4	java/lang/Object
    //   614: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   617: pop
    //   618: aload_0
    //   619: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   622: aload_1
    //   623: aload_2
    //   624: invokeinterface 442 3 0
    //   629: ldc_w 471
    //   632: iconst_0
    //   633: anewarray 4	java/lang/Object
    //   636: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   639: pop
    //   640: return
    //   641: ldc_w 473
    //   644: iconst_0
    //   645: anewarray 4	java/lang/Object
    //   648: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   651: pop
    //   652: ldc_w 444
    //   655: iconst_0
    //   656: anewarray 4	java/lang/Object
    //   659: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   662: pop
    //   663: invokestatic 449	android/os/Process:myPid	()I
    //   666: invokestatic 452	android/os/Process:killProcess	(I)V
    //   669: iconst_1
    //   670: invokestatic 455	java/lang/System:exit	(I)V
    //   673: ldc_w 475
    //   676: iconst_0
    //   677: anewarray 4	java/lang/Object
    //   680: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   683: pop
    //   684: return
    //   685: iload_3
    //   686: ifeq +11 -> 697
    //   689: ldc_w 488
    //   692: astore 4
    //   694: goto +8 -> 702
    //   697: ldc_w 502
    //   700: astore 4
    //   702: aload 4
    //   704: invokestatic 490	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   707: aload_0
    //   708: getfield 44	com/tencent/bugly/crashreport/crash/e:d	Lcom/tencent/bugly/crashreport/common/info/a;
    //   711: getfield 291	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   714: aload_1
    //   715: invokevirtual 124	java/lang/Thread:getName	()Ljava/lang/String;
    //   718: aload_2
    //   719: invokestatic 493	com/tencent/bugly/proguard/z:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   722: aload 5
    //   724: invokestatic 496	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   727: aload_0
    //   728: getfield 40	com/tencent/bugly/crashreport/crash/e:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   731: aload 5
    //   733: invokevirtual 505	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   736: ifne +16 -> 752
    //   739: aload_0
    //   740: getfield 40	com/tencent/bugly/crashreport/crash/e:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   743: aload 5
    //   745: ldc2_w 506
    //   748: iload_3
    //   749: invokevirtual 510	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   752: iload_3
    //   753: ifeq +12 -> 765
    //   756: aload_0
    //   757: getfield 40	com/tencent/bugly/crashreport/crash/e:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   760: aload 5
    //   762: invokevirtual 512	com/tencent/bugly/crashreport/crash/b:c	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   765: iload_3
    //   766: ifeq +302 -> 1068
    //   769: aload_0
    //   770: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   773: astore 4
    //   775: aload 4
    //   777: ifnull +45 -> 822
    //   780: aload 4
    //   782: invokestatic 463	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread$UncaughtExceptionHandler;)Z
    //   785: ifeq +37 -> 822
    //   788: ldc_w 465
    //   791: iconst_0
    //   792: anewarray 4	java/lang/Object
    //   795: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   798: pop
    //   799: aload_0
    //   800: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   803: aload_1
    //   804: aload_2
    //   805: invokeinterface 442 3 0
    //   810: ldc_w 467
    //   813: iconst_0
    //   814: anewarray 4	java/lang/Object
    //   817: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   820: pop
    //   821: return
    //   822: aload_0
    //   823: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   826: ifnull +37 -> 863
    //   829: ldc_w 469
    //   832: iconst_0
    //   833: anewarray 4	java/lang/Object
    //   836: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   839: pop
    //   840: aload_0
    //   841: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   844: aload_1
    //   845: aload_2
    //   846: invokeinterface 442 3 0
    //   851: ldc_w 471
    //   854: iconst_0
    //   855: anewarray 4	java/lang/Object
    //   858: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   861: pop
    //   862: return
    //   863: ldc_w 473
    //   866: iconst_0
    //   867: anewarray 4	java/lang/Object
    //   870: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   873: pop
    //   874: ldc_w 444
    //   877: iconst_0
    //   878: anewarray 4	java/lang/Object
    //   881: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   884: pop
    //   885: invokestatic 449	android/os/Process:myPid	()I
    //   888: invokestatic 452	android/os/Process:killProcess	(I)V
    //   891: iconst_1
    //   892: invokestatic 455	java/lang/System:exit	(I)V
    //   895: ldc_w 475
    //   898: iconst_0
    //   899: anewarray 4	java/lang/Object
    //   902: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   905: pop
    //   906: return
    //   907: astore 4
    //   909: goto +160 -> 1069
    //   912: astore 4
    //   914: aload 4
    //   916: invokestatic 515	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   919: ifne +8 -> 927
    //   922: aload 4
    //   924: invokevirtual 518	java/lang/Throwable:printStackTrace	()V
    //   927: iload_3
    //   928: ifeq +140 -> 1068
    //   931: aload_0
    //   932: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   935: astore 4
    //   937: aload 4
    //   939: ifnull +45 -> 984
    //   942: aload 4
    //   944: invokestatic 463	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread$UncaughtExceptionHandler;)Z
    //   947: ifeq +37 -> 984
    //   950: ldc_w 465
    //   953: iconst_0
    //   954: anewarray 4	java/lang/Object
    //   957: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   960: pop
    //   961: aload_0
    //   962: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   965: aload_1
    //   966: aload_2
    //   967: invokeinterface 442 3 0
    //   972: ldc_w 467
    //   975: iconst_0
    //   976: anewarray 4	java/lang/Object
    //   979: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   982: pop
    //   983: return
    //   984: aload_0
    //   985: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   988: ifnull +37 -> 1025
    //   991: ldc_w 469
    //   994: iconst_0
    //   995: anewarray 4	java/lang/Object
    //   998: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1001: pop
    //   1002: aload_0
    //   1003: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   1006: aload_1
    //   1007: aload_2
    //   1008: invokeinterface 442 3 0
    //   1013: ldc_w 471
    //   1016: iconst_0
    //   1017: anewarray 4	java/lang/Object
    //   1020: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1023: pop
    //   1024: return
    //   1025: ldc_w 473
    //   1028: iconst_0
    //   1029: anewarray 4	java/lang/Object
    //   1032: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1035: pop
    //   1036: ldc_w 444
    //   1039: iconst_0
    //   1040: anewarray 4	java/lang/Object
    //   1043: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1046: pop
    //   1047: invokestatic 449	android/os/Process:myPid	()I
    //   1050: invokestatic 452	android/os/Process:killProcess	(I)V
    //   1053: iconst_1
    //   1054: invokestatic 455	java/lang/System:exit	(I)V
    //   1057: ldc_w 475
    //   1060: iconst_0
    //   1061: anewarray 4	java/lang/Object
    //   1064: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1067: pop
    //   1068: return
    //   1069: iload_3
    //   1070: ifeq +147 -> 1217
    //   1073: aload_0
    //   1074: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   1077: astore 5
    //   1079: aload 5
    //   1081: ifnull +50 -> 1131
    //   1084: aload 5
    //   1086: invokestatic 463	com/tencent/bugly/crashreport/crash/e:a	(Ljava/lang/Thread$UncaughtExceptionHandler;)Z
    //   1089: ifne +6 -> 1095
    //   1092: goto +39 -> 1131
    //   1095: ldc_w 465
    //   1098: iconst_0
    //   1099: anewarray 4	java/lang/Object
    //   1102: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1105: pop
    //   1106: aload_0
    //   1107: getfield 406	com/tencent/bugly/crashreport/crash/e:e	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   1110: aload_1
    //   1111: aload_2
    //   1112: invokeinterface 442 3 0
    //   1117: ldc_w 467
    //   1120: iconst_0
    //   1121: anewarray 4	java/lang/Object
    //   1124: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1127: pop
    //   1128: goto +89 -> 1217
    //   1131: aload_0
    //   1132: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   1135: ifnull +39 -> 1174
    //   1138: ldc_w 469
    //   1141: iconst_0
    //   1142: anewarray 4	java/lang/Object
    //   1145: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1148: pop
    //   1149: aload_0
    //   1150: getfield 404	com/tencent/bugly/crashreport/crash/e:f	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   1153: aload_1
    //   1154: aload_2
    //   1155: invokeinterface 442 3 0
    //   1160: ldc_w 471
    //   1163: iconst_0
    //   1164: anewarray 4	java/lang/Object
    //   1167: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1170: pop
    //   1171: goto +46 -> 1217
    //   1174: ldc_w 473
    //   1177: iconst_0
    //   1178: anewarray 4	java/lang/Object
    //   1181: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1184: pop
    //   1185: ldc_w 444
    //   1188: iconst_0
    //   1189: anewarray 4	java/lang/Object
    //   1192: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1195: pop
    //   1196: invokestatic 449	android/os/Process:myPid	()I
    //   1199: invokestatic 452	android/os/Process:killProcess	(I)V
    //   1202: iconst_1
    //   1203: invokestatic 455	java/lang/System:exit	(I)V
    //   1206: ldc_w 475
    //   1209: iconst_0
    //   1210: anewarray 4	java/lang/Object
    //   1213: invokestatic 89	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1216: pop
    //   1217: aload 4
    //   1219: athrow
    //   1220: ldc_w 502
    //   1223: astore 4
    //   1225: goto -877 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1228	0	this	e
    //   0	1228	1	paramThread	Thread
    //   0	1228	2	paramThrowable	Throwable
    //   0	1228	3	paramBoolean	boolean
    //   0	1228	4	paramString	String
    //   0	1228	5	paramArrayOfByte	byte[]
    //   308	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   117	135	907	finally
    //   277	298	907	finally
    //   298	310	907	finally
    //   315	336	907	finally
    //   348	372	907	finally
    //   514	527	907	finally
    //   532	543	907	finally
    //   702	752	907	finally
    //   756	765	907	finally
    //   914	927	907	finally
    //   117	135	912	java/lang/Throwable
    //   277	298	912	java/lang/Throwable
    //   298	310	912	java/lang/Throwable
    //   315	336	912	java/lang/Throwable
    //   348	372	912	java/lang/Throwable
    //   514	527	912	java/lang/Throwable
    //   532	543	912	java/lang/Throwable
    //   702	752	912	java/lang/Throwable
    //   756	765	912	java/lang/Throwable
  }
  
  public final void b()
  {
    try
    {
      this.g = false;
      x.a("close java monitor!", new Object[0]);
      if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly"))
      {
        x.a("Java monitor to unregister: %s", new Object[] { toString() });
        Thread.setDefaultUncaughtExceptionHandler(this.e);
        this.j -= 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    synchronized (i)
    {
      a(paramThread, paramThrowable, true, null, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.e
 * JD-Core Version:    0.7.0.1
 */