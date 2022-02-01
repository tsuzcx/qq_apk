package com.tencent.luggage.wxa.cx;

import com.tencent.mm.plugin.appbrand.appcache.af;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.launch.WxaLaunchPrepareProcess$Loader$execute$1$stepGetCode$1", f="WxaLaunchPrepareProcess.kt", i={0}, l={77}, m="invokeSuspend", n={"$this$async"}, s={"L$0"})
final class s$b$b$a
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super af>, Object>
{
  Object a;
  int b;
  private CoroutineScope d;
  
  s$b$b$a(s.b.b paramb, Continuation paramContinuation)
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
    s.b localb = this.c.f;
    this.a = paramObject;
    this.b = 1;
    paramObject = localb.a(this);
    if (paramObject == localObject) {
      return localObject;
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b.b.a
 * JD-Core Version:    0.7.0.1
 */