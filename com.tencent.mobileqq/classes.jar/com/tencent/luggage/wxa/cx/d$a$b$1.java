package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.dc.n;
import com.tencent.luggage.wxa.eo.a;
import com.tencent.luggage.wxa.nl.o;
import com.tencent.luggage.wxa.on.b;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.qw.as;
import com.tencent.luggage.wxa.qw.ez;
import com.tencent.luggage.wxa.qw.fb;
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
@DebugMetadata(c="com.tencent.luggage.launch.CgiLaunchWxaAppForWarmLaunch$Utils$sendWithDefaultHandler$1$1", f="CgiLaunchWxaAppForWarmLaunch.kt", i={0, 0, 0, 0, 0, 0}, l={83}, m="invokeSuspend", n={"$this$withContext", "appId", "username", "versionType", "sessionId", "scene"}, s={"L$0", "L$1", "L$2", "I$0", "L$3", "I$1"})
final class d$a$b$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  Object c;
  Object d;
  int e;
  int f;
  int g;
  private CoroutineScope i;
  
  d$a$b$1(d.a.b paramb, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.h, paramContinuation);
    paramContinuation.i = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int j = this.g;
    if (j != 0) {
      if (j == 1)
      {
        k = this.f;
        localObject3 = (String)this.d;
        j = this.e;
        localObject2 = (String)this.c;
        localObject1 = (String)this.b;
        localObject4 = (CoroutineScope)this.a;
        n = k;
        localObject6 = localObject3;
        m = j;
        localObject5 = localObject2;
        localObject4 = localObject1;
      }
    }
    try
    {
      ResultKt.throwOnFailure(paramObject);
      break label273;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.i;
      localObject1 = this.h.c.aa();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = this.h.c.G().b;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      j = this.h.c.ab();
      localObject3 = this.h.c.G();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "rt.initConfig");
      localObject3 = ((a)localObject3).h();
      k = this.h.c.l().c;
    }
    catch (Exception paramObject)
    {
      label273:
      label299:
      break label317;
    }
    try
    {
      localObject5 = new d(this.h.c);
      this.a = paramObject;
      this.b = localObject1;
      this.c = localObject2;
      this.e = j;
      this.d = localObject3;
      this.f = k;
      this.g = 1;
      paramObject = ((d)localObject5).a(this);
      if (paramObject == localObject4) {
        return localObject4;
      }
      n = k;
      localObject6 = localObject3;
      m = j;
      localObject5 = localObject2;
      localObject4 = localObject1;
      paramObject = (fb)paramObject;
    }
    catch (Exception paramObject)
    {
      break label299;
    }
    int n = k;
    localObject4 = localObject1;
    Object localObject5 = localObject2;
    int m = j;
    Object localObject6 = localObject3;
    label317:
    paramObject = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject5;
    j = m;
    Object localObject3 = localObject6;
    int k = n;
    if (paramObject != null)
    {
      o.a().a((String)localObject1, paramObject);
      localObject4 = paramObject.b;
      if (localObject4 != null)
      {
        localObject5 = this.h.c.a();
        if (localObject5 != null) {
          ((c)localObject5).a(new b((as)localObject4));
        }
      }
      localObject4 = paramObject.a;
      if ((localObject4 != null) && (((ez)localObject4).c == true)) {
        n.a((String)localObject2, (String)localObject1, j, (String)localObject3, k);
      }
      paramObject = m.a.a(paramObject.a);
      if (paramObject != null) {
        paramObject.a(this.h.c);
      }
      return Unit.INSTANCE;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */