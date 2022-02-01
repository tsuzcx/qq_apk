package com.tencent.luggage.wxa.qa;

import android.webkit.URLUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class g
{
  private final HashMap<Integer, e> a = new HashMap();
  
  private final e a(String paramString, d paramd, com.tencent.luggage.wxa.iu.h paramh)
  {
    int i;
    if ((!URLUtil.isHttpsUrl(paramString)) && (!URLUtil.isHttpUrl(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (1 == i) {
      return (e)new h(paramString, paramd, paramh);
    }
    if (true == StringsKt.startsWith$default(paramString, "wxfile://", false, 2, null)) {
      return (e)new j(paramString, paramd, paramh);
    }
    if (true == a(paramString)) {
      return (e)new i(paramString, paramd, paramh);
    }
    return (e)new c(paramString, paramd);
  }
  
  private final boolean a(String paramString)
  {
    boolean bool = false;
    if ((StringsKt.endsWith$default(paramString, ".png", false, 2, null)) || (StringsKt.endsWith$default(paramString, ".jpg", false, 2, null)) || (StringsKt.endsWith$default(paramString, ".bmp", false, 2, null)) || (StringsKt.endsWith$default(paramString, ".gif", false, 2, null))) {
      bool = true;
    }
    return bool;
  }
  
  @NotNull
  public final e a(@NotNull String paramString, @NotNull d paramd, @NotNull com.tencent.luggage.wxa.iu.h paramh, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "iconPath");
    Intrinsics.checkParameterIsNotNull(paramd, "errorHandler");
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    paramString = a(paramString, paramd, paramh);
    paramString.a(paramInt);
    paramString.a((e.a)new g.a(this));
    paramd = (e)this.a.get(Integer.valueOf(paramInt));
    if (paramd != null) {
      paramd.e();
    }
    ((Map)this.a).put(Integer.valueOf(paramInt), paramString);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.g
 * JD-Core Version:    0.7.0.1
 */