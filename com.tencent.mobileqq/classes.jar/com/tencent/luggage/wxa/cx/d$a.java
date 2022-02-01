package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.em.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/CgiLaunchWxaAppForWarmLaunch$Utils;", "", "()V", "CoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "sendWithDefaultHandler", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d$a
{
  public final void b(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    BuildersKt.launch$default(((a)this).a(paramd), null, null, (Function2)new d.a.b(paramd, null), 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.d.a
 * JD-Core Version:    0.7.0.1
 */