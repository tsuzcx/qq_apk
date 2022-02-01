package com.tencent.luggage.wxa.fw;

import com.tencent.luggage.wxa.dc.t;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxapkg/WxaRuntimePkgDownloader;", "", "()V", "MAGIC_MD5_SKIP_CHECK", "", "getMAGIC_MD5_SKIP_CHECK", "()Ljava/lang/String;", "TAG", "TIMEOUT", "", "downloadForEntrance", "", "appId", "versionType", "", "enterPath", "wxaAttributes", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "cb", "Lcom/tencent/luggage/wxapkg/WxaRuntimePkgDownloadCallback;", "downloadForPkgFetcher", "pkgQueryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "appVersion", "downloadUrl", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "Downloader", "DownloaderUtils", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  @NotNull
  private static final String b;
  
  static
  {
    String str = t.a;
    if (str == null) {
      Intrinsics.throwNpe();
    }
    b = str;
    a.a.a();
  }
  
  public final void a(@NotNull n paramn, int paramInt1, int paramInt2, @NotNull String paramString, @Nullable b paramb, @Nullable Function1<? super aa, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramn, "pkgQueryKey");
    Intrinsics.checkParameterIsNotNull(paramString, "downloadUrl");
    f.a.d((Runnable)new c.b(paramn, paramInt2, paramInt1, paramb, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.c
 * JD-Core Version:    0.7.0.1
 */