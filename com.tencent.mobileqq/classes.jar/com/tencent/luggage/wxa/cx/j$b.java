package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.ro.b;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.launch.SubProcessLaunchWxaApp$call$1", f="SubProcessLaunchWxaApp.kt", i={0}, l={106}, m="invokeSuspend", n={"$this$launch"}, s={"L$0"})
final class j$b
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope g;
  
  j$b(j paramj, d paramd, s params, b paramb, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new b(this.c, this.d, this.e, this.f, paramContinuation);
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
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.b;
    Object localObject1;
    if (i != 0) {
      if (i == 1) {
        localObject1 = (CoroutineScope)this.a;
      }
    }
    try
    {
      ResultKt.throwOnFailure(paramObject);
      break label115;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.g;
      localObject1 = this.c;
      d locald = this.d;
      Intrinsics.checkExpressionValueIsNotNull(locald, "rt");
      s locals = this.e;
      Intrinsics.checkExpressionValueIsNotNull(locals, "wxaAttributes");
      this.a = paramObject;
      this.b = 1;
      localObject1 = ((j)localObject1).a(locald, locals, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
      label115:
      paramObject = (fb)paramObject;
      this.f.a(new Object[] { paramObject });
    }
    catch (Throwable paramObject)
    {
      this.f.a(paramObject);
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.j.b
 * JD-Core Version:    0.7.0.1
 */