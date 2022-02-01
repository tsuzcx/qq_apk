package com.tencent.luggage.wxa.fq;

import android.content.Context;
import java.util.Map;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/wxaapi/internal/DemoScan$QRCodeHandleResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxaapi.internal.DemoScan$byQRRawData$1$result$1", f="DemoScan.kt", i={0}, l={63}, m="invokeSuspend", n={"$this$withContext"}, s={"L$0"})
final class b$b$a
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super b.a>, Object>
{
  Object a;
  int b;
  private CoroutineScope d;
  
  b$b$a(b.b paramb, Continuation paramContinuation)
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
    b localb = b.a;
    Context localContext = this.c.c;
    String str = this.c.d;
    Map localMap = this.c.e;
    long l = this.c.f;
    this.a = paramObject;
    this.b = 1;
    paramObject = b.a(localb, localContext, str, 0, 0, localMap, l, this, 12, null);
    if (paramObject == localObject) {
      return localObject;
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.b.b.a
 * JD-Core Version:    0.7.0.1
 */