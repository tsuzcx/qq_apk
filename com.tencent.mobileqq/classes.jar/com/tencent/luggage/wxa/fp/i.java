package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.iy.a;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;)V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addCollection", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "p2", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "syncCollectionStatusToLocal", "appId", "userName", "versionType", "unlock", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class i
  implements a
{
  public static final i.a a = new i.a(null);
  @NotNull
  private static final i c = new i((a)h.a);
  private final a b;
  
  private i(a parama)
  {
    this.b = parama;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "userName");
    f.a.d((Runnable)new i.b(paramString1, paramString2, paramInt));
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.b.a(paramString, paramInt);
  }
  
  public int b(String paramString, int paramInt)
  {
    return this.b.b(paramString, paramInt);
  }
  
  public boolean c(String paramString, int paramInt)
  {
    return this.b.c(paramString, paramInt);
  }
  
  public int e()
  {
    return this.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.i
 * JD-Core Version:    0.7.0.1
 */