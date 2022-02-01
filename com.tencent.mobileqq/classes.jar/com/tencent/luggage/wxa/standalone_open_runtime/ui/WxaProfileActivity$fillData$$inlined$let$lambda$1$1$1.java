package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import com.tencent.luggage.wxa.dc.o;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$fillData$1$1$1$1"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$fillData$$inlined$let$lambda$1$1$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super s>, Object>
{
  int a;
  private CoroutineScope c;
  
  WxaProfileActivity$fillData$$inlined$let$lambda$1$1$1(WxaProfileActivity.fillData..inlined.let.lambda.1.1 param1, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.b, paramContinuation);
    paramContinuation.c = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.a == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.c;
      WxaProfileActivity.fillData..inlined.let.lambda.1.1.1.1 local1 = new WxaProfileActivity.fillData..inlined.let.lambda.1.1.1.1(this);
      s locals = local1.invoke();
      paramObject = locals;
      if (locals == null)
      {
        paramObject = o.b(this.b.e.c);
        u.a().a(this.b.e.c, paramObject);
        paramObject = local1.invoke();
      }
      return paramObject;
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.fillData..inlined.let.lambda.1.1.1
 * JD-Core Version:    0.7.0.1
 */