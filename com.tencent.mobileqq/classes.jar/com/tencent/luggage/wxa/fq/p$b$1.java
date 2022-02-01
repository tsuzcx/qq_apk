package com.tencent.luggage.wxa.fq;

import android.content.Context;
import com.tencent.luggage.wxa.ea.g;
import com.tencent.luggage.wxa.en.a;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
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
@DebugMetadata(c="com.tencent.luggage.wxaapi.internal.WxaProcessPreloaderService$preloadNextProcess$1$1", f="WxaProcessPreloaderService.kt", i={0, 0}, l={69}, m="invokeSuspend", n={"$this$launch", "applicationContext"}, s={"L$0", "L$1"})
final class p$b$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  int c;
  private CoroutineScope g;
  
  p$b$1(g paramg, e parame, a parama, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.d, this.e, this.f, paramContinuation);
    paramContinuation.g = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.c;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (Context)this.b;
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
      paramObject = this.g;
      localObject1 = r.a();
      if (localObject1 == null)
      {
        paramObject = new StringBuilder();
        paramObject.append("preloadNextProcess(wxa) type:");
        paramObject.append(this.d);
        paramObject.append(", MMApplicationContext.getContext()==NULL");
        o.b("WxaProcessPreloaderService", paramObject.toString());
        paramObject = this.e;
        if (paramObject == null) {
          break label243;
        }
        paramObject.a(PreloadWxaProcessEnvResult.Preload_Fail);
        break label243;
      }
      p localp = p.a;
      a locala = this.f;
      this.a = paramObject;
      this.b = localObject1;
      this.c = 1;
      localObject1 = localp.a(locala, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    paramObject = (PreloadWxaProcessEnvResult)paramObject;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("preloadNextProcess(wxa) type:");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append(", result:");
    ((StringBuilder)localObject1).append(paramObject);
    o.d("WxaProcessPreloaderService", ((StringBuilder)localObject1).toString());
    localObject1 = this.e;
    if (localObject1 != null) {
      ((e)localObject1).a(paramObject);
    }
    label243:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.p.b.1
 * JD-Core Version:    0.7.0.1
 */