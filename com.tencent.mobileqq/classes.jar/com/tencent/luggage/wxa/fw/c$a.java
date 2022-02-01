package com.tencent.luggage.wxa.fw;

import com.tencent.luggage.util.e;
import com.tencent.luggage.wxa.dc.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxapkg/WxaRuntimePkgDownloader$DownloaderUtils;", "", "()V", "checkExistence", "", "path", "", "md5", "downloadImpl", "url", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadImplSync", "", "getDownloadUrl", "appId", "moduleName", "version", "versionMd5", "versionType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPath", "preConnectCDN", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class c$a
{
  public static final a a = new a();
  
  public final int a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    return e.a.b(paramString1, paramString2);
  }
  
  @Nullable
  public final String a(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, @Nullable String paramString3, int paramInt2)
  {
    return t.a(paramString1, paramString2, paramInt1, paramString3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.c.a
 * JD-Core Version:    0.7.0.1
 */