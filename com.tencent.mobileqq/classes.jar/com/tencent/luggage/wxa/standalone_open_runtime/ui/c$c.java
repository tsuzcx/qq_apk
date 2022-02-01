package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.widget.TextView;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.standalone_open_runtime.a;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaMenuHeader$setPage$6$1"}, k=3, mv={1, 1, 16})
final class c$c
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  double b;
  int c;
  private CoroutineScope f;
  
  c$c(TextView paramTextView, Continuation paramContinuation, e parame)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new c(this.d, paramContinuation, this.e);
    paramContinuation.f = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((c)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.c;
    CoroutineScope localCoroutineScope;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          d1 = this.b;
          localCoroutineScope = (CoroutineScope)this.a;
          ResultKt.throwOnFailure(paramObject);
          break label205;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localCoroutineScope = (CoroutineScope)this.a;
      ResultKt.throwOnFailure(paramObject);
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localCoroutineScope = this.f;
      paramObject = this.e.f();
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "page.runtime");
      paramObject = paramObject.j().b;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "page.runtime.initConfig.username");
      this.a = localCoroutineScope;
      this.c = 1;
      localObject1 = a.a(paramObject, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    double d1 = ((Number)paramObject).doubleValue();
    paramObject = (CoroutineContext)Dispatchers.getMain();
    Object localObject1 = (Function2)new c.c.1(this, d1, null);
    this.a = localCoroutineScope;
    this.b = d1;
    this.c = 2;
    if (BuildersKt.withContext(paramObject, (Function2)localObject1, this) == localObject2) {
      return localObject2;
    }
    label205:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.c.c
 * JD-Core Version:    0.7.0.1
 */