package com.tencent.luggage.wxa.fu;

import android.app.Application;
import android.content.Context;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.bb.a.c;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.f;
import com.tencent.mm.plugin.appbrand.ui.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/process/WxaProcessStartup$initialize$2", "Lcom/tencent/luggage/standalone_ext/impl/StandaloneLuggageInitDelegate;", "onInitialize", "", "initializer", "Lcom/tencent/luggage/bridge/core/LuggageBoot$LuggageInitializer;", "registerServiceLogicImp", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class h$b
  extends com.tencent.luggage.wxa.er.b
{
  h$b(Application paramApplication, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    super.a();
    com.tencent.luggage.wxa.standalone_open_runtime.service.b.a.a();
  }
  
  public void a(@NotNull a.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "initializer");
    super.a(paramc);
    e.a(i.class, (com.tencent.luggage.wxa.ba.b)f.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.h.b
 * JD-Core Version:    0.7.0.1
 */