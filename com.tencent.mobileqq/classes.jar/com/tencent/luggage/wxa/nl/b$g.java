package com.tencent.luggage.wxa.nl;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "kotlin.jvm.PlatformType", "o2", "compare"}, k=3, mv={1, 1, 16})
final class b$g<T>
  implements Comparator<e>
{
  public static final g a = new g();
  
  public final int a(e parame1, e parame2)
  {
    boolean bool2 = Intrinsics.areEqual(parame1.getClass(), parame2.getClass());
    boolean bool1 = true;
    if ((bool2 ^ true)) {}
    Object localObject;
    label92:
    do
    {
      WxaPluginPkgInfo localWxaPluginPkgInfo;
      do
      {
        bool1 = false;
        break label132;
        if (!(parame1 instanceof WxaPluginPkgInfo)) {
          break label92;
        }
        if (parame2 == null) {
          break;
        }
        localObject = (WxaPluginPkgInfo)parame2;
        localWxaPluginPkgInfo = (WxaPluginPkgInfo)parame1;
      } while ((!Intrinsics.areEqual(localWxaPluginPkgInfo.provider, ((WxaPluginPkgInfo)localObject).provider)) || (localWxaPluginPkgInfo.version != ((WxaPluginPkgInfo)localObject).version));
      break;
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo");
    } while (!(parame1 instanceof ModulePkgInfo));
    if (parame2 != null)
    {
      localObject = (ModulePkgInfo)parame2;
      bool1 = ((ModulePkgInfo)parame1).isAssignable((ModulePkgInfo)localObject);
    }
    else
    {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo");
    }
    label132:
    if (bool1) {
      return 0;
    }
    return parame1.hashCode() - parame2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.g
 * JD-Core Version:    0.7.0.1
 */