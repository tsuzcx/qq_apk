package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.nf;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.opensdk.OpenSDKTicketTransferResponseStepChecker$startCheck$2", f="OpenSDKTicketTransferProtocol.kt", i={0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l={427, 432}, m="invokeSuspend", n={"$this$launch", "$this$forEach$iv", "element$iv", "step", "$fun$logi$1", "$fun$loge$2", "$this$launch", "$this$forEach$iv", "element$iv", "step", "$fun$logi$1", "$fun$loge$2"}, s={"L$0", "L$1", "L$3", "I$2", "L$4", "L$5", "L$0", "L$1", "L$3", "I$2", "L$4", "L$5"})
final class j$e
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  Object c;
  Object d;
  Object e;
  Object f;
  int g;
  int h;
  int i;
  int j;
  private CoroutineScope l;
  
  j$e(j paramj, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new e(this.k, paramContinuation);
    paramContinuation.l = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((e)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int m = this.j;
    Object localObject6;
    Object localObject8;
    Object localObject2;
    int n;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    Object localObject7;
    int i1;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m == 2)
        {
          localObject6 = (j.e.b)this.f;
          localObject8 = (j.e.a)this.e;
          m = this.i;
          localObject2 = (Integer)this.d;
          m = this.h;
          n = this.g;
          localObject5 = (Integer[])this.c;
          localObject3 = (Integer[])this.b;
          localObject4 = (CoroutineScope)this.a;
          ResultKt.throwOnFailure(paramObject);
          localObject7 = paramObject;
          localObject2 = localObject1;
          paramObject = this;
          localObject1 = localObject8;
          break label551;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject3 = (j.e.b)this.f;
      localObject8 = (j.e.a)this.e;
      i1 = this.i;
      localObject7 = (Integer)this.d;
      m = this.h;
      n = this.g;
      localObject6 = (Integer[])this.c;
      localObject5 = (Integer[])this.b;
      localObject2 = (CoroutineScope)this.a;
      ResultKt.throwOnFailure(paramObject);
      localObject4 = localObject1;
      paramObject = this;
      localObject1 = localObject8;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject5 = this.l;
      j.c();
      localObject4 = j.b();
      n = localObject4.length;
      m = 0;
      localObject3 = localObject4;
      paramObject = this;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
    }
    while (m < n)
    {
      localObject7 = localObject1[m];
      i1 = ((Number)localObject7).intValue();
      if (!CoroutineScopeKt.isActive((CoroutineScope)localObject4)) {
        return Unit.INSTANCE;
      }
      localObject8 = new j.e.a(i1, paramObject, (CoroutineScope)localObject4);
      Object localObject9 = new j.e.b(i1, paramObject, (CoroutineScope)localObject4);
      long l1 = i1;
      paramObject.a = localObject4;
      paramObject.b = localObject3;
      paramObject.c = localObject1;
      paramObject.g = n;
      paramObject.h = m;
      paramObject.d = localObject7;
      paramObject.i = i1;
      paramObject.e = localObject8;
      paramObject.f = localObject9;
      paramObject.j = 1;
      if (DelayKt.delay(l1 * 1000L, paramObject) == localObject2) {
        return localObject2;
      }
      localObject5 = localObject4;
      localObject6 = localObject3;
      localObject3 = localObject9;
      localObject4 = localObject2;
      localObject2 = localObject5;
      localObject5 = localObject6;
      localObject6 = localObject1;
      localObject1 = localObject8;
      if (!CoroutineScopeKt.isActive((CoroutineScope)localObject2)) {
        return Unit.INSTANCE;
      }
      localObject8 = paramObject.k;
      paramObject.a = localObject2;
      paramObject.b = localObject5;
      paramObject.c = localObject6;
      paramObject.g = n;
      paramObject.h = m;
      paramObject.d = localObject7;
      paramObject.i = i1;
      paramObject.e = localObject1;
      paramObject.f = localObject3;
      paramObject.j = 2;
      localObject9 = ((j)localObject8).a(paramObject);
      if (localObject9 == localObject4) {
        return localObject4;
      }
      localObject7 = localObject6;
      localObject8 = localObject4;
      localObject6 = localObject3;
      localObject4 = localObject2;
      localObject2 = localObject8;
      localObject3 = localObject5;
      localObject5 = localObject7;
      localObject7 = localObject9;
      label551:
      localObject7 = (nf)localObject7;
      if (localObject7 != null)
      {
        localObject8 = Boxing.boxInt(((nf)localObject7).a);
        if (localObject8 != null)
        {
          i1 = ((Integer)localObject8).intValue();
          break label591;
        }
      }
      i1 = -1;
      label591:
      if (i1 == 3)
      {
        if (localObject7 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((nf)localObject7).b.d();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("get FINISHED, callback data:");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((j.e.a)localObject1).a(((StringBuilder)localObject3).toString());
        paramObject = j.e(paramObject.k);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        return paramObject.invoke(localObject2);
      }
      if (i1 == 4)
      {
        ((j.e.b)localObject6).a("get EXPIRED");
        return j.f(paramObject.k).invoke(new TimeoutException());
      }
      if (i1 == 2)
      {
        ((j.e.a)localObject1).a("get CONSUMED");
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get UNKNOWN(");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(')');
        ((j.e.b)localObject6).a(((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject5;
      m += 1;
    }
    j.c();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startCheck(), steps tried and timeout finally, request:");
    ((StringBuilder)localObject1).append(j.c(paramObject.k));
    ((StringBuilder)localObject1).append(", ticket:");
    ((StringBuilder)localObject1).append(j.d(paramObject.k));
    o.d("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", ((StringBuilder)localObject1).toString());
    return j.f(paramObject.k).invoke(new TimeoutException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.j.e
 * JD-Core Version:    0.7.0.1
 */