package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.iu.ad;
import com.tencent.luggage.wxa.iu.ad.a;
import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.mm.plugin.appbrand.appcache.af;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/JsApiNavigateToMiniProgramBridged$BridgedRuntimeConfigAssembler;", "", "()V", "makeSysConfig", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "rt", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/JsApiNavigateToMiniProgramBridged$BridgedWxaRuntime;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$c
{
  public static final c a = new c();
  
  @NotNull
  public final d a(@NotNull b.e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "rt");
    Object localObject = u.a().b(parame.aa(), new String[0]);
    if (localObject == null)
    {
      localObject = new d();
    }
    else
    {
      localObject = ad.a((ad.a)b.c.a.a, (s)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "WxaModelsAdapter.createS…andSysConfigLU()}, attrs)");
    }
    if (((d)localObject).D == null) {
      ((d)localObject).D = g.a;
    }
    ((d)localObject).S = new af();
    ((d)localObject).S.b = parame.ab();
    ((d)localObject).S.pkgVersion = parame.b();
    ((d)localObject).S.d = true;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.c
 * JD-Core Version:    0.7.0.1
 */