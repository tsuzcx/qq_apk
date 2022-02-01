package com.tencent.luggage.ui;

import com.tencent.luggage.util.f;
import com.tencent.luggage.wxa.rt.i;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$1$1$1$succeed$1", "com/tencent/luggage/ui/WxaPreviewImageUI$$special$$inlined$apply$lambda$1$1"}, k=3, mv={1, 1, 16})
final class WxaPreviewImageUI$b$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Boolean>, Object>
{
  Object a;
  int b;
  private CoroutineScope e;
  
  WxaPreviewImageUI$b$1(WxaPreviewImageUI.b paramb, i parami, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.c, this.d, paramContinuation);
    paramContinuation.e = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
    paramObject = this.e;
    f localf = f.a;
    String str1 = this.c.e;
    String str2 = this.d.l();
    Intrinsics.checkExpressionValueIsNotNull(str2, "filePath.absolutePath");
    this.a = paramObject;
    this.b = 1;
    paramObject = localf.a(str1, str2, this);
    if (paramObject == localObject) {
      return localObject;
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.b.1
 * JD-Core Version:    0.7.0.1
 */