package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jj.s.d;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.jj.s.g;
import com.tencent.luggage.wxa.jj.s.h;
import com.tencent.luggage.wxa.qw.lj;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

public final class ae
  implements d
{
  public static final String[] c = { com.tencent.luggage.wxa.rb.d.a(ab.m, "AppBrandWxaPkgManifestRecord") };
  private final com.tencent.luggage.wxa.rb.c d;
  private final ae.a e;
  
  public ae(com.tencent.luggage.wxa.rb.c paramc)
  {
    this.d = paramc;
    this.e = new ae.a(paramc);
  }
  
  private <T> T a(Function0<T> paramFunction0)
  {
    try
    {
      long l = this.d.a(Thread.currentThread().getId());
      paramFunction0 = paramFunction0.invoke();
      this.d.b(l);
      return paramFunction0;
    }
    finally
    {
      paramFunction0 = finally;
      throw paramFunction0;
    }
  }
  
  /* Error */
  private boolean c(ab paramab)
  {
    // Byte code:
    //   0: getstatic 90	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   3: astore 5
    //   5: iconst_0
    //   6: istore 4
    //   8: aload 5
    //   10: ldc 92
    //   12: iconst_4
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 24
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 94
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: ldc 96
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: ldc 98
    //   35: aastore
    //   36: invokestatic 102	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore 5
    //   41: aload_0
    //   42: getfield 39	com/tencent/mm/plugin/appbrand/appcache/ae:d	Lcom/tencent/luggage/wxa/rb/c;
    //   45: astore 6
    //   47: aload_1
    //   48: getfield 105	com/tencent/mm/plugin/appbrand/appcache/ab:b	Ljava/lang/String;
    //   51: astore 7
    //   53: new 107	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   60: astore 8
    //   62: aload 8
    //   64: aload_1
    //   65: getfield 112	com/tencent/mm/plugin/appbrand/appcache/ab:h	I
    //   68: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: ldc 118
    //   76: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 8
    //   82: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 8
    //   87: new 107	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   94: astore 9
    //   96: aload 9
    //   98: aload_1
    //   99: getfield 127	com/tencent/mm/plugin/appbrand/appcache/ab:c	I
    //   102: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 9
    //   108: ldc 118
    //   110: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 6
    //   116: aload 5
    //   118: iconst_3
    //   119: anewarray 16	java/lang/String
    //   122: dup
    //   123: iconst_0
    //   124: aload 7
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload 8
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: aload 9
    //   136: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aastore
    //   140: invokeinterface 130 3 0
    //   145: astore 6
    //   147: iload 4
    //   149: istore_3
    //   150: aload 6
    //   152: ifnull +88 -> 240
    //   155: aconst_null
    //   156: astore 5
    //   158: aload 5
    //   160: astore_1
    //   161: iload 4
    //   163: istore_3
    //   164: aload 6
    //   166: invokeinterface 136 1 0
    //   171: ifeq +69 -> 240
    //   174: aload 5
    //   176: astore_1
    //   177: aload 6
    //   179: iconst_0
    //   180: invokeinterface 140 2 0
    //   185: istore_2
    //   186: iload 4
    //   188: istore_3
    //   189: iload_2
    //   190: ifle +50 -> 240
    //   193: iconst_1
    //   194: istore_3
    //   195: goto +45 -> 240
    //   198: astore 5
    //   200: goto +11 -> 211
    //   203: astore 5
    //   205: aload 5
    //   207: astore_1
    //   208: aload 5
    //   210: athrow
    //   211: aload 6
    //   213: ifnull +24 -> 237
    //   216: aload_1
    //   217: ifnull +13 -> 230
    //   220: aload 6
    //   222: invokeinterface 143 1 0
    //   227: goto +10 -> 237
    //   230: aload 6
    //   232: invokeinterface 143 1 0
    //   237: aload 5
    //   239: athrow
    //   240: aload 6
    //   242: ifnull +10 -> 252
    //   245: aload 6
    //   247: invokeinterface 143 1 0
    //   252: iload_3
    //   253: ireturn
    //   254: astore_1
    //   255: goto -18 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	ae
    //   0	258	1	paramab	ab
    //   185	5	2	i	int
    //   149	104	3	bool1	boolean
    //   6	181	4	bool2	boolean
    //   3	172	5	localObject1	Object
    //   198	1	5	localObject2	Object
    //   203	35	5	localThrowable	java.lang.Throwable
    //   45	201	6	localObject3	Object
    //   51	74	7	str	String
    //   60	70	8	localObject4	Object
    //   94	41	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   164	174	198	finally
    //   177	186	198	finally
    //   208	211	198	finally
    //   164	174	203	java/lang/Throwable
    //   177	186	203	java/lang/Throwable
    //   220	227	254	java/lang/Throwable
  }
  
  private boolean d(ab paramab)
  {
    o.d("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { paramab.b, Integer.valueOf(paramab.h), Integer.valueOf(paramab.c) });
    return this.e.a(paramab);
  }
  
  @Nullable
  public ab a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Object localObject2 = new StringBuilder();
    Object localObject1 = ab.l;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject2).append(localObject1[i]);
      ((StringBuilder)localObject2).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject2).append("1=1");
    if (d.a.b(paramInt2)) {
      paramInt1 = 1;
    }
    com.tencent.luggage.wxa.rb.c localc = this.d;
    boolean bool = af.a(paramVarArgs);
    localObject1 = null;
    if (bool) {
      paramVarArgs = null;
    }
    localObject2 = localc.b("AppBrandWxaPkgManifestRecord", paramVarArgs, ((StringBuilder)localObject2).toString(), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, null, 2);
    if (localObject2 == null) {
      return null;
    }
    paramVarArgs = (String[])localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new ab();
      ((ab)localObject1).a((Cursor)localObject2);
      ((ab)localObject1).b = paramString;
      paramVarArgs = (String[])localObject1;
      if (paramInt1 > 0)
      {
        ((ab)localObject1).c = paramInt1;
        paramVarArgs = (String[])localObject1;
      }
    }
    ((Cursor)localObject2).close();
    return paramVarArgs;
  }
  
  @Nullable
  public ab a(String paramString, int paramInt, String... paramVarArgs)
  {
    boolean bool = af.c(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    String[] arrayOfString;
    if (d.a.a(paramInt))
    {
      localObject1 = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
    }
    for (String str = "version desc";; str = "createTime desc")
    {
      break;
      if (!d.a.b(paramInt)) {
        break label232;
      }
      localObject1 = String.format(Locale.US, "%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" });
      arrayOfString = new String[3];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
      arrayOfString[2] = "1";
    }
    com.tencent.luggage.wxa.rb.c localc = this.d;
    if (af.a(paramVarArgs)) {
      paramVarArgs = null;
    }
    Object localObject1 = localc.b("AppBrandWxaPkgManifestRecord", paramVarArgs, (String)localObject1, arrayOfString, null, null, str);
    if (localObject1 == null) {
      return null;
    }
    paramVarArgs = localObject2;
    if (((Cursor)localObject1).moveToFirst())
    {
      paramVarArgs = new ab();
      paramVarArgs.a((Cursor)localObject1);
      paramVarArgs.b = paramString;
      paramVarArgs.h = paramInt;
    }
    ((Cursor)localObject1).close();
    return paramVarArgs;
    label232:
    paramString = new StringBuilder();
    paramString.append("Illegal pkgType ");
    paramString.append(paramInt);
    paramString = new RuntimeException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<ab> a(int paramInt)
  {
    Object localObject = new StringBuilder("debugType");
    ((StringBuilder)localObject).append(" = ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.d.b("AppBrandWxaPkgManifestRecord", null, (String)localObject, null, null, null, null, 2);
    if (localObject == null) {
      return null;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      ab localab = new ab();
      localab.a((Cursor)localObject);
      localArrayList.add(localab);
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, List<s.h> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (s.h)paramList.next();
        int i = ((s.h)localObject).a;
        localObject = ((s.h)localObject).b;
        String str = new n(paramString1, paramString2, i).toString();
        o.d("MicroMsg.AppBrandWxaPkgStorage", "multiPkg updatePkgInfoList pkgInfoKey:%s,pkgType:%d,codeType:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
        if (paramInt2 == 0) {
          a(str, paramInt2, paramInt1, (String)localObject, null);
        } else {
          a(str, paramInt2, "", (String)localObject, 0L, 0L);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    if (af.c(paramString3))
    {
      o.b("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutPluginCodeInfo withoutLibMd5 null appid:%s,modulename:%s!", new Object[] { paramString1, paramString2 });
      return;
    }
    paramString1 = new n(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      a(paramString1, paramInt2, paramInt1, paramString3, null);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
  }
  
  public void a(List<s.d> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      o.d("MicroMsg.AppBrandWxaPkgStorage", "updatePluginCodeList size:%s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        s.d locald = (s.d)paramList.next();
        String str1 = locald.a;
        String str2 = locald.c;
        int i = locald.b;
        if ((!af.c(str1)) && (!af.c(str2))) {
          a(str1, str2, i);
        }
      }
    }
  }
  
  boolean a(@NonNull lj paramlj, @Nullable com.tencent.luggage.wxa.qt.c paramc)
  {
    if ((paramlj.c >= 0) && (!af.c(paramlj.a)) && (!af.c(paramlj.b)))
    {
      if (paramlj.e > 0)
      {
        int i = this.d.a("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", String.valueOf(0), String.valueOf(paramlj.c) });
        o.d("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramlj.c), Integer.valueOf(i) });
        if (paramc != null) {
          paramc.a = i;
        }
      }
      return a("@LibraryAppId", 0, paramlj.c, paramlj.b, paramlj.a);
    }
    o.b("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramlj.c), paramlj.a, paramlj.b });
    return false;
  }
  
  public boolean a(ab paramab)
  {
    if (d.a.b(paramab.h)) {
      paramab.c = 1;
    }
    return ((Boolean)a(new ae.3(this, paramab))).booleanValue();
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    Locale localLocale = Locale.US;
    if (paramInt2 > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("version=");
      ((StringBuilder)localObject).append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "1=1";
    }
    Object localObject = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), localObject });
    localObject = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", localObject });
    o.d("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return this.d.a("AppBrandWxaPkgManifestRecord", (String)localObject);
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (!d.a.a(paramInt1)) {
      return false;
    }
    o.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    ab localab = a(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1;
    if (localab == null)
    {
      localab = new ab();
      localab.b = paramString1;
      localab.c = paramInt2;
      localab.d = paramString2;
      localab.e = null;
      localab.i = paramString3;
      localab.h = paramInt1;
      bool1 = d(localab);
      o.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localab.c), localab.i, localab.d });
      return bool1;
    }
    String str1 = localab.i;
    String str2 = localab.d;
    if (!af.b(localab.d).equals(paramString2))
    {
      localab.d = paramString2;
      localab.e = null;
      localab.c = paramInt2;
    }
    for (localab.i = paramString3;; localab.i = paramString3)
    {
      paramInt1 = 1;
      break label270;
      if ((af.c(paramString3)) || (paramString3.equals(localab.i))) {
        break;
      }
    }
    paramInt1 = 0;
    label270:
    if (paramInt1 != 0) {
      bool1 = b(localab);
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((paramInt1 != 0) && (bool1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    o.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", new Object[] { Boolean.valueOf(bool2), paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt2), str1, paramString3, str2, paramString2 });
    return (paramInt1 != 0) && (bool1);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, List<s.g> paramList)
  {
    if (!af.c(paramString))
    {
      if (af.a(paramList)) {
        return false;
      }
      if (!d.a.a(paramInt1)) {
        paramInt2 = 1;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append('{');
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        s.g localg = (s.g)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(localg.a);
        ((StringBuilder)localObject1).append("::");
        ((StringBuilder)localObject1).append(localg.b);
      }
      ((StringBuilder)localObject1).append('}');
      o.d("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((StringBuilder)localObject1).toString() });
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramList = (s.g)((Iterator)localObject1).next();
        localObject2 = new n(paramString, paramList.a).toString();
        if (d.a.a(paramInt1)) {
          a((String)localObject2, paramInt1, paramInt2, paramList.b, null);
        } else {
          a((String)localObject2, paramInt1, null, paramList.b, 0L, 0L);
        }
        localObject2 = paramList.g;
        if ((!af.c(paramList.a)) && (!af.c((String)localObject2))) {
          a(paramString, paramList.a, paramInt2, paramInt1, (String)localObject2, 13);
        }
        a(paramString, paramInt2, paramInt1, paramList.a, paramList.h);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (af.c(paramString1))
    {
      o.b("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
      return false;
    }
    o.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (paramInt == 999) {
      paramString1 = "@LibraryAppId";
    }
    ab localab = a(paramString1, 1, paramInt, new String[0]);
    if (localab == null)
    {
      localab = new ab();
      localab.b = paramString1;
      localab.c = 1;
      localab.h = paramInt;
      localab.i = paramString2;
      localab.d = paramString3;
      localab.j = paramLong1;
      localab.k = paramLong2;
      localab.g = af.a();
      d(localab);
      return true;
    }
    int i;
    if ((!af.c(paramString3)) && (!af.c(localab.d)) && (!paramString3.equals(localab.d))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = af.b(paramString2).equals(af.b(localab.i));
    if (i != 0)
    {
      localab.i = paramString2;
      k.i(localab.f);
      localab.f = null;
      localab.g = af.a();
      localab.d = paramString3;
      localab.j = paramLong1;
      localab.k = paramLong2;
      localab.g = af.a();
      b(localab);
      if (af.a(paramString1.split("$"))) {
        a(paramString1, paramInt, 1);
      }
      return true;
    }
    if ((bool ^ true))
    {
      localab.i = paramString2;
      localab.j = paramLong1;
      localab.k = paramLong2;
      b(localab);
    }
    return false;
  }
  
  public boolean a(String paramString, s.f paramf)
  {
    paramf = new ae.1(this, paramString, paramf);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flushWxaAppVersionInfoV2 ");
    localStringBuilder.append(paramString);
    paramString = com.tencent.luggage.wxa.ef.d.a(localStringBuilder.toString(), new ae.2(this, paramf));
    paramString.getClass();
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return a(new n(paramString1, "__PLUGINCODE__").toString(), 0, paramInt, paramString2, null);
    }
    return false;
  }
  
  public boolean b(ab paramab)
  {
    o.d("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { paramab.b, Integer.valueOf(paramab.c), Integer.valueOf(paramab.h) });
    return this.e.c(paramab, ab.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */