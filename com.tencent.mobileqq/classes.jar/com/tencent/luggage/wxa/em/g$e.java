package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess$preloadService$2$1"}, k=3, mv={1, 1, 16})
final class g$e
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope e;
  
  g$e(Continuation paramContinuation1, Continuation paramContinuation2, g paramg)
  {
    super(2, paramContinuation2);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new e(this.c, paramContinuation, this.d);
    paramContinuation.e = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((e)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.b;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (CoroutineScope)this.a;
        ResultKt.throwOnFailure(paramObject);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.e;
      d.a(g.a(this.d), com.tencent.luggage.wxa.oy.a.w);
      localObject1 = this.d;
      Function0 localFunction0 = (Function0)new g.e.1(this);
      this.a = paramObject;
      this.b = 1;
      localObject1 = ((g)localObject1).a(localFunction0, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    paramObject = (com.tencent.luggage.standalone_ext.service.a)paramObject;
    if (paramObject != null)
    {
      g.f();
      o.d("WxaRuntimeBoostPrepareProcess", "use preloadService");
      d.b(g.a(this.d), com.tencent.luggage.wxa.oy.a.w);
      localObject1 = this.c;
      localObject2 = Result.Companion;
      ((Continuation)localObject1).resumeWith(Result.constructor-impl(paramObject));
      return Unit.INSTANCE;
    }
    d.b(g.a(this.d), com.tencent.luggage.wxa.oy.a.w);
    d.a(g.a(this.d), com.tencent.luggage.wxa.oy.a.x);
    g.f();
    o.d("WxaRuntimeBoostPrepareProcess", "not use preloadService");
    f.a.e((Runnable)new g.e.2(this));
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.e
 * JD-Core Version:    0.7.0.1
 */