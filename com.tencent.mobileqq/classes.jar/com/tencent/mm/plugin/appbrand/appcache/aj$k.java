package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.wxa.rt.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class aj$k
  extends Lambda
  implements Function0<Unit>
{
  aj$k(aj paramaj)
  {
    super(0);
  }
  
  public final void a()
  {
    aj.a(this.a).a(aj.b(this.a));
    Object localObject1 = aj.a(this.a).f;
    if (localObject1 != null) {
      ((ai)localObject1).c();
    }
    localObject1 = this.a;
    Object localObject2 = new ArrayMap(aj.a((aj)localObject1).e.size() + 1);
    Object localObject3 = aj.a(this.a).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (ModulePkgInfo)((Iterator)localObject3).next();
      ((ArrayMap)localObject2).put(((ModulePkgInfo)localObject4).name, localObject4);
    }
    aj.a((aj)localObject1, (ArrayMap)localObject2);
    localObject2 = aj.a(this.a).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ModulePkgInfo)((Iterator)localObject2).next();
      if (k.h(((ModulePkgInfo)localObject3).pkgPath))
      {
        localObject1 = this.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "module");
        aj.a((aj)localObject1, (ModulePkgInfo)localObject3);
        localObject1 = aj.a(this.a).f;
        if (localObject1 != null)
        {
          localObject4 = ((ModulePkgInfo)localObject3).name;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "module.name");
          localObject1 = ((ai)localObject1).a((String)localObject4);
        }
        else
        {
          localObject1 = null;
        }
        if (localObject1 == null) {
          localObject1 = CollectionsKt.emptyList();
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          aj localaj = this.a;
          String str = ((ModulePkgInfo)localObject3).name;
          Intrinsics.checkExpressionValueIsNotNull(str, "module.name");
          aj.a(localaj, str, (WxaPluginPkgInfo)localObject4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.k
 * JD-Core Version:    0.7.0.1
 */