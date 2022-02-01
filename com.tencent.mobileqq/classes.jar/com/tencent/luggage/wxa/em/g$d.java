package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess$preloadPage$2$1"}, k=3, mv={1, 1, 16})
final class g$d
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope e;
  
  g$d(Continuation paramContinuation1, Continuation paramContinuation2, g paramg)
  {
    super(2, paramContinuation2);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new d(this.c, paramContinuation, this.d);
    paramContinuation.e = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((d)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.b;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localObject1 = (CoroutineScope)this.a;
            ResultKt.throwOnFailure(paramObject);
            break label377;
          }
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        localObject1 = (CoroutineScope)this.a;
        ResultKt.throwOnFailure(paramObject);
        break label292;
      }
      localObject1 = (CoroutineScope)this.a;
      ResultKt.throwOnFailure(paramObject);
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject1 = this.e;
      d.a(g.a(this.d), a.u);
      paramObject = this.d;
      localObject3 = (Function0)new g.d.1(this);
      this.a = localObject1;
      this.b = 1;
      paramObject = paramObject.a((Function0)localObject3, this);
      if (paramObject == localObject2) {
        return localObject2;
      }
    }
    paramObject = (c)paramObject;
    if (paramObject != null)
    {
      g.f();
      o.d("WxaRuntimeBoostPrepareProcess", "use preloadPage");
      d.b(g.a(this.d), a.u);
      localObject1 = this.c;
      localObject2 = Result.Companion;
      ((Continuation)localObject1).resumeWith(Result.constructor-impl(paramObject));
      return Unit.INSTANCE;
    }
    d.b(g.a(this.d), a.u);
    paramObject = localObject1;
    if (!g.d(this.d))
    {
      d.a(g.a(this.d), a.j);
      paramObject = (CoroutineContext)Dispatchers.getIO();
      localObject3 = (Function2)new g.d.2(this, null);
      this.a = localObject1;
      this.b = 2;
      if (BuildersKt.withContext(paramObject, (Function2)localObject3, this) == localObject2) {
        return localObject2;
      }
      label292:
      d.b(g.a(this.d), a.j);
      paramObject = localObject1;
    }
    d.a(g.a(this.d), a.v);
    g.f();
    o.d("WxaRuntimeBoostPrepareProcess", "not use preloadPage");
    Object localObject1 = (CoroutineContext)Dispatchers.getMain();
    Object localObject3 = (Function2)new g.d.3(this, null);
    this.a = paramObject;
    this.b = 3;
    if (BuildersKt.withContext((CoroutineContext)localObject1, (Function2)localObject3, this) == localObject2) {
      return localObject2;
    }
    label377:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.d
 * JD-Core Version:    0.7.0.1
 */