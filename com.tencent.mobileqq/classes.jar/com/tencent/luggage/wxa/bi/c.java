package com.tencent.luggage.wxa.bi;

import android.content.Context;
import com.tencent.luggage.wxa.cx.q;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.ew.b;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="remove this ugly thing")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/container/MiniProgramNavigatorUglyLogicStandaloneImpl;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "to", "config", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  
  @JvmStatic
  public static final boolean a(@NotNull d paramd1, @NotNull d paramd2, @NotNull com.tencent.luggage.wxa.do.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramd1, "from");
    Intrinsics.checkParameterIsNotNull(paramd2, "to");
    Intrinsics.checkParameterIsNotNull(paramc, "config");
    paramd2 = paramd1.j();
    Intrinsics.checkExpressionValueIsNotNull(paramd2, "from.initConfig");
    if ((paramd2.g()) && (paramc.g()))
    {
      paramd1 = (Context)paramd1.ah();
      paramd2 = new b();
      paramd2.a = paramc.D;
      paramd2.e = paramc.G;
      paramd2.d = paramc.I;
      q.a(paramd1, paramd2, paramc.f(), paramc.h);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.c
 * JD-Core Version:    0.7.0.1
 */