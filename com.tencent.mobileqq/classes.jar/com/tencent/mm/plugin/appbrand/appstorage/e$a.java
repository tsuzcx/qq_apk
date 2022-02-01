package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.dx.a;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "Lcom/tencent/luggage/sdk/login/MMUserId;", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "data-storage_release"}, k=1, mv={1, 1, 16})
public final class e$a
{
  @NotNull
  public final e a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "uin");
    synchronized (e.b())
    {
      if (!e.b().keySet().contains(parama)) {
        e.b().put(parama, new e(parama, null));
      }
      Unit localUnit = Unit.INSTANCE;
      parama = e.b().get(parama);
      if (parama == null) {
        Intrinsics.throwNpe();
      }
      return (e)parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.a
 * JD-Core Version:    0.7.0.1
 */