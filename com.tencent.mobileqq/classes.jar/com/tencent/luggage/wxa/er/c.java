package com.tencent.luggage.wxa.er;

import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.dx.a;
import com.tencent.mm.plugin.appbrand.appstorage.e;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/impl/WxaMMKVStorageManager;", "", "()V", "ISOLATE_ID", "Lcom/tencent/luggage/sdk/login/MMUserId;", "getISOLATE_ID", "()Lcom/tencent/luggage/sdk/login/MMUserId;", "ISOLATE_ID$delegate", "Lkotlin/Lazy;", "SHARE_ID", "getSHARE_ID", "SHARE_ID$delegate", "TAG", "", "getMMKVAppKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "appId", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  private static final Lazy b = LazyKt.lazy((Function0)c.b.a);
  private static final Lazy c = LazyKt.lazy((Function0)c.a.a);
  
  private final a a()
  {
    return (a)b.getValue();
  }
  
  @JvmStatic
  @NotNull
  public static final e a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if (i.a.a()) {
      return e.a.a(a.a());
    }
    return e.a.a(a.b());
  }
  
  private final a b()
  {
    return (a)c.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.er.c
 * JD-Core Version:    0.7.0.1
 */