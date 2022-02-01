package com.tencent.luggage.wxa.em;

import com.tencent.luggage.standalone_ext.service.a;
import com.tencent.mm.plugin.appbrand.appcache.r;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.standalone_ext.WxaRuntimeBoostPrepareProcess$prepare$1", f="WxaRuntimeBoostPrepareProcess.kt", i={0, 0, 0, 1, 1, 1}, l={65, 66}, m="invokeSuspend", n={"$this$launch", "service", "page", "$this$launch", "service", "page"}, s={"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class g$f
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  Object c;
  Object d;
  int e;
  private CoroutineScope g;
  
  g$f(g paramg, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new f(this.f, paramContinuation);
    paramContinuation.g = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((f)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.e;
    g localg;
    Object localObject3;
    Object localObject4;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject1 = (g)this.d;
          localObject2 = (Deferred)this.c;
          localObject2 = (Deferred)this.b;
          localObject2 = (CoroutineScope)this.a;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = paramObject;
          break label301;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localg = (g)this.d;
      localObject1 = (Deferred)this.c;
      localObject2 = (Deferred)this.b;
      localObject3 = (CoroutineScope)this.a;
      ResultKt.throwOnFailure(paramObject);
      localObject4 = paramObject;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.g;
      r.a.a();
      localObject2 = BuildersKt.async$default(paramObject, null, null, (Function2)new g.f.b(this, null), 3, null);
      localObject1 = BuildersKt.async$default(paramObject, null, null, (Function2)new g.f.a(this, null), 3, null);
      localg = this.f;
      this.a = paramObject;
      this.b = localObject2;
      this.c = localObject1;
      this.d = localg;
      this.e = 1;
      localObject4 = ((Deferred)localObject2).await(this);
      if (localObject4 == localObject5) {
        return localObject5;
      }
      localObject3 = paramObject;
    }
    g.a(localg, (a)localObject4);
    paramObject = this.f;
    this.a = localObject3;
    this.b = localObject2;
    this.c = localObject1;
    this.d = paramObject;
    this.e = 2;
    Object localObject2 = ((Deferred)localObject1).await(this);
    if (localObject2 == localObject5) {
      return localObject5;
    }
    Object localObject1 = paramObject;
    label301:
    g.a((g)localObject1, (c)localObject2);
    this.f.g();
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g.f
 * JD-Core Version:    0.7.0.1
 */