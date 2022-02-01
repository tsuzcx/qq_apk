package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
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
  private static a ah = null;
  public boolean A = false;
  public boolean B = false;
  public boolean C = true;
  public List<String> D = new ArrayList();
  public boolean E;
  public com.tencent.bugly.crashreport.a F = null;
  public SharedPreferences G;
  private final Context H;
  private String I;
  private String J;
  private String K;
  private String L = "unknown";
  private String M = "unknown";
  private String N = "";
  private String O = null;
  private String P = null;
  private String Q = null;
  private String R = null;
  private long S = -1L;
  private long T = -1L;
  private long U = -1L;
  private String V = null;
  private String W = null;
  private Map<String, PlugInBean> X = null;
  private boolean Y = true;
  private String Z = null;
  public final long a = System.currentTimeMillis();
  private final Object aA = new Object();
  private final Object aB = new Object();
  private final Object aC = new Object();
  private String aa = null;
  private Boolean ab = null;
  private String ac = null;
  private String ad = null;
  private String ae = null;
  private Map<String, PlugInBean> af = null;
  private Map<String, PlugInBean> ag = null;
  private int ai = -1;
  private int aj = -1;
  private Map<String, String> ak = new HashMap();
  private Map<String, String> al = new HashMap();
  private Map<String, String> am = new HashMap();
  private boolean an = true;
  private Boolean ao = null;
  private Boolean ap = null;
  private HashMap<String, String> aq = new HashMap();
  private String ar = null;
  private String as = null;
  private String at = null;
  private String au = null;
  private String av = null;
  private final Object aw = new Object();
  private final Object ax = new Object();
  private final Object ay = new Object();
  private final Object az = new Object();
  public final byte b;
  public String c;
  public final String d;
  public String e;
  public boolean f = true;
  public String g = "3.2.4";
  public final String h;
  public final String i;
  public final String j;
  public String k;
  public long l;
  public String m = null;
  public String n = null;
  public String o = null;
  public String p = null;
  public String q = null;
  public List<String> r = null;
  public String s = "unknown";
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public long w = 0L;
  public String x = null;
  public String y = null;
  public String z = null;
  
  private a(Context paramContext)
  {
    this.H = z.a(paramContext);
    this.b = 1;
    Object localObject = AppInfo.b(paramContext);
    if (localObject != null) {}
    try
    {
      this.m = ((PackageInfo)localObject).versionName;
      this.x = this.m;
      this.y = Integer.toString(((PackageInfo)localObject).versionCode);
      this.c = AppInfo.a(paramContext);
      this.d = AppInfo.a(Process.myPid());
      this.h = b.o();
      this.i = b.a();
      this.n = AppInfo.c(paramContext);
      this.j = ("Android " + b.b() + ",level " + b.c());
      new StringBuilder().append(this.i).append(";").append(this.j).toString();
      localObject = AppInfo.d(paramContext);
      if (localObject == null) {}
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.r = AppInfo.a((Map)localObject);
        String str = (String)((Map)localObject).get("BUGLY_APPID");
        if (str != null)
        {
          this.aa = str;
          c("APP_ID", this.aa);
        }
        str = (String)((Map)localObject).get("BUGLY_APP_VERSION");
        if (str != null) {
          this.m = str;
        }
        str = (String)((Map)localObject).get("BUGLY_APP_CHANNEL");
        if (str != null) {
          this.o = str;
        }
        str = (String)((Map)localObject).get("BUGLY_ENABLE_DEBUG");
        if (str != null) {
          str.equalsIgnoreCase("true");
        }
        str = (String)((Map)localObject).get("com.tencent.rdm.uuid");
        if (str != null) {
          this.z = str;
        }
        str = (String)((Map)localObject).get("BUGLY_APP_BUILD_NO");
        if (!TextUtils.isEmpty(str)) {
          Integer.parseInt(str);
        }
        ((Map)localObject).get("BUGLY_AREA");
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if (!paramContext.getDatabasePath("bugly_db_").exists())
            {
              this.B = true;
              x.c("App is first time to be installed on the device.", new Object[0]);
            }
            this.G = z.a("BUGLY_COMMON_VALUES", paramContext);
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
  
  public static int I()
  {
    return b.c();
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (ah == null) {
        ah = new a(paramContext);
      }
      paramContext = ah;
      return paramContext;
    }
    finally {}
  }
  
  public static a b()
  {
    try
    {
      a locala = ah;
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
    synchronized (this.az)
    {
      this.am.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void A()
  {
    synchronized (this.ay)
    {
      this.ak.clear();
      return;
    }
  }
  
  public final int B()
  {
    synchronized (this.ay)
    {
      int i1 = this.ak.size();
      return i1;
    }
  }
  
  public final Set<String> C()
  {
    synchronized (this.ay)
    {
      Set localSet = this.ak.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> D()
  {
    synchronized (this.aC)
    {
      if (this.al.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.al);
      return localHashMap;
    }
  }
  
  public final Map<String, String> E()
  {
    synchronized (this.az)
    {
      if (this.am.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.am);
      return localHashMap;
    }
  }
  
  public final int F()
  {
    synchronized (this.aA)
    {
      int i1 = this.ai;
      return i1;
    }
  }
  
  public final int G()
  {
    return this.aj;
  }
  
  public final Map<String, PlugInBean> H()
  {
    try
    {
      Map localMap = this.af;
      if (this.ag != null) {
        localMap.putAll(this.ag);
      }
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String J()
  {
    if (this.ar == null) {
      this.ar = b.q();
    }
    return this.ar;
  }
  
  public final String K()
  {
    if (this.as == null) {
      this.as = b.f(this.H);
    }
    return this.as;
  }
  
  public final String L()
  {
    if (this.at == null) {
      this.at = b.g(this.H);
    }
    return this.at;
  }
  
  public final String M()
  {
    Context localContext = this.H;
    return b.r();
  }
  
  public final String N()
  {
    if (this.au == null) {
      this.au = b.h(this.H);
    }
    return this.au;
  }
  
  public final long O()
  {
    Context localContext = this.H;
    return b.s();
  }
  
  public final boolean P()
  {
    if (this.ao == null)
    {
      this.ao = Boolean.valueOf(b.i(this.H));
      x.a("Is it a virtual machine? " + this.ao, new Object[0]);
    }
    return this.ao.booleanValue();
  }
  
  public final boolean Q()
  {
    if (this.ap == null)
    {
      this.ap = Boolean.valueOf(b.j(this.H));
      x.a("Does it has hook frame? " + this.ap, new Object[0]);
    }
    return this.ap.booleanValue();
  }
  
  public final String R()
  {
    if (this.J == null)
    {
      this.J = AppInfo.g(this.H);
      x.a("Beacon channel " + this.J, new Object[0]);
    }
    return this.J;
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.aA)
    {
      int i1 = this.ai;
      if (i1 != paramInt)
      {
        this.ai = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.ai) });
      }
      return;
    }
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.ab = paramBoolean;
  }
  
  public final void a(String paramString)
  {
    this.aa = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.ay)
    {
      this.ak.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void a(Map<String, PlugInBean> paramMap)
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
  
  public final void a(boolean paramBoolean)
  {
    this.an = paramBoolean;
    if (this.F != null) {
      this.F.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.an;
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
        if (this.X == null) {
          this.X = new HashMap();
        }
        this.X.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        x.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.aB;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.L = str;
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
    synchronized (this.aC)
    {
      this.al.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void b(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.ag = paramMap;
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
    synchronized (this.aw)
    {
      this.I = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.K = paramString;
    synchronized (this.aC)
    {
      this.al.put("E8", paramString);
      return;
    }
  }
  
  public final String d()
  {
    synchronized (this.aw)
    {
      if (this.I == null) {}
      synchronized (this.aw)
      {
        this.I = UUID.randomUUID().toString();
        ??? = this.I;
        return ???;
      }
    }
  }
  
  public final void d(String paramString)
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
  
  public final String e()
  {
    if (!z.a(this.e)) {
      return this.e;
    }
    return this.aa;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.N = paramString;
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
    synchronized (this.aB)
    {
      String str = this.L;
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
    //   7: getfield 148	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 148	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 552 2 0
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
    if (this.K != null) {
      return this.K;
    }
    if (!this.Y) {}
    for (String str = "";; str = this.R)
    {
      this.K = str;
      return this.K;
      if (this.R == null) {
        this.R = b.a(this.H);
      }
    }
  }
  
  public final void g(String paramString)
  {
    this.Z = paramString;
  }
  
  public final String h()
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
  
  public final String h(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.ay)
    {
      paramString = (String)this.ak.remove(paramString);
      return paramString;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.N;
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
    synchronized (this.ay)
    {
      paramString = (String)this.ak.get(paramString);
      return paramString;
    }
  }
  
  public final String j()
  {
    if (!this.Y) {
      return "";
    }
    if (this.O == null)
    {
      Context localContext = this.H;
      this.O = b.d();
    }
    return this.O;
  }
  
  public final String k()
  {
    if (!this.Y) {
      return "";
    }
    if ((this.P == null) || (!this.P.contains(":")))
    {
      Context localContext = this.H;
      this.P = b.f();
    }
    return this.P;
  }
  
  public final String l()
  {
    if (!this.Y) {
      return "";
    }
    if (this.Q == null)
    {
      Context localContext = this.H;
      this.Q = b.e();
    }
    return this.Q;
  }
  
  public final long m()
  {
    if (this.S <= 0L) {
      this.S = b.h();
    }
    return this.S;
  }
  
  public final long n()
  {
    if (this.T <= 0L) {
      this.T = b.j();
    }
    return this.T;
  }
  
  public final long o()
  {
    if (this.U <= 0L) {
      this.U = b.l();
    }
    return this.U;
  }
  
  public final String p()
  {
    if (this.V == null) {
      this.V = b.a(this.H, true);
    }
    return this.V;
  }
  
  public final String q()
  {
    if (this.W == null) {
      this.W = b.e(this.H);
    }
    return this.W;
  }
  
  public final String r()
  {
    try
    {
      Object localObject2 = this.H.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!((Map)localObject2).isEmpty()) {
        synchronized (this.ax)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
              try
              {
                this.aq.put(localEntry1.getKey(), localEntry1.getValue().toString());
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
      while (!this.aq.isEmpty())
      {
        localStringBuilder = new StringBuilder();
        localIterator = this.aq.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localEntry2 = (Map.Entry)localIterator.next();
            localStringBuilder.append("[");
            localStringBuilder.append((String)localEntry2.getKey());
            localStringBuilder.append(",");
            localStringBuilder.append((String)localEntry2.getValue());
            localStringBuilder.append("] ");
            continue;
            break;
          }
        }
        x.c("SDK_INFO = %s", new Object[] { localStringBuilder.toString() });
        c("SDK_INFO", localStringBuilder.toString());
        return localStringBuilder.toString();
      }
      x.c("SDK_INFO is empty", new Object[0]);
    }
  }
  
  public final String s()
  {
    if (this.av == null) {
      this.av = AppInfo.e(this.H);
    }
    return this.av;
  }
  
  /* Error */
  public final Map<String, PlugInBean> t()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 148	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   13: invokeinterface 452 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 184	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 148	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   37: invokeinterface 452 1 0
    //   42: invokespecial 636	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 148	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   51: invokeinterface 466 2 0
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
  
  public final String u()
  {
    if (this.Z == null) {
      this.Z = b.n();
    }
    return this.Z;
  }
  
  public final Boolean v()
  {
    if (this.ab == null) {
      this.ab = Boolean.valueOf(b.p());
    }
    return this.ab;
  }
  
  public final String w()
  {
    if (this.ac == null)
    {
      this.ac = b.d(this.H);
      x.a("ROM ID: %s", new Object[] { this.ac });
    }
    return this.ac;
  }
  
  public final String x()
  {
    if (this.ad == null)
    {
      this.ad = b.b(this.H);
      x.a("SIM serial number: %s", new Object[] { this.ad });
    }
    return this.ad;
  }
  
  public final String y()
  {
    if (this.ae == null)
    {
      this.ae = b.g();
      x.a("Hardware serial number: %s", new Object[] { this.ae });
    }
    return this.ae;
  }
  
  public final Map<String, String> z()
  {
    synchronized (this.ay)
    {
      if (this.ak.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ak);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */