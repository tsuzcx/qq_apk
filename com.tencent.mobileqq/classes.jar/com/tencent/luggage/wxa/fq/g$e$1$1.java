package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxaapi.internal.WxaApiImpl$checkAuthState$1$1$1", f="WxaApiImpl.kt", i={0}, l={403}, m="invokeSuspend", n={"$this$launch"}, s={"L$0"})
final class g$e$1$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope d;
  
  g$e$1$1(g.e.1 param1, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.c, paramContinuation);
    paramContinuation.d = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.b;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (CoroutineScope)this.a;
        ResultKt.throwOnFailure(paramObject);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.d;
      localObject1 = (CoroutineContext)Dispatchers.getDefault();
      Function2 localFunction2 = (Function2)new g.e.1.1.a(this, null);
      this.a = paramObject;
      this.b = 1;
      localObject1 = BuildersKt.withContext((CoroutineContext)localObject1, localFunction2, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    paramObject = (TdiAuthState)paramObject;
    g.a();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkAuthState ");
    ((StringBuilder)localObject1).append(paramObject);
    o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject1).toString());
    localObject1 = this.c.a.b;
    if (localObject1 != null) {
      ((TdiAuthCheckStateListener)localObject1).onStateChecked(paramObject, null);
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.e.1.1
 * JD-Core Version:    0.7.0.1
 */