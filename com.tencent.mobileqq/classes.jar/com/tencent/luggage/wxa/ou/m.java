package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.ba.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/WxaMenuOperationReporter;", "", "()V", "MM_KVSTAT_APPBRAND_WECHAT_APP_INNER_MENU_CLICK", "", "clickReport", "", "pageView", "Lcom/tencent/luggage/standalone_ext/PageView;", "action", "actionNote", "", "actionTime", "", "actionResult", "actionErrCode", "ActionDef", "ActionResultDef", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class m
{
  public static final m a = new m();
  
  public final void a(@NotNull com.tencent.luggage.wxa.em.c paramc, int paramInt1, @Nullable String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    String str1 = paramc.getAppId();
    Object localObject1 = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "pageView.runtime");
    int i = ((com.tencent.luggage.wxa.ed.d)localObject1).b();
    localObject1 = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "pageView.runtime");
    int j = ((com.tencent.luggage.wxa.ed.d)localObject1).ab();
    localObject1 = paramc.an();
    if (localObject1 == null) {
      localObject1 = "";
    }
    String str2 = k.a((String)localObject1, null, 2, null);
    localObject1 = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "pageView.runtime");
    Object localObject2 = ((com.tencent.luggage.wxa.ed.d)localObject1).l();
    int k = ((d)localObject2).c;
    localObject1 = ((d)localObject2).d;
    if (localObject1 == null) {
      localObject1 = "";
    }
    int m = ((d)localObject2).a;
    String str3 = ((d)localObject2).b;
    int n = ((d)localObject2).e;
    localObject2 = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "pageView.runtime");
    int i1 = ((com.tencent.luggage.wxa.ed.d)localObject2).j().c;
    paramc = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "pageView.runtime");
    paramc = paramc.j();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "pageView.runtime.initConfig");
    paramc = paramc.h();
    localObject2 = (com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class);
    if (localObject2 != null) {
      ((com.tencent.luggage.wxa.ot.d)localObject2).a(13539, new Object[] { Integer.valueOf(k), localObject1, paramc, str1, Integer.valueOf(i), Integer.valueOf(j + 1), Integer.valueOf(n), str2, Integer.valueOf(paramInt1), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(m), str3, Integer.valueOf(i1 + 1000) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.m
 * JD-Core Version:    0.7.0.1
 */