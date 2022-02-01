package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.c;
import com.tencent.luggage.wxa.jj.s.c.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.standalone_open_runtime.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$fillData$1$1$1"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$fillData$$inlined$let$lambda$1$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  Object c;
  int d;
  private CoroutineScope f;
  
  WxaProfileActivity$fillData$$inlined$let$lambda$1$1(WxaProfileActivity.fillData..inlined.let.lambda.1 param1, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.e, paramContinuation);
    paramContinuation.f = ((CoroutineScope)paramObject);
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
    int i = this.d;
    Object localObject2 = null;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject1 = (WxaProfileActivity)this.c;
          localObject2 = (s)this.b;
          localObject2 = (CoroutineScope)this.a;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = paramObject;
          break label431;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject1 = (CoroutineScope)this.a;
      ResultKt.throwOnFailure(paramObject);
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject1 = this.f;
      paramObject = (CoroutineContext)Dispatchers.getIO();
      localObject3 = (Function2)new WxaProfileActivity.fillData..inlined.let.lambda.1.1.1(this, null);
      this.a = localObject1;
      this.d = 1;
      localObject3 = BuildersKt.withContext(paramObject, (Function2)localObject3, this);
      paramObject = localObject3;
      if (localObject3 == localObject4) {
        return localObject4;
      }
    }
    s locals = (s)paramObject;
    paramObject = localObject2;
    if (locals != null)
    {
      paramObject = locals.e;
      localObject2 = "";
      if (paramObject == null) {
        paramObject = "";
      }
      WxaProfileActivity.c(this.e.d, paramObject);
      paramObject = locals.g;
      if (paramObject == null) {
        paramObject = "";
      }
      WxaProfileActivity.d(this.e.d, paramObject);
      paramObject = locals.k;
      if (paramObject == null) {
        paramObject = "";
      }
      WxaProfileActivity.e(this.e.d, paramObject);
      i = ((Number)Boxing.boxInt(locals.d().a.w)).intValue();
      WxaProfileActivity.a(this.e.d, i);
    }
    try
    {
      if (!af.c(locals.m))
      {
        paramObject = new JSONObject(locals.m).optString("RegisterBody", "");
        localObject3 = this.e.d;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "it");
        WxaProfileActivity.f((WxaProfileActivity)localObject3, paramObject);
      }
    }
    catch (Exception paramObject)
    {
      label339:
      String str;
      break label339;
    }
    WxaProfileActivity.g(this.e.d, d.a(locals.d().b));
    Object localObject3 = this.e.d;
    str = locals.c;
    paramObject = localObject2;
    if (str != null) {
      paramObject = str;
    }
    this.a = localObject1;
    this.b = locals;
    this.c = localObject3;
    this.d = 2;
    localObject2 = a.a(paramObject, this);
    if (localObject2 == localObject4) {
      return localObject4;
    }
    paramObject = localObject3;
    Object localObject1 = paramObject;
    label431:
    WxaProfileActivity.a((WxaProfileActivity)localObject1, ((Number)localObject2).doubleValue());
    paramObject = Unit.INSTANCE;
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.fillData..inlined.let.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */