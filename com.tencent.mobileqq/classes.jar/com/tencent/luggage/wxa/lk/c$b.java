package com.tencent.luggage.wxa.lk;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$factory$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "createNFCReadWriteManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c$b
  implements c.a.a
{
  @NotNull
  public c a(@NotNull String paramString, @NotNull Activity paramActivity, @NotNull com.tencent.luggage.wxa.jx.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    return new c(paramString, paramActivity, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.b
 * JD-Core Version:    0.7.0.1
 */