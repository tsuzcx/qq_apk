package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.ca;
import com.tencent.luggage.wxa.rp.h;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class d$b
{
  private final void a(aa paramaa)
  {
    d.a(this.a).invoke(paramaa);
  }
  
  public final void a(@NotNull k.b paramb, @NotNull ca[] paramArrayOfca)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "request");
    Intrinsics.checkParameterIsNotNull(paramArrayOfca, "urls");
    Function1 localFunction1 = d.a(this.a);
    d.c();
    localFunction1.invoke(d.b());
    com.tencent.luggage.wxa.rp.d.b.a((Runnable)new d.b.a(this, paramb, paramArrayOfca));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.b
 * JD-Core Version:    0.7.0.1
 */