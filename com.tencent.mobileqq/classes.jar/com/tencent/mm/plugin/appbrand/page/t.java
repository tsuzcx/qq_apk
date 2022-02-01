package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t
{
  public static final t a = new t();
  private static boolean b = true;
  
  private final t.a a(d paramd)
  {
    t.a locala2 = (t.a)paramd.c(t.a.class);
    t.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new t.a(paramd);
      paramd.a((k)locala1);
    }
    return locala1;
  }
  
  @JvmStatic
  public static final void a(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    if (paramu.q() != null) {
      try
      {
        localObject = a;
        d locald = paramu.q();
        Intrinsics.checkExpressionValueIsNotNull(locald, "page.runtime");
        ((t)localObject).a(locald).remove(paramu);
        return;
      }
      catch (Exception paramu)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPageReload ");
        ((StringBuilder)localObject).append(paramu);
        com.tencent.luggage.wxa.qz.o.c("Luggage.AppBrandPageTrimLogic[wxa_reload]", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @JvmStatic
  public static final boolean b(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    boolean bool;
    Object localObject2;
    try
    {
      bool = a.c(paramu);
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("canTrimThisPage ");
      ((StringBuilder)localObject2).append(localException);
      com.tencent.luggage.wxa.qz.o.c("Luggage.AppBrandPageTrimLogic[wxa_reload]", ((StringBuilder)localObject2).toString());
      bool = false;
    }
    if (bool)
    {
      Object localObject1 = a;
      localObject2 = paramu.q();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.runtime");
      ((t)localObject1).a((d)localObject2).add(paramu);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("page trimmed, appId[");
      ((StringBuilder)localObject1).append(paramu.getAppId());
      ((StringBuilder)localObject1).append("] path[");
      ((StringBuilder)localObject1).append(paramu.an());
      ((StringBuilder)localObject1).append(']');
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandPageTrimLogic[wxa_reload]", ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
  
  private final boolean c(u paramu)
  {
    if (!b) {
      return false;
    }
    Object localObject = (CharSequence)paramu.an();
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    localObject = paramu.q();
    if ((localObject != null) && (!((d)localObject).aQ()))
    {
      localObject = paramu.q();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((d)localObject).aP()) {
        return true;
      }
    }
    localObject = paramu.T();
    if (localObject != null)
    {
      if (((m)localObject).n() != true) {
        return false;
      }
      if ((paramu.T() instanceof f)) {
        return false;
      }
      if (paramu.q() != null)
      {
        localObject = paramu.q();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "page.runtime");
        if ((((d)localObject).C() != null) && (paramu.T() != null))
        {
          localObject = paramu.T();
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          i = ((m)localObject).g();
          paramu = paramu.q();
          Intrinsics.checkExpressionValueIsNotNull(paramu, "page.runtime");
          paramu = paramu.C();
          Intrinsics.checkExpressionValueIsNotNull(paramu, "page.runtime.pageContainer");
          if (i < paramu.getPageCount() - 5) {
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */