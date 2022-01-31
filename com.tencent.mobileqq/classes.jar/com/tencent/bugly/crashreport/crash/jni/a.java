package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
  implements NativeExceptionHandler
{
  private final Context a;
  private final com.tencent.bugly.crashreport.crash.b b;
  private final com.tencent.bugly.crashreport.common.info.a c;
  private final com.tencent.bugly.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    x.a("Native Crash Happen v1", new Object[0]);
    handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
  {
    x.a("Native Crash Happen v2", new Object[0]);
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        str = b.a(paramString3);
        paramString6 = "UNKNOWN";
        if (paramInt3 > 0)
        {
          paramString1 = paramString1 + "(" + paramString5 + ")";
          paramString3 = "KERNEL";
          paramString5 = paramString6;
          localObject2 = new HashMap();
          if (paramArrayOfString == null) {
            break label265;
          }
          paramInt1 = 0;
          if (paramInt1 >= paramArrayOfString.length) {
            break label275;
          }
          paramString6 = paramArrayOfString[paramInt1];
          if (paramString6 == null) {
            break label933;
          }
          x.a("Extra message[%d]: %s", new Object[] { Integer.valueOf(paramInt1), paramString6 });
          localObject1 = paramString6.split("=");
          if (localObject1.length == 2)
          {
            ((Map)localObject2).put(localObject1[0], localObject1[1]);
            break label933;
          }
        }
        else
        {
          if (paramInt4 > 0)
          {
            paramString3 = this.a;
            paramString6 = AppInfo.a(paramInt4);
          }
          if (paramString6.equals(String.valueOf(paramInt4))) {
            break label922;
          }
          paramString6 = paramString6 + "(" + paramInt4 + ")";
          paramString3 = paramString5;
          paramString5 = paramString6;
          continue;
        }
        x.d("bad extraMsg %s", new Object[] { paramString6 });
      }
      catch (Throwable paramString1)
      {
        if (!x.a(paramString1)) {
          paramString1.printStackTrace();
        }
        return;
      }
      label265:
      x.c("not found extraMsg", new Object[0]);
      label275:
      boolean bool2 = false;
      paramString6 = (String)((Map)localObject2).get("HasPendingException");
      boolean bool1 = bool2;
      if (paramString6 != null)
      {
        bool1 = bool2;
        if (paramString6.equals("true"))
        {
          x.a("Native crash happened with a Java pending exception.", new Object[0]);
          bool1 = true;
        }
      }
      Object localObject1 = (String)((Map)localObject2).get("ExceptionProcessName");
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        localObject1 = this.c.d;
      }
      for (;;)
      {
        paramArrayOfString = (String)((Map)localObject2).get("ExceptionThreadName");
        if ((paramArrayOfString != null) && (paramArrayOfString.length() != 0)) {
          break;
        }
        paramString6 = Thread.currentThread();
        paramString6 = paramString6.getName() + "(" + paramString6.getId() + ")";
        paramLong2 /= 1000L;
        paramArrayOfString = (String)((Map)localObject2).get("SysLogPath");
        localObject2 = (String)((Map)localObject2).get("JniLogPath");
        if (!this.d.b()) {
          x.d("no remote but still store!", new Object[0]);
        }
        if ((this.d.c().g) || (!this.d.b())) {
          break label739;
        }
        x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
        com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", z.a(), (String)localObject1, paramString6, paramString1 + "\n" + paramString2 + "\n" + str, null);
        z.b(paramString4);
        return;
        x.c("Name of crash process: %s", new Object[] { localObject1 });
      }
      x.c("Name of crash thread: %s", new Object[] { paramArrayOfString });
      paramString6 = Thread.getAllStackTraces().keySet().iterator();
      while (paramString6.hasNext())
      {
        Thread localThread = (Thread)paramString6.next();
        if (localThread.getName().equals(paramArrayOfString)) {
          paramArrayOfString = paramArrayOfString + "(" + localThread.getId() + ")";
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramString6 = paramArrayOfString;
        if (paramInt1 != 0) {
          break;
        }
        paramString6 = paramArrayOfString + "(" + paramInt2 + ")";
        break;
        label739:
        paramString3 = packageCrashDatas((String)localObject1, paramString6, paramLong2 + 1000L * paramLong1, paramString1, paramString2, str, paramString3, paramString5, paramString4, paramArrayOfString, (String)localObject2, paramString7, null, null, true, bool1);
        if (paramString3 == null)
        {
          x.e("pkg crash datas fail!", new Object[0]);
          return;
        }
        com.tencent.bugly.crashreport.crash.b.a("NATIVE_CRASH", z.a(), (String)localObject1, paramString6, paramString1 + "\n" + paramString2 + "\n" + str, paramString3);
        if (!this.b.b(paramString3)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramString1 = null;
          paramString2 = NativeCrashHandler.getInstance();
          if (paramString2 != null) {
            paramString1 = paramString2.getDumpFilePath();
          }
          b.a(true, paramString1);
          if (paramInt1 != 0) {
            this.b.a(paramString3, 3000L, true);
          }
          this.b.c(paramString3);
          return;
        }
      }
      label922:
      paramString3 = paramString5;
      paramString5 = paramString6;
      continue;
      label933:
      paramInt1 += 1;
    }
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = c.a().h();
    if (paramBoolean2) {
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.b = 1;
    localCrashDetailBean.e = this.c.g();
    localCrashDetailBean.f = this.c.m;
    localCrashDetailBean.g = this.c.v();
    localCrashDetailBean.m = this.c.f();
    localCrashDetailBean.n = paramString3;
    if (paramBoolean2)
    {
      paramString3 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
      localCrashDetailBean.o = paramString3;
      localCrashDetailBean.p = paramString4;
      paramString3 = paramString5;
      if (paramString5 == null) {
        paramString3 = "";
      }
      localCrashDetailBean.q = paramString3;
      localCrashDetailBean.r = paramLong;
      localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
      localCrashDetailBean.A = paramString1;
      localCrashDetailBean.B = paramString2;
      localCrashDetailBean.I = this.c.x();
      localCrashDetailBean.h = this.c.u();
      localCrashDetailBean.i = this.c.I();
      localCrashDetailBean.v = paramString8;
      paramString2 = null;
      paramString3 = NativeCrashHandler.getInstance();
      if (paramString3 != null) {
        paramString2 = paramString3.getDumpFilePath();
      }
      paramString3 = b.a(paramString2, paramString8);
      if (!z.a(paramString3)) {
        localCrashDetailBean.U = paramString3;
      }
      localCrashDetailBean.V = b.b(paramString2);
      localCrashDetailBean.w = b.a(paramString9, c.e, c.h, c.m);
      localCrashDetailBean.x = b.a(paramString10, c.e, null, true);
      localCrashDetailBean.J = paramString7;
      localCrashDetailBean.K = paramString6;
      localCrashDetailBean.L = paramString11;
      localCrashDetailBean.F = this.c.o();
      localCrashDetailBean.G = this.c.n();
      localCrashDetailBean.H = this.c.p();
      if (!paramBoolean1) {
        break label729;
      }
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
      if (localCrashDetailBean.w == null) {
        localCrashDetailBean.w = z.a(this.a, c.e, c.h);
      }
      localCrashDetailBean.y = y.a();
      localCrashDetailBean.M = this.c.a;
      localCrashDetailBean.N = this.c.a();
      localCrashDetailBean.P = this.c.G();
      localCrashDetailBean.Q = this.c.H();
      localCrashDetailBean.R = this.c.A();
      localCrashDetailBean.S = this.c.F();
      localCrashDetailBean.z = z.a(c.f, false);
      int i = localCrashDetailBean.q.indexOf("java:\n");
      if (i > 0)
      {
        i += "java:\n".length();
        if (i < localCrashDetailBean.q.length())
        {
          paramString2 = localCrashDetailBean.q.substring(i, localCrashDetailBean.q.length() - 1);
          if ((paramString2.length() > 0) && (localCrashDetailBean.z.containsKey(localCrashDetailBean.B)))
          {
            paramString3 = (String)localCrashDetailBean.z.get(localCrashDetailBean.B);
            int j = paramString3.indexOf(paramString2);
            if (j > 0)
            {
              paramString2 = paramString3.substring(j);
              localCrashDetailBean.z.put(localCrashDetailBean.B, paramString2);
              localCrashDetailBean.q = localCrashDetailBean.q.substring(0, i);
              localCrashDetailBean.q += paramString2;
            }
          }
        }
      }
      if (paramString1 == null) {
        localCrashDetailBean.A = this.c.d;
      }
      this.b.d(localCrashDetailBean);
    }
    label729:
    do
    {
      return localCrashDetailBean;
      paramString3 = "";
      break;
      localCrashDetailBean.C = -1L;
      localCrashDetailBean.D = -1L;
      localCrashDetailBean.E = -1L;
      if (localCrashDetailBean.w == null) {
        localCrashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
      }
      localCrashDetailBean.M = -1L;
      localCrashDetailBean.P = -1;
      localCrashDetailBean.Q = -1;
      localCrashDetailBean.R = paramMap;
      localCrashDetailBean.S = this.c.F();
      localCrashDetailBean.z = null;
      if (paramString1 == null) {
        localCrashDetailBean.A = "unknown(record)";
      }
    } while (paramArrayOfByte == null);
    localCrashDetailBean.y = paramArrayOfByte;
    return localCrashDetailBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.a
 * JD-Core Version:    0.7.0.1
 */