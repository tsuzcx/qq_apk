package com.tencent.luggage.wxa.fw;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxapkg.WxaRuntimePkgDownloader$downloadForPkgFetcher$1$1$downloadResult$1$1", f="WxaRuntimePkgDownloader.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class c$b$1$a$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Integer>, Object>
{
  int a;
  private CoroutineScope c;
  
  c$b$1$a$1(c.b.1.a parama, Continuation paramContinuation)
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
    }
    try
    {
      paramObject = c.a.a;
      String str1 = this.b.c.d.e;
      String str2 = this.b.d;
      if (str2 == null) {
        Intrinsics.throwNpe();
      }
      i = paramObject.a(str1, str2);
    }
    catch (Exception paramObject)
    {
      int i;
      label66:
      break label66;
    }
    i = 2147483647;
    return Boxing.boxInt(i);
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.c.b.1.a.1
 * JD-Core Version:    0.7.0.1
 */