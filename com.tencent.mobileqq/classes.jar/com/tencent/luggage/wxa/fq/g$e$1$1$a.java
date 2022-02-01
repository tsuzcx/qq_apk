package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.TdiAuthState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/wxaapi/TdiAuthState;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxaapi.internal.WxaApiImpl$checkAuthState$1$1$1$tdiAuthState$1", f="WxaApiImpl.kt", i={0}, l={403}, m="invokeSuspend", n={"$this$withContext"}, s={"L$0"})
final class g$e$1$1$a
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super TdiAuthState>, Object>
{
  Object a;
  int b;
  private CoroutineScope d;
  
  g$e$1$1$a(g.e.1.1 param1, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new a(this.c, paramContinuation);
    paramContinuation.d = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((a)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.b;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = (CoroutineScope)this.a;
        ResultKt.throwOnFailure(paramObject);
        return paramObject;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.d;
    g localg = this.c.c.a.a;
    this.a = paramObject;
    this.b = 1;
    paramObject = localg.a(this);
    if (paramObject == localObject) {
      return localObject;
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.e.1.1.a
 * JD-Core Version:    0.7.0.1
 */