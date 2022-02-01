package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.eo.a;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.luggage.wxa.rr.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/SubProcessLaunchWxaApp;", "Lcom/tencent/mm/vending/functional/Functional;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/luggage/standalone_ext/Runtime;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "()V", "call", "tuple", "callSuspended", "rt", "wxaAttributes", "(Lcom/tencent/luggage/standalone_ext/Runtime;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLaunchPBFromCGI", "isSync", "", "(Lcom/tencent/luggage/standalone_ext/Runtime;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLaunchPBFromDB", "(Lcom/tencent/luggage/standalone_ext/Runtime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j
  implements com.tencent.luggage.wxa.rl.b<fb, c<d, s>>
{
  @Deprecated
  public static final j.a a = new j.a(null);
  
  @Nullable
  public fb a(@NotNull c<d, s> paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "tuple");
    com.tencent.luggage.wxa.ro.b localb = h.c();
    d locald = (d)paramc.b();
    paramc = (s)paramc.c();
    BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getIO(), null, (Function2)new j.b(this, locald, paramc, localb, null), 2, null);
    return null;
  }
  
  @Nullable
  public final Object a(@NotNull d paramd, @NotNull s params, @NotNull Continuation<? super fb> paramContinuation)
  {
    params = new SafeContinuation(IntrinsicsKt.intercepted(paramContinuation));
    Continuation localContinuation = (Continuation)params;
    Object localObject1 = paramd.G();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "rt.initConfig");
    localObject1 = ((a)localObject1).i();
    Object localObject2 = t.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "wxaLaunchInstanceId");
    t.a((t)localObject2, (String)localObject1, t.d.c, t.c.b, null, 8, null);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("call --START-- appId:");
    ((StringBuilder)localObject2).append(paramd.aa());
    ((StringBuilder)localObject2).append(" versionType:");
    ((StringBuilder)localObject2).append(paramd.ab());
    ((StringBuilder)localObject2).append(", ts:");
    ((StringBuilder)localObject2).append(af.d());
    o.d("Luggage.WXA.SubProcessLaunchWxaApp", ((StringBuilder)localObject2).toString());
    long l1 = af.b();
    long l2 = af.d();
    BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getIO(), null, (Function2)new j.c((String)localObject1, l1, l2, localContinuation, null, this, paramd), 2, null);
    paramd = params.getOrThrow();
    if (paramd == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.j
 * JD-Core Version:    0.7.0.1
 */