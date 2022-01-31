package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class a
{
  private static a af = null;
  public boolean A = false;
  public boolean B = true;
  public List<String> C = new ArrayList();
  public boolean D;
  public com.tencent.bugly.crashreport.a E = null;
  public SharedPreferences F;
  private final Context G;
  private String H;
  private String I;
  private String J = "unknown";
  private String K = "unknown";
  private String L = "";
  private String M = null;
  private String N = null;
  private String O = null;
  private String P = null;
  private long Q = -1L;
  private long R = -1L;
  private long S = -1L;
  private String T = null;
  private String U = null;
  private Map<String, PlugInBean> V = null;
  private boolean W = true;
  private String X = null;
  private String Y = null;
  private Boolean Z = null;
  public final long a = System.currentTimeMillis();
  private final Object aA = new Object();
  private String aa = null;
  private String ab = null;
  private String ac = null;
  private Map<String, PlugInBean> ad = null;
  private Map<String, PlugInBean> ae = null;
  private int ag = -1;
  private int ah = -1;
  private Map<String, String> ai = new HashMap();
  private Map<String, String> aj = new HashMap();
  private Map<String, String> ak = new HashMap();
  private boolean al;
  private Boolean am = null;
  private Boolean an = null;
  private HashMap<String, String> ao = new HashMap();
  private String ap = null;
  private String aq = null;
  private String ar = null;
  private String as = null;
  private String at = null;
  private final Object au = new Object();
  private final Object av = new Object();
  private final Object aw = new Object();
  private final Object ax = new Object();
  private final Object ay = new Object();
  private final Object az = new Object();
  public final byte b;
  public String c;
  public final String d;
  public String e;
  public boolean f = true;
  public final String g;
  public final String h;
  public final String i;
  public String j;
  public long k;
  public String l = null;
  public String m = null;
  public String n = null;
  public String o = null;
  public String p = null;
  public List<String> q = null;
  public String r = "unknown";
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public String w = null;
  public String x = null;
  public String y = null;
  public boolean z = false;
  
  private a(Context paramContext)
  {
    this.G = z.a(paramContext);
    this.b = 1;
    Object localObject = AppInfo.b(paramContext);
    if (localObject != null) {}
    try
    {
      this.l = ((PackageInfo)localObject).versionName;
      this.w = this.l;
      this.x = Integer.toString(((PackageInfo)localObject).versionCode);
      this.c = AppInfo.a(paramContext);
      this.d = AppInfo.a(Process.myPid());
      this.g = b.l();
      this.h = b.a();
      this.m = AppInfo.c(paramContext);
      this.i = ("Android " + b.b() + ",level " + b.c());
      new StringBuilder().append(this.h).append(";").append(this.i).toString();
      localObject = AppInfo.d(paramContext);
      if (localObject == null) {}
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.q = AppInfo.a((Map)localObject);
        String str = (String)((Map)localObject).get("BUGLY_APPID");
        if (str != null) {
          this.Y = str;
        }
        str = (String)((Map)localObject).get("BUGLY_APP_VERSION");
        if (str != null) {
          this.l = str;
        }
        str = (String)((Map)localObject).get("BUGLY_APP_CHANNEL");
        if (str != null) {
          this.n = str;
        }
        str = (String)((Map)localObject).get("BUGLY_ENABLE_DEBUG");
        if (str != null) {
          str.equalsIgnoreCase("true");
        }
        localObject = (String)((Map)localObject).get("com.tencent.rdm.uuid");
        if (localObject != null) {
          this.y = ((String)localObject);
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if (!paramContext.getDatabasePath("bugly_db_").exists())
            {
              this.A = true;
              x.c("App is first time to be installed on the device.", new Object[0]);
            }
            this.F = z.a("BUGLY_COMMON_VALUES", paramContext);
            x.c("com info create end", new Object[0]);
            return;
            localThrowable1 = localThrowable1;
            if (!x.a(localThrowable1))
            {
              localThrowable1.printStackTrace();
              continue;
              localThrowable2 = localThrowable2;
              if (!x.a(localThrowable2)) {
                localThrowable2.printStackTrace();
              }
            }
          }
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            if (com.tencent.bugly.b.c) {
              localThrowable3.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static int J()
  {
    return b.c();
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (af == null) {
        af = new a(paramContext);
      }
      paramContext = af;
      return paramContext;
    }
    finally {}
  }
  
  public static a b()
  {
    try
    {
      a locala = af;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Map<String, String> A()
  {
    synchronized (this.aw)
    {
      if (this.ai.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ai);
      return localHashMap;
    }
  }
  
  public final void B()
  {
    synchronized (this.aw)
    {
      this.ai.clear();
      return;
    }
  }
  
  public final int C()
  {
    synchronized (this.aw)
    {
      int i1 = this.ai.size();
      return i1;
    }
  }
  
  public final Set<String> D()
  {
    synchronized (this.aw)
    {
      Set localSet = this.ai.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> E()
  {
    synchronized (this.aA)
    {
      if (this.aj.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.aj);
      return localHashMap;
    }
  }
  
  public final Map<String, String> F()
  {
    synchronized (this.ax)
    {
      if (this.ak.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ak);
      return localHashMap;
    }
  }
  
  public final int G()
  {
    synchronized (this.ay)
    {
      int i1 = this.ag;
      return i1;
    }
  }
  
  public final int H()
  {
    return this.ah;
  }
  
  public final Map<String, PlugInBean> I()
  {
    try
    {
      Map localMap = this.ad;
      if (this.ae != null) {
        localMap.putAll(this.ae);
      }
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String K()
  {
    if (this.ap == null) {
      this.ap = b.n();
    }
    return this.ap;
  }
  
  public final String L()
  {
    if (this.aq == null) {
      this.aq = b.i(this.G);
    }
    return this.aq;
  }
  
  public final String M()
  {
    if (this.ar == null) {
      this.ar = b.j(this.G);
    }
    return this.ar;
  }
  
  public final String N()
  {
    Context localContext = this.G;
    return b.o();
  }
  
  public final String O()
  {
    if (this.as == null) {
      this.as = b.k(this.G);
    }
    return this.as;
  }
  
  public final long P()
  {
    Context localContext = this.G;
    return b.p();
  }
  
  public final boolean Q()
  {
    if (this.am == null)
    {
      this.am = Boolean.valueOf(b.l(this.G));
      x.a("Is it a virtual machine? " + this.am, new Object[0]);
    }
    return this.am.booleanValue();
  }
  
  public final boolean R()
  {
    if (this.an == null)
    {
      this.an = Boolean.valueOf(b.m(this.G));
      x.a("Does it has hook frame? " + this.an, new Object[0]);
    }
    return this.an.booleanValue();
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.ay)
    {
      int i1 = this.ag;
      if (i1 != paramInt)
      {
        this.ag = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.ag) });
      }
      return;
    }
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.Z = paramBoolean;
  }
  
  public final void a(String paramString)
  {
    this.Y = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.aw)
    {
      this.ai.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void a(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.ad = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.al = paramBoolean;
    if (this.E != null) {
      this.E.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.al;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (this.V == null) {
          this.V = new HashMap();
        }
        this.V.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        x.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.az;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.J = str;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.aA)
    {
      this.aj.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void b(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.ae = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public final void c()
  {
    synchronized (this.au)
    {
      this.H = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.I = paramString;
    synchronized (this.aA)
    {
      this.aj.put("E8", paramString);
      return;
    }
  }
  
  public final String d()
  {
    if (this.H == null) {}
    synchronized (this.au)
    {
      if (this.H == null) {
        this.H = UUID.randomUUID().toString();
      }
      return this.H;
    }
  }
  
  public final void d(String paramString)
  {
    try
    {
      this.K = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String e()
  {
    if (!z.a(this.e)) {
      return this.e;
    }
    return this.Y;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.L = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String f()
  {
    synchronized (this.az)
    {
      String str = this.J;
      return str;
    }
  }
  
  /* Error */
  public final void f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 142	com/tencent/bugly/crashreport/common/info/a:V	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 142	com/tencent/bugly/crashreport/common/info/a:V	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 521 2 0
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	a
    //   0	37	1	paramString	String
    //   10	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   6	11	32	finally
    //   18	29	32	finally
  }
  
  public final String g()
  {
    if (this.I != null) {
      return this.I;
    }
    this.I = (j() + "|" + l() + "|" + m());
    return this.I;
  }
  
  public final void g(String paramString)
  {
    this.X = paramString;
  }
  
  public final String h()
  {
    try
    {
      String str = this.K;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String h(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.aw)
    {
      paramString = (String)this.ai.remove(paramString);
      return paramString;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.L;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String i(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.aw)
    {
      paramString = (String)this.ai.get(paramString);
      return paramString;
    }
  }
  
  public final String j()
  {
    if (!this.W) {
      return "";
    }
    if (this.M == null) {
      this.M = b.a(this.G);
    }
    return this.M;
  }
  
  public final String k()
  {
    if (!this.W) {
      return "";
    }
    if ((this.N == null) || (!this.N.contains(":"))) {
      this.N = b.d(this.G);
    }
    return this.N;
  }
  
  public final String l()
  {
    if (!this.W) {
      return "";
    }
    if (this.O == null) {
      this.O = b.b(this.G);
    }
    return this.O;
  }
  
  public final String m()
  {
    if (!this.W) {
      return "";
    }
    if (this.P == null) {
      this.P = b.c(this.G);
    }
    return this.P;
  }
  
  public final long n()
  {
    if (this.Q <= 0L) {
      this.Q = b.e();
    }
    return this.Q;
  }
  
  public final long o()
  {
    if (this.R <= 0L) {
      this.R = b.g();
    }
    return this.R;
  }
  
  public final long p()
  {
    if (this.S <= 0L) {
      this.S = b.i();
    }
    return this.S;
  }
  
  public final String q()
  {
    if (this.T == null) {
      this.T = b.a(this.G, true);
    }
    return this.T;
  }
  
  public final String r()
  {
    if (this.U == null) {
      this.U = b.h(this.G);
    }
    return this.U;
  }
  
  public final String s()
  {
    try
    {
      Object localObject3 = this.G.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!((Map)localObject3).isEmpty()) {
        synchronized (this.av)
        {
          localObject3 = ((Map)localObject3).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
              try
              {
                this.ao.put(localEntry.getKey(), localEntry.getValue().toString());
              }
              catch (Throwable localThrowable2)
              {
                x.a(localThrowable2);
              }
            }
          }
        }
      }
      StringBuilder localStringBuilder;
      Object localObject6;
      return null;
    }
    catch (Throwable localThrowable1)
    {
      x.a(localThrowable1);
      for (;;)
      {
        if (this.ao.isEmpty()) {
          break label324;
        }
        localStringBuilder = new StringBuilder();
        ??? = this.ao.entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject6 = (Map.Entry)((Iterator)???).next();
          localStringBuilder.append("[");
          localStringBuilder.append((String)((Map.Entry)localObject6).getKey());
          localStringBuilder.append(",");
          localStringBuilder.append((String)((Map.Entry)localObject6).getValue());
          localStringBuilder.append("] ");
        }
      }
      localObject6 = localStringBuilder.toString();
      if ((z.a("SDK_INFO")) || (z.a((String)localObject6))) {
        x.d("server key&value should not be empty %s %s", new Object[] { "SDK_INFO", (String)localObject6 });
      }
      for (;;)
      {
        return localStringBuilder.toString();
        synchronized (this.ax)
        {
          this.ak.put("SDK_INFO", localObject6);
        }
      }
    }
  }
  
  public final String t()
  {
    if (this.at == null) {
      this.at = AppInfo.e(this.G);
    }
    return this.at;
  }
  
  /* Error */
  public final Map<String, PlugInBean> u()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 142	com/tencent/bugly/crashreport/common/info/a:V	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 142	com/tencent/bugly/crashreport/common/info/a:V	Ljava/util/Map;
    //   13: invokeinterface 413 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 178	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 142	com/tencent/bugly/crashreport/common/info/a:V	Ljava/util/Map;
    //   37: invokeinterface 413 1 0
    //   42: invokespecial 612	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 142	com/tencent/bugly/crashreport/common/info/a:V	Ljava/util/Map;
    //   51: invokeinterface 429 2 0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   18	2	1	i1	int
    //   24	23	2	localObject1	Object
    //   59	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	59	finally
    //   29	56	59	finally
  }
  
  public final String v()
  {
    if (this.X == null) {
      this.X = b.k();
    }
    return this.X;
  }
  
  public final Boolean w()
  {
    if (this.Z == null) {
      this.Z = Boolean.valueOf(b.m());
    }
    return this.Z;
  }
  
  public final String x()
  {
    if (this.aa == null)
    {
      this.aa = b.g(this.G);
      x.a("ROM ID: %s", new Object[] { this.aa });
    }
    return this.aa;
  }
  
  public final String y()
  {
    if (this.ab == null)
    {
      this.ab = b.e(this.G);
      x.a("SIM serial number: %s", new Object[] { this.ab });
    }
    return this.ab;
  }
  
  public final String z()
  {
    if (this.ac == null)
    {
      this.ac = b.d();
      x.a("Hardware serial number: %s", new Object[] { this.ac });
    }
    return this.ac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */