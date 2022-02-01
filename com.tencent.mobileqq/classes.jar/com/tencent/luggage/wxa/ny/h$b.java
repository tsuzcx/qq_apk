package com.tencent.luggage.wxa.ny;

import com.tencent.luggage.wxa.jj.s.g;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 1, 16})
public final class h$b<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    int i;
    if ((paramT2 instanceof s.g))
    {
      i = ((s.g)paramT2).a.length();
    }
    else
    {
      if (!(paramT2 instanceof ModulePkgInfo)) {
        break label114;
      }
      i = ((ModulePkgInfo)paramT2).name.length();
    }
    paramT2 = (Comparable)Integer.valueOf(i);
    if ((paramT1 instanceof s.g))
    {
      i = ((s.g)paramT1).a.length();
    }
    else
    {
      if (!(paramT1 instanceof ModulePkgInfo)) {
        break label98;
      }
      i = ((ModulePkgInfo)paramT1).name.length();
    }
    return ComparisonsKt.compareValues(paramT2, (Comparable)Integer.valueOf(i));
    label98:
    throw ((Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString()));
    label114:
    throw ((Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.h.b
 * JD-Core Version:    0.7.0.1
 */