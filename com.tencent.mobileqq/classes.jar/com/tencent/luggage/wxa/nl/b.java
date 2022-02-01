package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.jj.s.d;
import com.tencent.luggage.wxa.jj.s.h;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "version", "", "versionType", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull List<String> paramList, @NotNull Map<String, ? extends s.h> paramMap, @NotNull Function1<? super List<? extends com.tencent.mm.plugin.appbrand.appcache.e>, Unit> paramFunction1, @NotNull Function1<? super aa, Unit> paramFunction11, @NotNull Function2<? super Integer, ? super String, Unit> paramFunction2, boolean paramBoolean, @Nullable b.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramList, "requestedModuleNames");
    Intrinsics.checkParameterIsNotNull(paramMap, "pickedModuleInfoList");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onSuccess");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "onProgress");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onError");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int i = 0;
      if (!bool) {
        break label279;
      }
      paramList = (String)localIterator.next();
      localObject = (s.h)paramMap.get(paramList);
      if (localObject == null) {
        break;
      }
      int j = ((s.h)localObject).a;
      if (d.a.a(paramInt2)) {
        i = paramInt1;
      }
      localHashSet.add(new j.d(paramString, paramList, j, paramInt2, (j.g)new j.g.b(i), paramBoolean));
      paramList = ((s.h)localObject).c;
      if (paramList == null) {
        paramList = CollectionsKt.emptyList();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (s.d)paramList.next();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "plugin");
        localHashSet.add(e.a((s.d)localObject));
      }
    }
    paramString = new StringBuilder();
    paramString.append("Invalid ModuleName(");
    paramString.append(paramList);
    paramString.append(')');
    throw ((Throwable)new IllegalStateException(paramString.toString().toString()));
    label279:
    if (localHashSet.size() > 0)
    {
      paramString = new b.b(localHashSet.size());
      paramList = new b.c(paramFunction11);
      paramMap = new AtomicBoolean(false);
      paramFunction11 = new ConcurrentSkipListSet((Comparator)b.g.a);
      localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (j.d)localIterator.next();
        j.b localb = j.b;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "request");
        localb.a((j.d)localObject, (Function1)new b.d(paramFunction11, (j.d)localObject, paramString, paramList, localHashSet, paramFunction1, parama), (Function2)new b.e((j.d)localObject, paramMap, paramFunction2, parama), (Function1)new b.f(paramList, (j.d)localObject), (k)paramString, (j.c)parama);
      }
      return;
    }
    paramString = (Throwable)new IllegalStateException("RequestPkgInfoList.size==0".toString());
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b
 * JD-Core Version:    0.7.0.1
 */