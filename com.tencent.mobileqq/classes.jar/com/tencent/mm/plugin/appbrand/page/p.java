package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.oq.c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerUtils;", "", "()V", "resetWindowAndroid", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class p
{
  public static final p a = new p();
  
  @JvmStatic
  public static final void a(@NotNull o paramo, @Nullable c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramo, "$this$resetWindowAndroid");
    Iterator localIterator = paramo.g();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "this.stackIterator()");
    while (localIterator.hasNext())
    {
      Object localObject = (m)localIterator.next();
      if ((localObject instanceof f))
      {
        localObject = ((f)localObject).f();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.pagesIterator()");
        while (((Iterator)localObject).hasNext())
        {
          u localu = (u)((Iterator)localObject).next();
          Intrinsics.checkExpressionValueIsNotNull(localu, "p");
          localu.a(paramc);
        }
      }
      else
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        localObject = ((m)localObject).getCurrentPageView();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.currentPageView");
        ((u)localObject).a(paramc);
      }
    }
    paramo = paramo.getPreloadedPageView();
    if (paramo != null) {
      paramo.a(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.p
 * JD-Core Version:    0.7.0.1
 */