package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
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
    try
    {
      if (!z.a(paramString)) {
        break label101;
      }
      paramString = paramContext.getDir("bugly", 0).getAbsolutePath();
    }
    catch (Throwable paramString)
    {
      label58:
      StringBuilder localStringBuilder;
      break label58;
    }
    paramString = com.tencent.bugly.crashreport.common.info.a.a(paramContext).c;
    localStringBuilder = new StringBuilder("/data/data/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/app_bugly");
    paramString = localStringBuilder.toString();
    label101:
    this.n = paramb;
    this.f = paramString;
    this.c = parama;
    this.d = paramw;
    this.g = paramBoolean;
    this.e = new a(paramContext, parama, paramb, com.tencent.bugly.crashreport.common.strategy.a.a());
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if (this.j)
      {
        x.d("[Native] Native crash report has already registered.", new Object[0]);
        return;
      }
      bool = this.i;
      if (!bool) {}
    }
    finally
    {
      boolean bool;
      String str1;
      String str2;
      String str3;
      Object localObject3;
      Object localObject1;
      label386:
      label737:
      for (;;)
      {
        label227:
        throw localObject2;
      }
    }
    try
    {
      str1 = regist(this.f, paramBoolean, 1);
      if (str1 != null)
      {
        x.a("[Native] Native Crash Report enable.", new Object[0]);
        x.c("[Native] Check extra jni for Bugly NDK v%s", new Object[] { str1 });
        str2 = "2.1.1".replace(".", "");
        str3 = "2.3.0".replace(".", "");
        localObject3 = str1.replace(".", "");
        if (((String)localObject3).length() == 2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append("0");
        }
        for (;;)
        {
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
          localObject1 = localObject3;
          if (((String)localObject3).length() != 1) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append("00");
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      break label386;
    }
    try
    {
      if (Integer.parseInt((String)localObject1) >= Integer.parseInt(str2)) {
        l = true;
      }
      if (Integer.parseInt((String)localObject1) >= Integer.parseInt(str3)) {
        m = true;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label227;
    }
    if (m) {
      x.a("[Native] Info setting jni can be accessed.", new Object[0]);
    } else {
      x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
    }
    if (l) {
      x.a("[Native] Extra jni can be accessed.", new Object[0]);
    } else {
      x.d("[Native] Extra jni can not be accessed.", new Object[0]);
    }
    this.c.q = str1;
    localObject1 = "-".concat(this.c.q);
    if ((!c.b) && (!this.c.g.contains((CharSequence)localObject1))) {
      this.c.g = this.c.g.concat("-").concat(this.c.q);
    }
    x.a("comInfo.sdkVersion %s", new Object[] { this.c.g });
    this.j = true;
    return;
    x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
    break label737;
    bool = this.h;
    if (bool) {}
    try
    {
      localObject1 = Integer.TYPE;
      localObject3 = Integer.TYPE;
      str1 = this.f;
      str2 = com.tencent.bugly.crashreport.common.info.b.a(this.b, false);
      i2 = 5;
      if (!paramBoolean) {
        break label778;
      }
      i1 = 1;
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        int i2;
        continue;
        int i1 = 5;
      }
    }
    localObject3 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[] { String.class, String.class, localObject1, localObject3 }, new Object[] { str1, str2, Integer.valueOf(i1), Integer.valueOf(1) });
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = Integer.TYPE;
      localObject3 = this.f;
      str1 = com.tencent.bugly.crashreport.common.info.b.a(this.b, false);
      com.tencent.bugly.crashreport.common.info.a.b();
      i1 = com.tencent.bugly.crashreport.common.info.a.I();
      localObject1 = (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[] { String.class, String.class, localObject1 }, new Object[] { localObject3, str1, Integer.valueOf(i1) });
    }
    if (localObject1 != null)
    {
      this.j = true;
      this.c.q = ((String)localObject1);
      localObject1 = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[] { String.class }, new Object[] { localObject1 });
      if (localObject1 != null) {
        l = ((Boolean)localObject1).booleanValue();
      }
      z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(true) });
      i1 = i2;
      if (paramBoolean) {
        i1 = 1;
      }
      z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(i1) });
      return;
    }
    this.i = false;
    this.h = false;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.i) {
      if (!m) {
        return false;
      }
    }
    try
    {
      setNativeInfo(paramInt, paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      if (!x.a(paramString)) {
        paramString.printStackTrace();
      }
      return false;
      m = false;
      return false;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      label37:
      break label37;
    }
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      x.a("[Native] Trying to load so: %s", new Object[] { paramString });
      if (paramBoolean) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      }
      try
      {
        x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
        return true;
      }
      catch (Throwable localThrowable1)
      {
        paramBoolean = true;
      }
      x.d(localThrowable2.getMessage(), new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      paramBoolean = false;
    }
    x.d("[Native] Failed to load so: %s", new Object[] { paramString });
    return paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      startNativeMonitor();
      return;
    }
    finally {}
    c();
  }
  
  private void c()
  {
    label49:
    label60:
    label109:
    try
    {
      if (!this.j)
      {
        x.d("[Native] Native crash report has already unregistered.", new Object[0]);
        return;
      }
    }
    finally {}
    try
    {
      if (unregist() == null) {
        break label60;
      }
      x.a("[Native] Successfully closed native crash report.", new Object[0]);
      this.j = false;
      return;
    }
    catch (Throwable localThrowable1)
    {
      break label49;
    }
    x.c("[Native] Failed to close native crash report.", new Object[0]);
    try
    {
      z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(false) });
      this.j = false;
      x.a("[Native] Successfully closed native crash report.", new Object[0]);
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label109;
    }
    x.c("[Native] Failed to close native crash report.", new Object[0]);
    this.i = false;
    this.h = false;
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
    NativeCrashHandler localNativeCrashHandler = a;
    if (localNativeCrashHandler != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean);
      localNativeCrashHandler.a(999, localStringBuilder.toString());
    }
  }
  
  protected final void a()
  {
    long l1 = z.b();
    long l2 = c.g;
    long l3 = z.b();
    Object localObject1 = new File(this.f);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {}
    for (;;)
    {
      int i3;
      int i2;
      int i4;
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return;
          }
          int i6 = localObject1.length;
          i3 = 0;
          i5 = 0;
          i1 = 0;
          if (i3 < i6)
          {
            Object localObject2 = localObject1[i3];
            long l4 = localObject2.lastModified();
            if (l4 >= l1 - l2)
            {
              i2 = i5;
              i4 = i1;
              if (l4 < l3 + 86400000L) {
                break label209;
              }
            }
            x.a("[Native] Delete record file: %s", new Object[] { localObject2.getAbsolutePath() });
            i5 += 1;
            i2 = i5;
            i4 = i1;
            if (!localObject2.delete()) {
              break label209;
            }
            i4 = i1 + 1;
            i2 = i5;
            break label209;
          }
          x.c("[Native] Number of record files overdue: %d, has deleted: %d", new Object[] { Integer.valueOf(i5), Integer.valueOf(i1) });
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        x.a(localThrowable);
      }
      return;
      label209:
      i3 += 1;
      int i5 = i2;
      int i1 = i4;
    }
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3)
  {
    if ((!this.h) && (!this.i)) {
      return false;
    }
    if (!l) {
      return false;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      if (paramString3 == null) {
        return false;
      }
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
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
      return false;
      l = false;
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      label130:
      break label130;
    }
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash()
  {
    this.d.a(new NativeCrashHandler.1(this));
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
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      return null;
      l = false;
      return null;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label67:
      break label67;
    }
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
  
  public void onStrategyChanged(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean != null) {}
    for (;;)
    {
      try
      {
        if (paramStrategyBean.f != this.j) {
          x.d("server native changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.f) });
        }
        if ((com.tencent.bugly.crashreport.common.strategy.a.a().c().f) && (this.k))
        {
          bool = true;
          if (bool != this.j)
          {
            x.a("native changed to %b", new Object[] { Boolean.valueOf(bool) });
            b(bool);
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2)
  {
    if ((!this.h) && (!this.i)) {
      return false;
    }
    if (!l) {
      return false;
    }
    if (paramString1 != null) {
      if (paramString2 == null) {
        return false;
      }
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
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
      return false;
      l = false;
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      label114:
      break label114;
    }
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  public void removeEmptyNativeRecordFiles()
  {
    b.c(this.f);
  }
  
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
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    return a(14, str);
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
    for (;;)
    {
      try
      {
        c(paramBoolean);
        boolean bool = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
        paramBoolean = bool;
        if (locala != null)
        {
          if ((!bool) || (!locala.c().f)) {
            break label80;
          }
          paramBoolean = true;
        }
        if (paramBoolean != this.j)
        {
          x.a("native changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
          b(paramBoolean);
        }
        return;
      }
      finally {}
      label80:
      paramBoolean = false;
    }
  }
  
  public void startNativeMonitor()
  {
    for (;;)
    {
      String str;
      try
      {
        if ((!this.i) && (!this.h))
        {
          Object localObject1 = "Bugly";
          if (!z.a(this.c.p))
          {
            bool = true;
            if (c.b)
            {
              if (bool)
              {
                localObject1 = this.c.p;
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Bugly");
                ((StringBuilder)localObject1).append("-rqd");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              this.i = a((String)localObject1, bool);
              if ((!this.i) && (!bool)) {
                this.h = a("NativeRQD", false);
              }
            }
            else
            {
              str = this.c.p;
              if (bool) {
                break label286;
              }
              this.c.getClass();
              this.i = a((String)localObject1, bool);
            }
            if (!this.i)
            {
              bool = this.h;
              if (!bool) {
                return;
              }
            }
            a(this.g);
            if (l)
            {
              setNativeAppVersion(this.c.m);
              setNativeAppChannel(this.c.o);
              setNativeAppPackage(this.c.c);
              setNativeUserId(this.c.f());
              setNativeIsAppForeground(this.c.a());
              setNativeLaunchTime(this.c.a);
            }
          }
        }
        else
        {
          a(this.g);
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label286:
      Object localObject3 = str;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean1);
    a(16, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean2);
    a(17, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean3);
    a(18, localStringBuilder.toString());
    testNativeCrash();
  }
  
  protected native String unregist();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler
 * JD-Core Version:    0.7.0.1
 */