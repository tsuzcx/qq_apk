package com.tencent.luggage.wxa.ny;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.af.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils$WxaPkgModuleListMatcherIMPL;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo$WxaPkgModuleListMatcher;", "()V", "findModule", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "moduleList", "", "pathOrModuleName", "", "message", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class h$a
  implements af.a
{
  public static final a a = new a();
  
  @Nullable
  public ModulePkgInfo a(@NotNull List<? extends ModulePkgInfo> paramList, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "moduleList");
    Intrinsics.checkParameterIsNotNull(paramString1, "pathOrModuleName");
    return (ModulePkgInfo)h.a(paramList, paramString1, paramString2, false, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.h.a
 * JD-Core Version:    0.7.0.1
 */