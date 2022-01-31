package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;

public class NativeCrashHandler
  implements com.tencent.bugly.crashreport.a
{
  private static NativeCrashHandler a;
  private static boolean l = false;
  private static boolean m = false;
  private static boolean o = true;
  private final Context b;
  private final com.tencent.bugly.crashreport.common.info.a c;
  private final w d;
  private NativeExceptionHandler e;
  private String f;
  private final boolean g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private com.tencent.bugly.crashreport.crash.b n;
  
  @SuppressLint({"SdCardPath"})
  private NativeCrashHandler(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, w paramw, boolean paramBoolean, String paramString)
  {
    this.b = z.a(paramContext);
    for (;;)
    {
      try
      {
        boolean bool = z.a(paramString);
        if (bool) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        paramString = com.tencent.bugly.crashreport.common.info.a.a(paramContext).c;
        paramString = "/data/data/" + paramString + "/app_bugly";
        continue;
      }
      this.n = paramb;
      this.f = paramString;
      this.c = parama;
      this.d = paramw;
      this.g = paramBoolean;
      this.e = new a(paramContext, parama, paramb, com.tencent.bugly.crashreport.common.strategy.a.a());
      return;
      paramString = paramContext.getDir("bugly", 0).getAbsolutePath();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool;
    String str2;
    String str3;
    Object localObject3;
    for (;;)
    {
      try
      {
        if (this.j)
        {
          x.d("[Native] Native crash report has already registered.", new Object[0]);
          return;
        }
        bool = this.i;
        if (bool) {
          try
          {
            str2 = regist(this.f, paramBoolean, 1);
            if (str2 != null)
            {
              x.a("[Native] Native Crash Report enable.", new Object[0]);
              x.c("[Native] Check extra jni for Bugly NDK v%s", new Object[] { str2 });
              str3 = "2.1.1".replace(".", "");
              str4 = "2.3.0".replace(".", "");
              localObject3 = str2.replace(".", "");
              if (((String)localObject3).length() != 2) {
                break label258;
              }
              str1 = (String)localObject3 + "0";
            }
          }
          catch (Throwable localThrowable1)
          {
            String str4;
            String str1;
            label137:
            label187:
            label203:
            x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
          }
        }
      }
      finally {}
      try
      {
        if (Integer.parseInt(str1) >= Integer.parseInt(str3)) {
          l = true;
        }
        if (Integer.parseInt(str1) >= Integer.parseInt(str4)) {
          m = true;
        }
      }
      catch (Throwable localThrowable3)
      {
        Object localObject2;
        continue;
      }
      if (!m) {
        break label296;
      }
      x.a("[Native] Info setting jni can be accessed.", new Object[0]);
      if (!l) {
        break label309;
      }
      x.a("[Native] Extra jni can be accessed.", new Object[0]);
      this.c.p = str2;
      y.a(l);
      this.j = true;
    }
    label238:
    do
    {
      this.i = false;
      this.h = false;
      break;
      localObject2 = localObject3;
      if (((String)localObject3).length() != 1) {
        break label137;
      }
      localObject2 = (String)localObject3 + "00";
      break label137;
      x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
      break label187;
      x.d("[Native] Extra jni can not be accessed.", new Object[0]);
      break label203;
      bool = this.h;
    } while (!bool);
    for (;;)
    {
      try
      {
        label258:
        label296:
        label309:
        localObject2 = Integer.TYPE;
        localObject3 = Integer.TYPE;
        str2 = this.f;
        str3 = com.tencent.bugly.crashreport.common.info.b.a(this.b, false);
        if (!paramBoolean) {
          break label661;
        }
        i1 = 1;
        localObject3 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[] { String.class, String.class, localObject2, localObject3 }, new Object[] { str2, str3, Integer.valueOf(i1), Integer.valueOf(1) });
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = Integer.TYPE;
          localObject3 = this.f;
          str2 = com.tencent.bugly.crashreport.common.info.b.a(this.b, false);
          com.tencent.bugly.crashreport.common.info.a.b();
          i1 = com.tencent.bugly.crashreport.common.info.a.J();
          localObject2 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[] { String.class, String.class, localObject2 }, new Object[] { localObject3, str2, Integer.valueOf(i1) });
        }
        if (localObject2 == null) {
          break label238;
        }
        this.j = true;
        com.tencent.bugly.crashreport.common.info.a.b().p = ((String)localObject2);
        localObject2 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[] { String.class }, new Object[] { localObject2 });
        if (localObject2 != null)
        {
          bool = ((Boolean)localObject2).booleanValue();
          l = bool;
          y.a(bool);
        }
        z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(true) });
        if (!paramBoolean) {
          break label666;
        }
        i1 = 1;
        z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(i1) });
      }
      catch (Throwable localThrowable2) {}
      break label238;
      label661:
      int i1 = 5;
      continue;
      label666:
      i1 = 5;
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((!this.i) || (!m)) {}
    do
    {
      return false;
      try
      {
        setNativeInfo(paramInt, paramString);
        return true;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        m = false;
        return false;
      }
      catch (Throwable paramString) {}
    } while (x.a(paramString));
    paramString.printStackTrace();
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        x.a("[Native] Trying to load so: %s", new Object[] { paramString });
        if (paramBoolean) {
          System.load(paramString);
        }
      }
      catch (Throwable localThrowable1)
      {
        paramBoolean = false;
      }
      try
      {
        x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
        return true;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramBoolean = true;
        }
      }
      System.loadLibrary(paramString);
    }
    x.d(localThrowable1.getMessage(), new Object[0]);
    x.d("[Native] Failed to load so: %s", new Object[] { paramString });
    return paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        startNativeMonitor();
        return;
      }
      finally {}
      c();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 283
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 136	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: invokevirtual 286	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:unregist	()Ljava/lang/String;
    //   27: ifnull +34 -> 61
    //   30: ldc_w 288
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 144	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 55	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 290
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 148	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc 205
    //   63: ldc 234
    //   65: aconst_null
    //   66: iconst_1
    //   67: anewarray 209	java/lang/Class
    //   70: dup
    //   71: iconst_0
    //   72: getstatic 235	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   75: aastore
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: iconst_0
    //   83: invokestatic 238	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic 216	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 55	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   96: ldc_w 288
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 144	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: pop
    //   107: goto -87 -> 20
    //   110: astore_1
    //   111: ldc_w 290
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 148	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 53	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:i	Z
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield 51	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:h	Z
    //   132: goto -112 -> 20
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	NativeCrashHandler
    //   49	1	1	localThrowable1	Throwable
    //   110	1	1	localThrowable2	Throwable
    //   135	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	java/lang/Throwable
    //   61	107	110	java/lang/Throwable
    //   2	20	135	finally
    //   23	46	135	finally
    //   50	61	135	finally
    //   61	107	135	finally
    //   111	132	135	finally
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.k != paramBoolean)
      {
        x.a("user change native %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.k = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NativeCrashHandler getInstance()
  {
    try
    {
      NativeCrashHandler localNativeCrashHandler = a;
      return localNativeCrashHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1, w paramw, boolean paramBoolean, String paramString)
  {
    try
    {
      if (a == null) {
        a = new NativeCrashHandler(paramContext, parama, paramb, paramw, paramBoolean, paramString);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean isShouldHandleInJava()
  {
    return o;
  }
  
  public static void setShouldHandleInJava(boolean paramBoolean)
  {
    o = paramBoolean;
    if (a != null) {
      a.a(999, paramBoolean);
    }
  }
  
  protected final void a()
  {
    long l1 = z.b();
    long l2 = c.g;
    long l3 = z.b();
    Object localObject1 = new File(this.f);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0)) {}
    }
    else
    {
      return;
    }
    int i6 = localObject1.length;
    int i1 = 0;
    int i3 = 0;
    int i2;
    for (int i4 = 0; i1 < i6; i4 = i2)
    {
      Object localObject2 = localObject1[i1];
      String str = localObject2.getName();
      int i5 = i3;
      i2 = i4;
      if (str.contains("_"))
      {
        i5 = i3;
        i2 = i4;
        if (str.endsWith(".txt"))
        {
          long l4 = localObject2.lastModified();
          if (l4 >= l1 - l2)
          {
            i5 = i3;
            i2 = i4;
            if (l4 < 86400000L + l3) {}
          }
          else
          {
            x.a("[Native] Delete record file: %s", new Object[] { localObject2.getAbsolutePath() });
            i4 += 1;
            i5 = i3;
            i2 = i4;
            if (localObject2.delete())
            {
              i5 = i3 + 1;
              i2 = i4;
            }
          }
        }
      }
      i1 += 1;
      i3 = i5;
    }
    x.c("[Native] Number of record files overdue: %d, has deleted: %d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i3) });
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3)
  {
    if ((!this.h) && (!this.i)) {
      return false;
    }
    if (!l) {
      return false;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (this.i) {
        return appendNativeLog(paramString1, paramString2, paramString3);
      }
      paramString1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      if (paramString1 != null)
      {
        boolean bool = paramString1.booleanValue();
        return bool;
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      l = false;
      return false;
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash(long paramLong)
  {
    this.d.a(new Runnable()
    {
      public final void run()
      {
        if (!z.a(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock", 10000L))
        {
          x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
          return;
        }
        if (!NativeCrashHandler.b()) {
          NativeCrashHandler.a(NativeCrashHandler.this, 999, "false");
        }
        CrashDetailBean localCrashDetailBean = b.a(NativeCrashHandler.a(NativeCrashHandler.this), NativeCrashHandler.b(NativeCrashHandler.this), NativeCrashHandler.c(NativeCrashHandler.this));
        if (localCrashDetailBean != null)
        {
          x.a("[Native] Get crash from native record.", new Object[0]);
          if (!NativeCrashHandler.d(NativeCrashHandler.this).a(localCrashDetailBean)) {
            NativeCrashHandler.d(NativeCrashHandler.this).a(localCrashDetailBean, 3000L, false);
          }
          b.a(false, NativeCrashHandler.b(NativeCrashHandler.this));
        }
        NativeCrashHandler.this.a();
        z.b(NativeCrashHandler.a(NativeCrashHandler.this), "native_record_lock");
      }
    }, paramLong);
  }
  
  public boolean filterSigabrtSysLog()
  {
    return a(998, "true");
  }
  
  public String getDumpFilePath()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLogFromNative()
  {
    if ((!this.h) && (!this.i)) {
      return null;
    }
    if (!l) {
      return null;
    }
    try
    {
      if (this.i) {
        return getNativeLog();
      }
      String str = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      l = false;
      return null;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  public NativeExceptionHandler getNativeExceptionHandler()
  {
    return this.e;
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public boolean isUserOpened()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void onStrategyChanged(StrategyBean paramStrategyBean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +35 -> 40
    //   8: aload_1
    //   9: getfield 384	com/tencent/bugly/crashreport/common/strategy/StrategyBean:g	Z
    //   12: aload_0
    //   13: getfield 55	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   16: if_icmpeq +24 -> 40
    //   19: ldc_w 386
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: getfield 384	com/tencent/bugly/crashreport/common/strategy/StrategyBean:g	Z
    //   32: invokestatic 238	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: aastore
    //   36: invokestatic 136	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   39: pop
    //   40: invokestatic 84	com/tencent/bugly/crashreport/common/strategy/a:a	()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   43: invokevirtual 389	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   46: getfield 384	com/tencent/bugly/crashreport/common/strategy/StrategyBean:g	Z
    //   49: ifeq +44 -> 93
    //   52: aload_0
    //   53: getfield 57	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:k	Z
    //   56: ifeq +37 -> 93
    //   59: iload_2
    //   60: aload_0
    //   61: getfield 55	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:j	Z
    //   64: if_icmpeq +26 -> 90
    //   67: ldc_w 391
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: iload_2
    //   77: invokestatic 238	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: aastore
    //   81: invokestatic 144	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: iload_2
    //   87: invokespecial 393	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:b	(Z)V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iconst_0
    //   94: istore_2
    //   95: goto -36 -> 59
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	NativeCrashHandler
    //   0	103	1	paramStrategyBean	StrategyBean
    //   1	94	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	40	98	finally
    //   40	59	98	finally
    //   59	90	98	finally
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2)
  {
    if ((!this.h) && (!this.i)) {
      return false;
    }
    if (!l) {
      return false;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    try
    {
      if (this.i) {
        return putNativeKeyValue(paramString1, paramString2);
      }
      paramString1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      if (paramString1 != null)
      {
        boolean bool = paramString1.booleanValue();
        return bool;
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      l = false;
      return false;
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean setNativeAppChannel(String paramString)
  {
    return a(12, paramString);
  }
  
  public boolean setNativeAppPackage(String paramString)
  {
    return a(13, paramString);
  }
  
  public boolean setNativeAppVersion(String paramString)
  {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeIsAppForeground(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "true";; str = "false") {
      return a(14, str);
    }
  }
  
  public boolean setNativeLaunchTime(long paramLong)
  {
    try
    {
      boolean bool = a(15, String.valueOf(paramLong));
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!x.a(localNumberFormatException)) {
        localNumberFormatException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean setNativeUserId(String paramString)
  {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      c(paramBoolean);
      paramBoolean = isUserOpened();
      com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
      if (locala != null) {
        if ((paramBoolean) && (locala.c().g)) {
          paramBoolean = bool;
        }
      }
      for (;;)
      {
        if (paramBoolean != this.j)
        {
          x.a("native changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
          b(paramBoolean);
        }
        return;
        paramBoolean = false;
      }
    }
    finally {}
  }
  
  public void startNativeMonitor()
  {
    boolean bool;
    label208:
    Object localObject2;
    for (;;)
    {
      try
      {
        if ((this.i) || (this.h))
        {
          a(this.g);
          return;
        }
        String str1 = "Bugly";
        if (!z.a(this.c.o))
        {
          bool = true;
          if (!c.b) {
            break;
          }
          if (!bool) {
            break label208;
          }
          str1 = this.c.o;
          this.i = a(str1, bool);
          if ((!this.i) && (!bool)) {
            this.h = a("NativeRQD", false);
          }
          if ((!this.i) && (!this.h)) {
            continue;
          }
          a(this.g);
          if (!l) {
            continue;
          }
          setNativeAppVersion(this.c.l);
          setNativeAppChannel(this.c.n);
          setNativeAppPackage(this.c.c);
          setNativeUserId(this.c.f());
          setNativeIsAppForeground(this.c.a());
          setNativeLaunchTime(this.c.a);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      localObject2 = "Bugly" + "-rqd";
    }
    String str2 = this.c.o;
    if (!bool) {
      this.c.getClass();
    }
    for (;;)
    {
      this.i = a((String)localObject2, bool);
      break;
      localObject2 = str2;
    }
  }
  
  protected native void testCrash();
  
  public void testNativeCrash()
  {
    if (!this.i)
    {
      x.d("[Native] Bugly SO file has not been load.", new Object[0]);
      return;
    }
    testCrash();
  }
  
  public void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(16, paramBoolean1);
    a(17, paramBoolean2);
    a(18, paramBoolean3);
    testNativeCrash();
  }
  
  protected native String unregist();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler
 * JD-Core Version:    0.7.0.1
 */