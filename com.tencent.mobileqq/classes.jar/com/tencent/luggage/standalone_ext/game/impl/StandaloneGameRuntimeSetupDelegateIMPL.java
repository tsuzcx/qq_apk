package com.tencent.luggage.standalone_ext.game.impl;

import android.content.Context;
import com.tencent.luggage.wxa.bl.c;
import com.tencent.luggage.wxa.bm.g;
import com.tencent.luggage.wxa.bs.e;
import com.tencent.luggage.wxa.em.f;
import com.tencent.mm.plugin.appbrand.page.o.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/game/impl/StandaloneGameRuntimeSetupDelegateIMPL;", "Lcom/tencent/luggage/standalone_ext/StandaloneRuntimeSetupDelegateInterface;", "()V", "onCreateAppService", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "onCreatePageContainer", "Lcom/tencent/luggage/standalone_ext/PageContainer;", "onRuntimeCreated", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class StandaloneGameRuntimeSetupDelegateIMPL
  implements f
{
  public void a(@NotNull com.tencent.luggage.wxa.em.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    com.tencent.luggage.wxa.bu.a.a().a(paramd.aa(), paramd.t());
    c.a().a((g)com.tencent.luggage.wxa.eq.a.a);
  }
  
  @NotNull
  public com.tencent.luggage.standalone_ext.service.a b(@NotNull com.tencent.luggage.wxa.em.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    return new com.tencent.luggage.standalone_ext.service.a(com.tencent.luggage.standalone_ext.service.b.class);
  }
  
  @NotNull
  public com.tencent.luggage.wxa.em.b c(@NotNull com.tencent.luggage.wxa.em.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    return new com.tencent.luggage.wxa.em.b((Context)paramd.ah(), (com.tencent.luggage.wxa.ed.d)paramd, (o.a)new e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.game.impl.StandaloneGameRuntimeSetupDelegateIMPL
 * JD-Core Version:    0.7.0.1
 */