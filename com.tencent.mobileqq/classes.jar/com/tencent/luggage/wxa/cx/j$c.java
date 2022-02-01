package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qw.ez;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/launch/SubProcessLaunchWxaApp$callSuspended$2$1"}, k=3, mv={1, 1, 16})
final class j$c
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  int c;
  private CoroutineScope j;
  
  j$c(String paramString, long paramLong1, long paramLong2, Continuation paramContinuation1, Continuation paramContinuation2, j paramj, com.tencent.luggage.wxa.em.d paramd)
  {
    super(2, paramContinuation2);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new c(this.d, this.e, this.f, this.g, paramContinuation, this.h, this.i);
    paramContinuation.j = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((c)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int k = this.c;
    Object localObject2 = null;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2)
        {
          localObject1 = (fb)this.b;
          localObject1 = (CoroutineScope)this.a;
          try
          {
            ResultKt.throwOnFailure(paramObject);
          }
          catch (Exception paramObject)
          {
            break label787;
          }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject3 = (CoroutineScope)this.a;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject3;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.j;
      localObject1 = this.h;
      localObject3 = this.i;
      this.a = paramObject;
      this.c = 1;
      localObject3 = ((j)localObject1).a((com.tencent.luggage.wxa.em.d)localObject3, this);
      localObject1 = localObject3;
      if (localObject3 == localObject4) {
        return localObject4;
      }
    }
    Object localObject1 = (fb)localObject1;
    if (localObject1 != null)
    {
      localObject3 = ((fb)localObject1).a;
      if ((localObject3 != null) && (((ez)localObject3).a == 1))
      {
        paramObject = t.a;
        localObject2 = this.d;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "wxaLaunchInstanceId");
        paramObject.a((String)localObject2, t.d.c, t.c.c, "ASYNC");
        j.a();
        paramObject = new StringBuilder();
        paramObject.append("call --END-- use cache, appId:");
        paramObject.append(this.i.aa());
        paramObject.append(", versionType:");
        paramObject.append(this.i.ab());
        paramObject.append(", ts:");
        paramObject.append(af.d());
        paramObject.append(", cost:");
        paramObject.append(af.b() - this.e);
        com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.SubProcessLaunchWxaApp", paramObject.toString());
        com.tencent.mm.plugin.appbrand.keylogger.d.a(this.i.aa(), a.o, "", this.f, af.d());
        paramObject = this.g;
        localObject2 = Result.Companion;
        paramObject.resumeWith(Result.constructor-impl(localObject1));
        BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, Dispatchers.getIO().plus((CoroutineContext)new j.c.1((CoroutineContext.Key)CoroutineExceptionHandler.Key, this)), null, (Function2)new j.c.2(this, null), 2, null);
        break label954;
      }
    }
    Object localObject3 = this.h;
    com.tencent.luggage.wxa.em.d locald = this.i;
    this.a = paramObject;
    this.b = localObject1;
    this.c = 2;
    localObject1 = ((j)localObject3).a(locald, true, this);
    paramObject = localObject1;
    if (localObject1 == localObject4) {
      return localObject4;
    }
    localObject1 = (fb)paramObject;
    com.tencent.luggage.wxa.nl.o.a().a(this.i.aa(), (fb)localObject1);
    paramObject = t.a;
    localObject3 = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "wxaLaunchInstanceId");
    paramObject.a((String)localObject3, t.d.c, t.c.c, "SYNC");
    localObject3 = m.a;
    paramObject = localObject2;
    if (localObject1 != null) {
      paramObject = ((fb)localObject1).a;
    }
    paramObject = ((m.a)localObject3).a(paramObject);
    if (paramObject != null)
    {
      paramObject.a(this.i);
      j.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("call --END-- use cgi get errorAction, appId:");
      ((StringBuilder)localObject1).append(this.i.aa());
      ((StringBuilder)localObject1).append(", versionType:");
      ((StringBuilder)localObject1).append(this.i.ab());
      ((StringBuilder)localObject1).append(", ts:");
      ((StringBuilder)localObject1).append(af.d());
      ((StringBuilder)localObject1).append(", cost:");
      ((StringBuilder)localObject1).append(af.b() - this.e);
      com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.SubProcessLaunchWxaApp", ((StringBuilder)localObject1).toString());
      localObject1 = this.g;
      localObject2 = Result.Companion;
      ((Continuation)localObject1).resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramObject)));
    }
    else
    {
      j.a();
      paramObject = new StringBuilder();
      paramObject.append("call --END-- use cgi, appId:");
      paramObject.append(this.i.aa());
      paramObject.append(", versionType:");
      paramObject.append(this.i.ab());
      paramObject.append(", ts:");
      paramObject.append(af.d());
      paramObject.append(", cost:");
      paramObject.append(af.b() - this.e);
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.SubProcessLaunchWxaApp", paramObject.toString());
      com.tencent.mm.plugin.appbrand.keylogger.d.a(this.i.aa(), a.p, "", this.f, af.d());
      paramObject = this.g;
      localObject2 = Result.Companion;
      paramObject.resumeWith(Result.constructor-impl(localObject1));
      break label954;
      label787:
      localObject1 = t.a;
      localObject2 = this.d;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "wxaLaunchInstanceId");
      ((t)localObject1).a((String)localObject2, t.d.c, t.c.d, "SYNC");
      j.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("call --ERROR-- use cgi get ");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(", appId:");
      ((StringBuilder)localObject1).append(this.i.aa());
      ((StringBuilder)localObject1).append(", versionType:");
      ((StringBuilder)localObject1).append(this.i.ab());
      ((StringBuilder)localObject1).append(", ts:");
      ((StringBuilder)localObject1).append(af.d());
      ((StringBuilder)localObject1).append(", cost:");
      ((StringBuilder)localObject1).append(af.b() - this.e);
      com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.SubProcessLaunchWxaApp", ((StringBuilder)localObject1).toString());
      localObject1 = this.g;
      localObject2 = Result.Companion;
      ((Continuation)localObject1).resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramObject)));
    }
    label954:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.j.c
 * JD-Core Version:    0.7.0.1
 */