package com.tencent.luggage.wxa.lk;

import android.app.Activity;
import com.tencent.luggage.wxa.rc.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion;", "", "()V", "INVALID_NFC_ADAPTER_STATE", "", "METHOD_NAME_GET", "", "METHOD_NAME_GET_MAX_TRANSCEIVE_LENGTH", "METHOD_NAME_SET_TIMEOUT", "METHOD_NAME_TRANSCEIVE", "NFC_IO_LOOP_TAG", "TAG", "appId2ManagerMap", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "factory", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "getFactory", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;", "setFactory", "(Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$Companion$IFactory;)V", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "techListsArray", "kotlin.jvm.PlatformType", "[[Ljava/lang/String;", "get", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isNFCUsing", "", "manager", "appId", "IFactory", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c$a
{
  @NotNull
  public final c.a.a a()
  {
    return c.g();
  }
  
  @JvmStatic
  @Nullable
  public final c a(@NotNull com.tencent.luggage.wxa.jx.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Object localObject1 = (c)c.f().get(paramc.getAppId());
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = a.a(paramc.getContext());
    if (localObject1 != null)
    {
      Object localObject2 = c.a.a();
      String str = paramc.getAppId();
      Intrinsics.checkExpressionValueIsNotNull(str, "component.appId");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      localObject1 = ((c.a.a)localObject2).a(str, (Activity)localObject1, paramc);
      localObject2 = c.f();
      paramc = paramc.getAppId();
      Intrinsics.checkExpressionValueIsNotNull(paramc, "component.appId");
      ((Map)localObject2).put(paramc, localObject1);
      return localObject1;
    }
    return null;
  }
  
  public final void a(@NotNull c.a.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "<set-?>");
    c.a(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.a
 * JD-Core Version:    0.7.0.1
 */