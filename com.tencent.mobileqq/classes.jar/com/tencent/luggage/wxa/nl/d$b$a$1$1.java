package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.fw.b;
import com.tencent.mm.plugin.appbrand.appcache.af;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader$start$1$1$1", "Lcom/tencent/luggage/wxapkg/WxaRuntimePkgDownloadCallback;", "onError", "", "t", "", "onSuccess", "pkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d$b$a$1$1
  implements b
{
  public void a(@NotNull af paramaf)
  {
    Intrinsics.checkParameterIsNotNull(paramaf, "pkgInfo");
    Function1 localFunction1 = d.d(this.a.a.a.a);
    d.c localc = d.c.a;
    j.d locald = d.e(this.a.a.a.a);
    String str = paramaf.pkgPath();
    Intrinsics.checkExpressionValueIsNotNull(str, "pkgInfo.pkgPath()");
    localFunction1.invoke(localc.a(locald, str, paramaf.checksumMd5(), paramaf.pkgVersion(), j.f.b));
  }
  
  public void a(@Nullable Throwable paramThrowable)
  {
    Function2 localFunction2 = d.b(this.a.a.a.a);
    j.a locala = j.a.b;
    if (paramThrowable != null) {
      paramThrowable = paramThrowable.getMessage();
    } else {
      paramThrowable = null;
    }
    localFunction2.invoke(locala, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.b.a.1.1
 * JD-Core Version:    0.7.0.1
 */