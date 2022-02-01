package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.c;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.jx.k;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class t$a
  extends HashSet<u>
  implements k
{
  public t$a(@NotNull d paramd)
  {
    paramd = paramd.al();
    if (paramd != null) {
      paramd.a((c.a)new t.a.1(this));
    }
  }
  
  public int a()
  {
    return super.size();
  }
  
  public boolean a(u paramu)
  {
    return super.contains(paramu);
  }
  
  public boolean b(u paramu)
  {
    return super.remove(paramu);
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof u)) {
      return a((u)paramObject);
    }
    return false;
  }
  
  public final boolean remove(Object paramObject)
  {
    if ((paramObject instanceof u)) {
      return b((u)paramObject);
    }
    return false;
  }
  
  public final int size()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t.a
 * JD-Core Version:    0.7.0.1
 */