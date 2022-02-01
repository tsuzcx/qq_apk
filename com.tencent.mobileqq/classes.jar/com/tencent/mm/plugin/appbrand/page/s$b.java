package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class s$b
  extends Lambda
  implements Function0<Boolean>
{
  s$b(s params)
  {
    super(0);
  }
  
  public final boolean a()
  {
    Object localObject1;
    if (!s.a.a(s.a(this.a)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("useLazyCodeLoadingMode return false, lib.version=[");
      ((StringBuilder)localObject1).append(s.a(this.a).b());
      ((StringBuilder)localObject1).append(']');
      o.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", ((StringBuilder)localObject1).toString());
      return false;
    }
    if (s.b(this.a).d("common.app.js"))
    {
      o.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return true, by common.app.js");
      return true;
    }
    Object localObject2 = s.b(this.a).b().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (ModulePkgInfo)((Iterator)localObject2).next();
      if (((ModulePkgInfo)localObject1).independent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ModulePkgInfo)localObject1).name);
        String str = ((ModulePkgInfo)localObject1).name;
        Intrinsics.checkExpressionValueIsNotNull(str, "m.name");
        localObject1 = "/";
        if (StringsKt.endsWith$default(str, "/", false, 2, null)) {
          localObject1 = "";
        }
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("common.app.js");
        localObject1 = localStringBuilder.toString();
        if (s.b(this.a).d((String)localObject1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("useLazyCodeLoadingMode return true, by independent ");
          ((StringBuilder)localObject2).append((String)localObject1);
          o.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", ((StringBuilder)localObject2).toString());
          return true;
        }
      }
    }
    o.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.b
 * JD-Core Version:    0.7.0.1
 */