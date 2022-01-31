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
  private static a ag = null;
  public boolean A = false;
  public boolean B = true;
  public List<String> C = new ArrayList();
  public boolean D;
  public com.tencent.bugly.crashreport.a E = null;
  public SharedPreferences F;
  private final Context G;
  private String H;
  private String I;
  private String J;
  private String K = "unknown";
  private String L = "unknown";
  private String M = "";
  private String N = null;
  private String O = null;
  private String P = null;
  private String Q = null;
  private long R = -1L;
  private long S = -1L;
  private long T = -1L;
  private String U = null;
  private String V = null;
  private Map<String, PlugInBean> W = null;
  private boolean X = true;
  private String Y = null;
  private String Z = null;
  public final long a = System.currentTimeMillis();
  private final Object aA = new Object();
  private final Object aB = new Object();
  private Boolean aa = null;
  private String ab = null;
  private String ac = null;
  private String ad = null;
  private Map<String, PlugInBean> ae = null;
  private Map<String, PlugInBean> af = null;
  private int ah = -1;
  private int ai = -1;
  private Map<String, String> aj = new HashMap();
  private Map<String, String> ak = new HashMap();
  private Map<String, String> al = new HashMap();
  private boolean am;
  private Boolean an = null;
  private Boolean ao = null;
  private HashMap<String, String> ap = new HashMap();
  private String aq = null;
  private String ar = null;
  private String as = null;
  private String at = null;
  private String au = null;
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
      this.g = b.o();
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
        if (str != null)
        {
          this.Z = str;
          c("APP_ID", this.Z);
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
      if (ag == null) {
        ag = new a(paramContext);
      }
      paramContext = ag;
      return paramContext;
    }
    finally {}
  }
  
  public static a b()
  {
    try
    {
      a locala = ag;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("server key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.ay)
    {
      this.al.put(paramString1, paramString2);
      return;
    }
  }
  
  public final Map<String, String> A()
  {
    synchronized (this.ax)
    {
      if (this.aj.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.aj);
      return localHashMap;
    }
  }
  
  public final void B()
  {
    synchronized (this.ax)
    {
      this.aj.clear();
      return;
    }
  }
  
  public final int C()
  {
    synchronized (this.ax)
    {
      int i1 = this.aj.size();
      return i1;
    }
  }
  
  public final Set<String> D()
  {
    synchronized (this.ax)
    {
      Set localSet = this.aj.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> E()
  {
    synchronized (this.aB)
    {
      if (this.ak.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ak);
      return localHashMap;
    }
  }
  
  public final Map<String, String> F()
  {
    synchronized (this.ay)
    {
      if (this.al.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.al);
      return localHashMap;
    }
  }
  
  public final int G()
  {
    synchronized (this.az)
    {
      int i1 = this.ah;
      return i1;
    }
  }
  
  public final int H()
  {
    return this.ai;
  }
  
  public final Map<String, PlugInBean> I()
  {
    try
    {
      Map localMap = this.ae;
      if (this.af != null) {
        localMap.putAll(this.af);
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
    if (this.aq == null) {
      this.aq = b.q();
    }
    return this.aq;
  }
  
  public final String L()
  {
    if (this.ar == null) {
      this.ar = b.f(this.G);
    }
    return this.ar;
  }
  
  public final String M()
  {
    if (this.as == null) {
      this.as = b.g(this.G);
    }
    return this.as;
  }
  
  public final String N()
  {
    Context localContext = this.G;
    return b.r();
  }
  
  public final String O()
  {
    if (this.at == null) {
      this.at = b.h(this.G);
    }
    return this.at;
  }
  
  public final long P()
  {
    Context localContext = this.G;
    return b.s();
  }
  
  public final boolean Q()
  {
    if (this.an == null)
    {
      this.an = Boolean.valueOf(b.i(this.G));
      x.a("Is it a virtual machine? " + this.an, new Object[0]);
    }
    return this.an.booleanValue();
  }
  
  public final boolean R()
  {
    if (this.ao == null)
    {
      this.ao = Boolean.valueOf(b.j(this.G));
      x.a("Does it has hook frame? " + this.ao, new Object[0]);
    }
    return this.ao.booleanValue();
  }
  
  public final String S()
  {
    if (this.I == null)
    {
      this.I = AppInfo.g(this.G);
      x.a("Beacon channel " + this.I, new Object[0]);
    }
    return this.I;
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.az)
    {
      int i1 = this.ah;
      if (i1 != paramInt)
      {
        this.ah = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.ah) });
      }
      return;
    }
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.aa = paramBoolean;
  }
  
  public final void a(String paramString)
  {
    this.Z = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.ax)
    {
      this.aj.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void a(Map<String, PlugInBean> paramMap)
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
  
  public final void a(boolean paramBoolean)
  {
    this.am = paramBoolean;
    if (this.E != null) {
      this.E.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.am;
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
        if (this.W == null) {
          this.W = new HashMap();
        }
        this.W.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        x.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.aA;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.K = str;
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
    synchronized (this.aB)
    {
      this.ak.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void b(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.af = paramMap;
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
    synchronized (this.av)
    {
      this.H = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.J = paramString;
    synchronized (this.aB)
    {
      this.ak.put("E8", paramString);
      return;
    }
  }
  
  public final String d()
  {
    synchronized (this.av)
    {
      if (this.H == null) {}
      synchronized (this.av)
      {
        this.H = UUID.randomUUID().toString();
        return this.H;
      }
    }
  }
  
  public final void d(String paramString)
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
  
  public final String e()
  {
    if (!z.a(this.e)) {
      return this.e;
    }
    return this.Z;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.M = paramString;
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
    synchronized (this.aA)
    {
      String str = this.K;
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
    //   7: getfield 143	com/tencent/bugly/crashreport/common/info/a:W	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 143	com/tencent/bugly/crashreport/common/info/a:W	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 533 2 0
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
    if (this.J != null) {
      return this.J;
    }
    this.J = (j() + "|" + l() + "|" + m());
    return this.J;
  }
  
  public final void g(String paramString)
  {
    this.Y = paramString;
  }
  
  public final String h()
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
  
  public final String h(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.ax)
    {
      paramString = (String)this.aj.remove(paramString);
      return paramString;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.M;
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
    synchronized (this.ax)
    {
      paramString = (String)this.aj.get(paramString);
      return paramString;
    }
  }
  
  public final String j()
  {
    if (!this.X) {
      return "";
    }
    if (this.N == null)
    {
      Context localContext = this.G;
      this.N = b.d();
    }
    return this.N;
  }
  
  public final String k()
  {
    if (!this.X) {
      return "";
    }
    if ((this.O == null) || (!this.O.contains(":")))
    {
      Context localContext = this.G;
      this.O = b.f();
    }
    return this.O;
  }
  
  public final String l()
  {
    if (!this.X) {
      return "";
    }
    if (this.P == null)
    {
      Context localContext = this.G;
      this.P = b.e();
    }
    return this.P;
  }
  
  public final String m()
  {
    if (!this.X) {
      return "";
    }
    if (this.Q == null) {
      this.Q = b.a(this.G);
    }
    return this.Q;
  }
  
  public final long n()
  {
    if (this.R <= 0L) {
      this.R = b.h();
    }
    return this.R;
  }
  
  public final long o()
  {
    if (this.S <= 0L) {
      this.S = b.j();
    }
    return this.S;
  }
  
  public final long p()
  {
    if (this.T <= 0L) {
      this.T = b.l();
    }
    return this.T;
  }
  
  public final String q()
  {
    if (this.U == null) {
      this.U = b.a(this.G, true);
    }
    return this.U;
  }
  
  public final String r()
  {
    if (this.V == null) {
      this.V = b.e(this.G);
    }
    return this.V;
  }
  
  public final String s()
  {
    try
    {
      Object localObject2 = this.G.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!((Map)localObject2).isEmpty()) {
        synchronized (this.aw)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
              try
              {
                this.ap.put(localEntry1.getKey(), localEntry1.getValue().toString());
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
      Iterator localIterator;
      Map.Entry localEntry2;
      return null;
    }
    catch (Throwable localThrowable1)
    {
      x.a(localThrowable1);
      for (;;)
      {
        if (this.ap.isEmpty()) {
          break label236;
        }
        localStringBuilder = new StringBuilder();
        localIterator = this.ap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry2 = (Map.Entry)localIterator.next();
          localStringBuilder.append("[");
          localStringBuilder.append((String)localEntry2.getKey());
          localStringBuilder.append(",");
          localStringBuilder.append((String)localEntry2.getValue());
          localStringBuilder.append("] ");
        }
      }
      c("SDK_INFO", localStringBuilder.toString());
      return localStringBuilder.toString();
    }
  }
  
  public final String t()
  {
    if (this.au == null) {
      this.au = AppInfo.e(this.G);
    }
    return this.au;
  }
  
  /* Error */
  public final Map<String, PlugInBean> u()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 143	com/tencent/bugly/crashreport/common/info/a:W	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 143	com/tencent/bugly/crashreport/common/info/a:W	Ljava/util/Map;
    //   13: invokeinterface 429 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 179	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 143	com/tencent/bugly/crashreport/common/info/a:W	Ljava/util/Map;
    //   37: invokeinterface 429 1 0
    //   42: invokespecial 623	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 143	com/tencent/bugly/crashreport/common/info/a:W	Ljava/util/Map;
    //   51: invokeinterface 445 2 0
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
    if (this.Y == null) {
      this.Y = b.n();
    }
    return this.Y;
  }
  
  public final Boolean w()
  {
    if (this.aa == null) {
      this.aa = Boolean.valueOf(b.p());
    }
    return this.aa;
  }
  
  public final String x()
  {
    if (this.ab == null)
    {
      this.ab = b.d(this.G);
      x.a("ROM ID: %s", new Object[] { this.ab });
    }
    return this.ab;
  }
  
  public final String y()
  {
    if (this.ac == null)
    {
      this.ac = b.b(this.G);
      x.a("SIM serial number: %s", new Object[] { this.ac });
    }
    return this.ac;
  }
  
  public final String z()
  {
    if (this.ad == null)
    {
      this.ad = b.g();
      x.a("Hardware serial number: %s", new Object[] { this.ad });
    }
    return this.ad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */