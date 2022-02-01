package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.qw.fb;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/launch/SubProcessLaunchWxaApp$callSuspended$2$1$2"}, k=3, mv={1, 1, 16})
final class j$c$2
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope d;
  
  j$c$2(j.c paramc, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 2(this.c, paramContinuation);
    paramContinuation.d = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
      break label100;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.d;
      localObject1 = this.c.h;
      d locald = this.c.i;
      this.a = paramObject;
      this.b = 1;
      localObject1 = ((j)localObject1).a(locald, false, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
      label100:
      paramObject = (fb)paramObject;
      com.tencent.luggage.wxa.nl.o.a().a(this.c.i.aa(), paramObject);
      localObject1 = m.a.a(paramObject.a);
      if (localObject1 != null)
      {
        ((m)localObject1).a(this.c.i);
      }
      else
      {
        paramObject = paramObject.b;
        if (paramObject != null) {
          this.c.i.c((Runnable)new j.c.2.1(paramObject, this));
        }
      }
    }
    catch (Throwable paramObject)
    {
      j.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getLaunchPBFromCGI async, get invoke exception:");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(", instanceId:");
      ((StringBuilder)localObject1).append(this.c.d);
      com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.SubProcessLaunchWxaApp", ((StringBuilder)localObject1).toString());
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.j.c.2
 * JD-Core Version:    0.7.0.1
 */