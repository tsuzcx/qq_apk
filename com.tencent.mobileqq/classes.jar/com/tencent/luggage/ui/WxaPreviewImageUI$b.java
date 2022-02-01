package com.tencent.luggage.ui;

import com.tencent.luggage.widget.a;
import com.tencent.luggage.widget.c;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$1$1$1", "com/tencent/luggage/ui/WxaPreviewImageUI$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class WxaPreviewImageUI$b
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  int c;
  private CoroutineScope g;
  
  WxaPreviewImageUI$b(c paramc, Continuation paramContinuation, String paramString, WxaPreviewImageUI paramWxaPreviewImageUI)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new b(this.d, paramContinuation, this.e, this.f);
    paramContinuation.g = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((b)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.c;
    Object localObject2;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (i)this.b;
        localObject2 = (CoroutineScope)this.a;
        ResultKt.throwOnFailure(paramObject);
        localObject2 = paramObject;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.g;
      paramObject = new i(WxaPreviewImageUI.a.a(WxaPreviewImageUI.a), String.valueOf(this.e.hashCode()));
      CoroutineContext localCoroutineContext = (CoroutineContext)Dispatchers.getIO();
      Function2 localFunction2 = (Function2)new WxaPreviewImageUI.b.1(this, paramObject, null);
      this.a = localObject2;
      this.b = paramObject;
      this.c = 1;
      localObject2 = BuildersKt.withContext(localCoroutineContext, localFunction2, this);
      if (localObject2 == localObject1) {
        return localObject1;
      }
      localObject1 = paramObject;
    }
    if (((Boolean)localObject2).booleanValue()) {
      this.d.setImage(a.a(k.c(((i)localObject1).l(), false)));
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.b
 * JD-Core Version:    0.7.0.1
 */