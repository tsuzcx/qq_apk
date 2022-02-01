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
  private static a ah;
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
    PackageInfo localPackageInfo = AppInfo.b(paramContext);
    if (localPackageInfo != null) {
      try
      {
        this.m = localPackageInfo.versionName;
        this.x = this.m;
        this.y = Integer.toString(localPackageInfo.versionCode);
      }
      catch (Throwable localThrowable1)
      {
        if (!x.a(localThrowable1)) {
          localThrowable1.printStackTrace();
        }
      }
    }
    this.c = AppInfo.a(paramContext);
    this.d = AppInfo.a(Process.myPid());
    this.h = b.o();
    this.i = b.a();
    this.n = AppInfo.c(paramContext);
    Object localObject = new StringBuilder("Android ");
    ((StringBuilder)localObject).append(b.b());
    ((StringBuilder)localObject).append(",level ");
    ((StringBuilder)localObject).append(b.c());
    this.j = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).toString();
    localObject = AppInfo.d(paramContext);
    if (localObject != null) {
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
        if (!x.a(localThrowable2)) {
          localThrowable2.printStackTrace();
        }
      }
    }
    try
    {
      if (!paramContext.getDatabasePath("bugly_db_").exists())
      {
        this.B = true;
        x.c("App is first time to be installed on the device.", new Object[0]);
      }
    }
    catch (Throwable localThrowable3)
    {
      if (com.tencent.bugly.b.c) {
        localThrowable3.printStackTrace();
      }
    }
    this.G = z.a("BUGLY_COMMON_VALUES", paramContext);
    x.c("com info create end", new Object[0]);
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
    if ((!z.a(paramString1)) && (!z.a(paramString2))) {
      synchronized (this.az)
      {
        this.am.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    x.d("server key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
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
      StringBuilder localStringBuilder = new StringBuilder("Is it a virtual machine? ");
      localStringBuilder.append(this.ao);
      x.a(localStringBuilder.toString(), new Object[0]);
    }
    return this.ao.booleanValue();
  }
  
  public final boolean Q()
  {
    if (this.ap == null)
    {
      this.ap = Boolean.valueOf(b.j(this.H));
      StringBuilder localStringBuilder = new StringBuilder("Does it has hook frame? ");
      localStringBuilder.append(this.ap);
      x.a(localStringBuilder.toString(), new Object[0]);
    }
    return this.ap.booleanValue();
  }
  
  public final String R()
  {
    if (this.J == null)
    {
      this.J = AppInfo.g(this.H);
      StringBuilder localStringBuilder = new StringBuilder("Beacon channel ");
      localStringBuilder.append(this.J);
      x.a(localStringBuilder.toString(), new Object[0]);
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
    if ((!z.a(paramString1)) && (!z.a(paramString2))) {
      synchronized (this.ay)
      {
        this.ak.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    x.d("key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
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
    com.tencent.bugly.crashreport.a locala = this.F;
    if (locala != null) {
      locala.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.an;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      try
      {
        if (this.X == null) {
          this.X = new HashMap();
        }
        this.X.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        paramString2 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString3);
        x.a("add %s %s %s", new Object[] { paramString1, paramString2, localStringBuilder.toString() });
        return true;
      }
      finally {}
    }
    return false;
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
      paramString = new StringBuilder();
      paramString.append(str);
      this.L = paramString.toString();
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
    if ((!z.a(paramString1)) && (!z.a(paramString2))) {
      synchronized (this.aC)
      {
        this.al.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    x.d("key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
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
      if (this.I == null) {
        synchronized (this.aw)
        {
          this.I = UUID.randomUUID().toString();
        }
      }
      ??? = this.I;
      return ???;
    }
  }
  
  public final void d(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      this.M = localStringBuilder.toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      this.N = localStringBuilder.toString();
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
  
  public final void f(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (this.X != null)
        {
          this.X.remove(paramString);
          return;
        }
      }
      finally {}
    }
  }
  
  public final String g()
  {
    String str = this.K;
    if (str != null) {
      return str;
    }
    if (!this.Y)
    {
      str = "";
    }
    else
    {
      if (this.R == null) {
        this.R = b.a(this.H);
      }
      str = this.R;
    }
    this.K = str;
    return this.K;
  }
  
  public final void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    this.Z = localStringBuilder.toString();
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      x.d("key should not be empty %s", new Object[] { ((StringBuilder)???).toString() });
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      x.d("key should not be empty %s", new Object[] { ((StringBuilder)???).toString() });
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
    Object localObject = this.P;
    if ((localObject == null) || (!((String)localObject).contains(":")))
    {
      localObject = this.H;
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
          while (((Iterator)localObject2).hasNext())
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
      StringBuilder localStringBuilder;
      Iterator localIterator;
      Map.Entry localEntry2;
      return null;
    }
    catch (Throwable localThrowable1)
    {
      x.a(localThrowable1);
      if (!this.aq.isEmpty())
      {
        localStringBuilder = new StringBuilder();
        localIterator = this.aq.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry2 = (Map.Entry)localIterator.next();
          localStringBuilder.append("[");
          localStringBuilder.append((String)localEntry2.getKey());
          localStringBuilder.append(",");
          localStringBuilder.append((String)localEntry2.getValue());
          localStringBuilder.append("] ");
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
  
  public final Map<String, PlugInBean> t()
  {
    try
    {
      if ((this.X != null) && (this.X.size() > 0))
      {
        HashMap localHashMap = new HashMap(this.X.size());
        localHashMap.putAll(this.X);
        return localHashMap;
      }
      return null;
    }
    finally {}
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.d(this.H));
      this.ac = localStringBuilder.toString();
      x.a("ROM ID: %s", new Object[] { this.ac });
    }
    return this.ac;
  }
  
  public final String x()
  {
    if (this.ad == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.b(this.H));
      this.ad = localStringBuilder.toString();
      x.a("SIM serial number: %s", new Object[] { this.ad });
    }
    return this.ad;
  }
  
  public final String y()
  {
    if (this.ae == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.g());
      this.ae = localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */