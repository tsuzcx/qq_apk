package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.oy.a;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess$preloadPage$2$1$4"}, k=3, mv={1, 1, 16})
final class g$d$3
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  int a;
  private CoroutineScope c;
  
  g$d$3(g.d paramd, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 3(this.b, paramContinuation);
    paramContinuation.c = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((3)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.a == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.c;
      paramObject = this.b.c;
      Object localObject1 = g.e(this.b.d).invoke();
      Object localObject2 = (c)localObject1;
      if (localObject2 != null) {
        ((c)localObject2).V();
      }
      d.b(g.a(this.b.d), a.v);
      localObject2 = Result.Companion;
      paramObject.resumeWith(Result.constructor-impl(localObject1));
      return Unit.INSTANCE;
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.d.3
 * JD-Core Version:    0.7.0.1
 */