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
  private static a ai = null;
  public String A = "";
  public boolean B = false;
  public boolean C = false;
  public boolean D = true;
  public List<String> E = new ArrayList();
  public boolean F;
  public com.tencent.bugly.crashreport.a G = null;
  public SharedPreferences H;
  private final Context I;
  private String J;
  private String K;
  private String L;
  private String M = "unknown";
  private String N = "unknown";
  private String O = "";
  private String P = null;
  private String Q = null;
  private String R = null;
  private String S = null;
  private long T = -1L;
  private long U = -1L;
  private long V = -1L;
  private String W = null;
  private String X = null;
  private Map<String, PlugInBean> Y = null;
  private boolean Z = true;
  public final long a = System.currentTimeMillis();
  private final Object aA = new Object();
  private final Object aB = new Object();
  private final Object aC = new Object();
  private final Object aD = new Object();
  private String aa = null;
  private String ab = null;
  private Boolean ac = null;
  private String ad = null;
  private String ae = null;
  private String af = null;
  private Map<String, PlugInBean> ag = null;
  private Map<String, PlugInBean> ah = null;
  private int aj = -1;
  private int ak = -1;
  private Map<String, String> al = new HashMap();
  private Map<String, String> am = new HashMap();
  private Map<String, String> an = new HashMap();
  private boolean ao = true;
  private Boolean ap = null;
  private Boolean aq = null;
  private HashMap<String, String> ar = new HashMap();
  private String as = null;
  private String at = null;
  private String au = null;
  private String av = null;
  private String aw = null;
  private final Object ax = new Object();
  private final Object ay = new Object();
  private final Object az = new Object();
  public final byte b;
  public String c;
  public final String d;
  public String e;
  public boolean f = true;
  public String g = "3.1.7";
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
    this.I = z.a(paramContext);
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
          this.ab = str;
          c("APP_ID", this.ab);
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
        localObject = (String)((Map)localObject).get("BUGLY_AREA");
        if (localObject != null) {
          this.A = ((String)localObject);
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
              this.C = true;
              x.c("App is first time to be installed on the device.", new Object[0]);
            }
            this.H = z.a("BUGLY_COMMON_VALUES", paramContext);
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
      if (ai == null) {
        ai = new a(paramContext);
      }
      paramContext = ai;
      return paramContext;
    }
    finally {}
  }
  
  public static a b()
  {
    try
    {
      a locala = ai;
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
    synchronized (this.aA)
    {
      this.an.put(paramString1, paramString2);
      return;
    }
  }
  
  public final Map<String, String> A()
  {
    synchronized (this.az)
    {
      if (this.al.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.al);
      return localHashMap;
    }
  }
  
  public final void B()
  {
    synchronized (this.az)
    {
      this.al.clear();
      return;
    }
  }
  
  public final int C()
  {
    synchronized (this.az)
    {
      int i1 = this.al.size();
      return i1;
    }
  }
  
  public final Set<String> D()
  {
    synchronized (this.az)
    {
      Set localSet = this.al.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> E()
  {
    synchronized (this.aD)
    {
      if (this.am.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.am);
      return localHashMap;
    }
  }
  
  public final Map<String, String> F()
  {
    synchronized (this.aA)
    {
      if (this.an.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.an);
      return localHashMap;
    }
  }
  
  public final int G()
  {
    synchronized (this.aB)
    {
      int i1 = this.aj;
      return i1;
    }
  }
  
  public final int H()
  {
    return this.ak;
  }
  
  public final Map<String, PlugInBean> I()
  {
    try
    {
      Map localMap = this.ag;
      if (this.ah != null) {
        localMap.putAll(this.ah);
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
    if (this.as == null) {
      this.as = b.q();
    }
    return this.as;
  }
  
  public final String L()
  {
    if (this.at == null) {
      this.at = b.f(this.I);
    }
    return this.at;
  }
  
  public final String M()
  {
    if (this.au == null) {
      this.au = b.g(this.I);
    }
    return this.au;
  }
  
  public final String N()
  {
    Context localContext = this.I;
    return b.r();
  }
  
  public final String O()
  {
    if (this.av == null) {
      this.av = b.h(this.I);
    }
    return this.av;
  }
  
  public final long P()
  {
    Context localContext = this.I;
    return b.s();
  }
  
  public final boolean Q()
  {
    if (this.ap == null)
    {
      this.ap = Boolean.valueOf(b.i(this.I));
      x.a("Is it a virtual machine? " + this.ap, new Object[0]);
    }
    return this.ap.booleanValue();
  }
  
  public final boolean R()
  {
    if (this.aq == null)
    {
      this.aq = Boolean.valueOf(b.j(this.I));
      x.a("Does it has hook frame? " + this.aq, new Object[0]);
    }
    return this.aq.booleanValue();
  }
  
  public final String S()
  {
    if (this.K == null)
    {
      this.K = AppInfo.g(this.I);
      x.a("Beacon channel " + this.K, new Object[0]);
    }
    return this.K;
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.aB)
    {
      int i1 = this.aj;
      if (i1 != paramInt)
      {
        this.aj = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.aj) });
      }
      return;
    }
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
  
  public final void a(String paramString)
  {
    this.ab = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.az)
    {
      this.al.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void a(Map<String, PlugInBean> paramMap)
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
  
  public final void a(boolean paramBoolean)
  {
    this.ao = paramBoolean;
    if (this.G != null) {
      this.G.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.ao;
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
        if (this.Y == null) {
          this.Y = new HashMap();
        }
        this.Y.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        x.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.aC;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.M = str;
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
    synchronized (this.aD)
    {
      this.am.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void b(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.ah = paramMap;
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
    synchronized (this.ax)
    {
      this.J = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.L = paramString;
    synchronized (this.aD)
    {
      this.am.put("E8", paramString);
      return;
    }
  }
  
  public final String d()
  {
    synchronized (this.ax)
    {
      if (this.J == null) {}
      synchronized (this.ax)
      {
        this.J = UUID.randomUUID().toString();
        ??? = this.J;
        return ???;
      }
    }
  }
  
  public final void d(String paramString)
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
  
  public final String e()
  {
    if (!z.a(this.e)) {
      return this.e;
    }
    return this.ab;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.O = paramString;
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
    synchronized (this.aC)
    {
      String str = this.M;
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
    //   7: getfield 149	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 149	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 555 2 0
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
    if (this.L != null) {
      return this.L;
    }
    this.L = m();
    return this.L;
  }
  
  public final void g(String paramString)
  {
    this.aa = paramString;
  }
  
  public final String h()
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
  
  public final String h(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.az)
    {
      paramString = (String)this.al.remove(paramString);
      return paramString;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.O;
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
    synchronized (this.az)
    {
      paramString = (String)this.al.get(paramString);
      return paramString;
    }
  }
  
  public final String j()
  {
    if (!this.Z) {
      return "";
    }
    if (this.P == null)
    {
      Context localContext = this.I;
      this.P = b.d();
    }
    return this.P;
  }
  
  public final String k()
  {
    if (!this.Z) {
      return "";
    }
    if ((this.Q == null) || (!this.Q.contains(":")))
    {
      Context localContext = this.I;
      this.Q = b.f();
    }
    return this.Q;
  }
  
  public final String l()
  {
    if (!this.Z) {
      return "";
    }
    if (this.R == null)
    {
      Context localContext = this.I;
      this.R = b.e();
    }
    return this.R;
  }
  
  public final String m()
  {
    if (!this.Z) {
      return "";
    }
    if (this.S == null) {
      this.S = b.a(this.I);
    }
    return this.S;
  }
  
  public final long n()
  {
    if (this.T <= 0L) {
      this.T = b.h();
    }
    return this.T;
  }
  
  public final long o()
  {
    if (this.U <= 0L) {
      this.U = b.j();
    }
    return this.U;
  }
  
  public final long p()
  {
    if (this.V <= 0L) {
      this.V = b.l();
    }
    return this.V;
  }
  
  public final String q()
  {
    if (this.W == null) {
      this.W = b.a(this.I, true);
    }
    return this.W;
  }
  
  public final String r()
  {
    if (this.X == null) {
      this.X = b.e(this.I);
    }
    return this.X;
  }
  
  public final String s()
  {
    try
    {
      Object localObject2 = this.I.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!((Map)localObject2).isEmpty()) {
        synchronized (this.ay)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
              try
              {
                this.ar.put(localEntry1.getKey(), localEntry1.getValue().toString());
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
        if (this.ar.isEmpty()) {
          break label236;
        }
        localStringBuilder = new StringBuilder();
        localIterator = this.ar.entrySet().iterator();
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
    if (this.aw == null) {
      this.aw = AppInfo.e(this.I);
    }
    return this.aw;
  }
  
  /* Error */
  public final Map<String, PlugInBean> u()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 149	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   13: invokeinterface 453 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 185	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 149	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   37: invokeinterface 453 1 0
    //   42: invokespecial 637	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 149	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   51: invokeinterface 469 2 0
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
    if (this.aa == null) {
      this.aa = b.n();
    }
    return this.aa;
  }
  
  public final Boolean w()
  {
    if (this.ac == null) {
      this.ac = Boolean.valueOf(b.p());
    }
    return this.ac;
  }
  
  public final String x()
  {
    if (this.ad == null)
    {
      this.ad = b.d(this.I);
      x.a("ROM ID: %s", new Object[] { this.ad });
    }
    return this.ad;
  }
  
  public final String y()
  {
    if (this.ae == null)
    {
      this.ae = b.b(this.I);
      x.a("SIM serial number: %s", new Object[] { this.ae });
    }
    return this.ae;
  }
  
  public final String z()
  {
    if (this.af == null)
    {
      this.af = b.g();
      x.a("Hardware serial number: %s", new Object[] { this.af });
    }
    return this.af;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */