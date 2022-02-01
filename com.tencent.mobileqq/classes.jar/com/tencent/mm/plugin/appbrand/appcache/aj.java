package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "mergeNewComingPkgList", "_pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class aj
  implements h
{
  public static final aj.a a = new aj.a(null);
  private final String b;
  private final af c;
  private ArrayMap<String, ModulePkgInfo> d;
  private final ConcurrentHashMap<String, v> e;
  private final ConcurrentHashMap<String, h.a> f;
  private boolean g;
  private volatile boolean h;
  private final ReentrantReadWriteLock i;
  
  public aj(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    this.b = paramd.aa();
    paramd = paramd.a(com.tencent.luggage.wxa.do.d.class, false);
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    paramd = ((com.tencent.luggage.wxa.do.d)paramd).S;
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    this.c = paramd;
    this.e = new ConcurrentHashMap();
    this.f = new ConcurrentHashMap(100);
    this.i = new ReentrantReadWriteLock();
  }
  
  @JvmStatic
  @Nullable
  public static final aj a(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    return a.a(paramd);
  }
  
  private final h.a a(@NotNull v.a parama, v paramv)
  {
    h.a locala = new h.a();
    locala.g = paramv;
    locala.h = paramv.b();
    locala.i = parama.b;
    locala.j = parama.c;
    locala.k = parama.d;
    return locala;
  }
  
  private final v a(String paramString, Function0<v> paramFunction0)
  {
    Object localObject = (v)this.e.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    paramFunction0 = (v)paramFunction0.invoke();
    if (paramFunction0 != null)
    {
      paramFunction0.e();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guardedObtainPkgInstance, appId:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", name:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", pkgInnerVersion:");
      ((StringBuilder)localObject).append(paramFunction0.d());
      o.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", ((StringBuilder)localObject).toString());
      ((Map)this.e).put(paramString, paramFunction0);
      return paramFunction0;
    }
    return null;
  }
  
  private final InputStream a(@NotNull h.a parama)
  {
    return parama.g.c(parama.i);
  }
  
  private final <T> T a(Function0<? extends T> paramFunction0)
  {
    Object localObject = this.i;
    ReentrantReadWriteLock.ReadLock localReadLock = ((ReentrantReadWriteLock)localObject).readLock();
    int j = ((ReentrantReadWriteLock)localObject).getWriteHoldCount();
    int n = 0;
    int m = 0;
    if (j == 0) {
      j = ((ReentrantReadWriteLock)localObject).getReadHoldCount();
    } else {
      j = 0;
    }
    int k = 0;
    while (k < j)
    {
      localReadLock.unlock();
      k += 1;
    }
    localObject = ((ReentrantReadWriteLock)localObject).writeLock();
    ((ReentrantReadWriteLock.WriteLock)localObject).lock();
    try
    {
      paramFunction0 = paramFunction0.invoke();
      k = m;
      while (k < j)
      {
        localReadLock.lock();
        k += 1;
      }
      ((ReentrantReadWriteLock.WriteLock)localObject).unlock();
      return paramFunction0;
    }
    finally
    {
      k = n;
      while (k < j)
      {
        localReadLock.lock();
        k += 1;
      }
      ((ReentrantReadWriteLock.WriteLock)localObject).unlock();
    }
    for (;;)
    {
      throw paramFunction0;
    }
  }
  
  private final void a(ModulePkgInfo paramModulePkgInfo)
  {
    Object localObject1 = paramModulePkgInfo.name;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "module.name");
    localObject1 = a((String)localObject1, (Function0)new aj.e(paramModulePkgInfo));
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Function1 localFunction1 = (Function1)new aj.d(this);
    Map localMap = (Map)this.f;
    String str = paramModulePkgInfo.name;
    Intrinsics.checkExpressionValueIsNotNull(str, "module.name");
    Object localObject2 = new h.a();
    ((h.a)localObject2).g = ((v)localObject1);
    ((h.a)localObject2).h = ((v)localObject1).b();
    ((h.a)localObject2).i = paramModulePkgInfo.name;
    localFunction1.invoke(localObject2);
    localMap.put(str, localObject2);
    paramModulePkgInfo = ((v)localObject1).f().iterator();
    while (paramModulePkgInfo.hasNext())
    {
      localObject2 = (v.a)paramModulePkgInfo.next();
      localMap = (Map)this.f;
      str = ((v.a)localObject2).b;
      Intrinsics.checkExpressionValueIsNotNull(str, "info.fileName");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "info");
      localObject2 = a((v.a)localObject2, (v)localObject1);
      localFunction1.invoke(localObject2);
      localMap.put(str, localObject2);
    }
  }
  
  private final void a(String paramString, WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    Object localObject1 = a.a(paramString, paramWxaPluginPkgInfo);
    if (this.f.get(localObject1) != null) {
      return;
    }
    paramString = paramWxaPluginPkgInfo.provider;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "plugin.provider");
    v localv = a(paramString, (Function0)new aj.g(paramWxaPluginPkgInfo));
    if (localv == null) {
      Intrinsics.throwNpe();
    }
    Function1 localFunction1 = (Function1)new aj.f(paramWxaPluginPkgInfo);
    paramString = (Map)this.f;
    Object localObject2 = new h.a();
    ((h.a)localObject2).g = localv;
    ((h.a)localObject2).h = localv.b();
    localFunction1.invoke(localObject2);
    paramString.put(localObject1, localObject2);
    paramString = (CharSequence)paramWxaPluginPkgInfo.prefixPath;
    int j;
    if ((paramString != null) && (paramString.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    paramString = (String)localObject1;
    if (j != 0)
    {
      j = ((String)localObject1).length();
      int k = aj.a.a(a, paramWxaPluginPkgInfo).length();
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).substring(0, j - k);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    paramWxaPluginPkgInfo = paramString;
    if (StringsKt.endsWith$default((CharSequence)paramString, '/', false, 2, null))
    {
      j = paramString.length();
      if (paramString != null)
      {
        paramWxaPluginPkgInfo = paramString.substring(0, j - 1);
        Intrinsics.checkExpressionValueIsNotNull(paramWxaPluginPkgInfo, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    paramString = localv.f().iterator();
    while (paramString.hasNext())
    {
      localObject1 = (v.a)paramString.next();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramWxaPluginPkgInfo);
      ((StringBuilder)localObject2).append(k.b(((v.a)localObject1).b));
      localObject2 = ((StringBuilder)localObject2).toString();
      Map localMap = (Map)this.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "info");
      localObject1 = a((v.a)localObject1, localv);
      localFunction1.invoke(localObject1);
      localMap.put(localObject2, localObject1);
    }
  }
  
  private final <T> T b(Function0<? extends T> paramFunction0)
  {
    ReentrantReadWriteLock.ReadLock localReadLock = this.i.readLock();
    localReadLock.lock();
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      localReadLock.unlock();
    }
  }
  
  @Nullable
  public v a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int j;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      return null;
    }
    return (v)b((Function0)new aj.c(this, paramString));
  }
  
  public void a()
  {
    if (this.g) {
      return;
    }
    a((Function0)new aj.k(this));
    this.g = true;
  }
  
  public final void a(@NotNull List<? extends e> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "_pkgList");
    if (this.h) {
      return;
    }
    a((Function0)new aj.i(this, new LinkedList((Collection)paramList)));
  }
  
  @Nullable
  public InputStream b(@Nullable String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return a(paramString);
    }
    return null;
  }
  
  @NotNull
  public List<ModulePkgInfo> b()
  {
    LinkedList localLinkedList = this.c.e;
    Intrinsics.checkExpressionValueIsNotNull(localLinkedList, "pkgWrappingInfo.moduleList");
    return (List)localLinkedList;
  }
  
  @Nullable
  public h.a c(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int j;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      return null;
    }
    return (h.a)b((Function0)new aj.j(this, paramString));
  }
  
  @NotNull
  public List<String> c()
  {
    return (List)b((Function0)new aj.h(this));
  }
  
  public void close()
  {
    a((Function0)new aj.b(this));
    this.h = true;
  }
  
  public boolean d(@Nullable String paramString)
  {
    return c(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj
 * JD-Core Version:    0.7.0.1
 */