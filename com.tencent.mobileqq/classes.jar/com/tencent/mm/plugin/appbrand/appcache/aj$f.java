package com.tencent.mm.plugin.appbrand.appcache;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"}, k=3, mv={1, 1, 16})
final class aj$f
  extends Lambda
  implements Function1<h.a, Unit>
{
  aj$f(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    super(1);
  }
  
  public final void a(@NotNull h.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "it");
    parama.d = this.a.provider;
    parama.e = this.a.pkgVersion();
    parama.f = this.a.checksumMd5();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.f
 * JD-Core Version:    0.7.0.1
 */