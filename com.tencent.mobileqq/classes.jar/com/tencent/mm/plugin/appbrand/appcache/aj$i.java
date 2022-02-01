package com.tencent.mm.plugin.appbrand.appcache;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class aj$i
  extends Lambda
  implements Function0<Unit>
{
  aj$i(aj paramaj, LinkedList paramLinkedList)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject1 = this.b.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!(localObject2 instanceof ModulePkgInfo)) && ((localObject2 instanceof WxaPluginPkgInfo)))
      {
        localObject3 = aj.a(this.a).f;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((ai)localObject3).a((WxaPluginPkgInfo)localObject2);
        ((Iterator)localObject1).remove();
      }
    }
    Object localObject2 = ((Iterable)this.b).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (e)((Iterator)localObject2).next();
      if (localObject1 != null)
      {
        localObject3 = (ModulePkgInfo)localObject1;
        Object localObject4 = ((Iterable)aj.a(this.a)).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          if (Intrinsics.areEqual(((ModulePkgInfo)localObject1).name, ((ModulePkgInfo)localObject3).name)) {
            break label177;
          }
        }
        localObject1 = null;
        label177:
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = (ModulePkgInfo)localObject1;
        ((ModulePkgInfo)localObject1).pkgPath = ((ModulePkgInfo)localObject3).pkgPath;
        ((ModulePkgInfo)localObject1).md5 = ((ModulePkgInfo)localObject3).md5;
        aj.a(this.a, (ModulePkgInfo)localObject3);
        localObject1 = aj.a(this.a).f;
        if (localObject1 != null)
        {
          localObject4 = ((ModulePkgInfo)localObject3).name;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "module.name");
          localObject1 = ((ai)localObject1).a((String)localObject4);
          if (localObject1 != null)
          {
            localObject1 = ((Iterable)localObject1).iterator();
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
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.i
 * JD-Core Version:    0.7.0.1
 */