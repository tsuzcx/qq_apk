package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Factory;", "", "()V", "waitForPkg", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j$b
{
  public final void a(@NotNull j.d paramd, @NotNull Function1<? super j.e, Unit> paramFunction1, @NotNull Function2<? super j.a, ? super String, Unit> paramFunction2, @NotNull Function1<? super aa, Unit> paramFunction11, @NotNull k paramk, @Nullable j.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onSuccess");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onError");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "onProgress");
    Intrinsics.checkParameterIsNotNull(paramk, "cgiExecutor");
    f.a.e((Runnable)new j.b.a(paramd, paramFunction1, paramFunction2, paramFunction11, paramk, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.j.b
 * JD-Core Version:    0.7.0.1
 */