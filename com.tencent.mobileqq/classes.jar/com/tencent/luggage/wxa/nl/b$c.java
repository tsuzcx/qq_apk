package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", "request", "progress", "onReady", "filePath", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class b$c
{
  private final HashMap<j.d, aa> a;
  private final Function1<aa, Unit> b;
  
  public b$c(@NotNull Function1<? super aa, Unit> paramFunction1)
  {
    this.b = paramFunction1;
    this.a = new HashMap();
  }
  
  public final void a(@NotNull j.d paramd, @NotNull aa paramaa)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(paramaa, "progress");
    synchronized (this.a)
    {
      ((Map)this.a).put(paramd, paramaa);
      paramd = ((c)this).a.values();
      Intrinsics.checkExpressionValueIsNotNull(paramd, "progressMap.values");
      paramd = ((Iterable)paramd).iterator();
      long l2 = 0L;
      for (long l1 = l2; paramd.hasNext(); l1 += Math.max(paramaa.c, 0L))
      {
        paramaa = (aa)paramd.next();
        if (paramaa == null)
        {
          paramd = null;
          break label163;
        }
        l2 += Math.max(paramaa.b, 0L);
      }
      int i;
      if (l1 <= 0L) {
        i = 0;
      } else {
        i = MathKt.roundToInt((float)l2 / (float)l1);
      }
      paramd = new aa(i, l2, l1);
      label163:
      if (paramd != null) {
        this.b.invoke(paramd);
      }
      return;
    }
    for (;;)
    {
      throw paramd;
    }
  }
  
  public final void a(@NotNull j.d paramd, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    if (this.a.size() > 0)
    {
      long l = k.c(paramString);
      a(paramd, new aa(100, l, l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.c
 * JD-Core Version:    0.7.0.1
 */