package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.do.c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/RuntimeRestartHelper;", "", "()V", "restartRuntime", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "newConfig", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class y
{
  public static final y a = new y();
  
  @JvmStatic
  public static final void a(@NotNull d paramd, @NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "$this$restartRuntime");
    Intrinsics.checkParameterIsNotNull(paramc, "newConfig");
    paramd.d((Runnable)new y.a(paramd, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.y
 * JD-Core Version:    0.7.0.1
 */