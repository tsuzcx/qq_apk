package com.tencent.luggage.wxa.fq;

import android.content.Context;
import com.tencent.luggage.wxa.ft.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxaapi.internal.DemoScan$byQRRawData$1", f="DemoScan.kt", i={0}, l={62}, m="invokeSuspend", n={"$this$launch"}, s={"L$0"})
final class b$b
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope g;
  
  b$b(Context paramContext, String paramString, Map paramMap, long paramLong, Continuation paramContinuation)
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
      break label109;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.g;
      localObject1 = (CoroutineContext)Dispatchers.getIO();
      Function2 localFunction2 = (Function2)new b.b.a(this, null);
      this.a = paramObject;
      this.b = 1;
      localObject1 = BuildersKt.withContext((CoroutineContext)localObject1, localFunction2, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
      label109:
      paramObject = (b.a)paramObject;
      if ((paramObject instanceof b.a.a)) {
        a.a.a(this.f, ((b.a.a)paramObject).a());
      } else {
        boolean bool = paramObject instanceof b.a.b;
      }
    }
    catch (Exception paramObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("byQRRawData, get exception:");
      ((StringBuilder)localObject1).append(paramObject);
      o.b("Luggage.WXA.DemoScan", ((StringBuilder)localObject1).toString());
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.b.b
 * JD-Core Version:    0.7.0.1
 */