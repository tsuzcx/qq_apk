package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.g;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.launch.WxaLaunchPrepareProcess$Loader$execute$1", f="WxaLaunchPrepareProcess.kt", i={0, 0, 0, 1, 1, 1, 1}, l={81, 87}, m="invokeSuspend", n={"$this$launch", "stepGetCode", "stepGetLaunch", "$this$launch", "stepGetCode", "stepGetLaunch", "wxaPkgWrappingInfo"}, s={"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
final class s$b$b
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  Object c;
  Object d;
  int e;
  private CoroutineScope g;
  
  s$b$b(s.b paramb, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new b(this.f, paramContinuation);
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
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.e;
    Object localObject2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject2 = (com.tencent.mm.plugin.appbrand.appcache.af)this.d;
          localObject1 = (Deferred)this.c;
          localObject1 = (Deferred)this.b;
          localObject1 = (CoroutineScope)this.a;
          try
          {
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          catch (Exception paramObject)
          {
            break label546;
          }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject3 = (Deferred)this.c;
      localObject1 = (Deferred)this.b;
      CoroutineScope localCoroutineScope = (CoroutineScope)this.a;
      try
      {
        ResultKt.throwOnFailure(paramObject);
        localObject2 = paramObject;
        paramObject = localObject3;
        localObject3 = localObject2;
        localObject2 = localCoroutineScope;
      }
      catch (Exception paramObject)
      {
        break label676;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.g;
      if (s.b.c(this.f).K() == null)
      {
        com.tencent.mm.plugin.appbrand.keylogger.d.a(s.b.d(this.f), a.t);
        r.a.a();
        s.b.c(this.f).a(r.b());
        com.tencent.mm.plugin.appbrand.keylogger.d.b(s.b.d(this.f), a.t);
      }
      paramObject = this.f;
      localObject1 = u.a().b(s.b.d(this.f), new String[0]);
      if (localObject1 == null) {
        break label806;
      }
      s.b.a(paramObject, (s)localObject1);
      localObject1 = BuildersKt.async$default((CoroutineScope)localObject2, ((CoroutineScope)localObject2).getCoroutineContext(), null, (Function2)new s.b.b.a(this, null), 2, null);
      paramObject = BuildersKt.async$default((CoroutineScope)localObject2, ((CoroutineScope)localObject2).getCoroutineContext(), null, (Function2)new s.b.b.b(this, null), 2, null);
      this.a = localObject2;
      this.b = localObject1;
      this.c = paramObject;
      this.e = 1;
      localObject3 = ((Deferred)localObject1).await(this);
      if (localObject3 != localObject4) {
        break label931;
      }
      return localObject4;
    }
    Object localObject3 = (com.tencent.mm.plugin.appbrand.appcache.af)localObject3;
    this.a = localObject2;
    this.b = localObject1;
    this.c = paramObject;
    this.d = localObject3;
    this.e = 2;
    Object localObject1 = paramObject.await(this);
    if (localObject1 == localObject4) {
      return localObject4;
    }
    for (;;)
    {
      localObject1 = (fb)localObject1;
      paramObject = f.a(s.b.d(this.f), s.b.e(this.f), paramObject, (fb)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("execute --END-- |instance:");
      ((StringBuilder)localObject1).append(s.b.a(this.f));
      ((StringBuilder)localObject1).append(", appId:");
      ((StringBuilder)localObject1).append(s.b.d(this.f));
      ((StringBuilder)localObject1).append(", versionType:");
      ((StringBuilder)localObject1).append(s.b.f(this.f));
      ((StringBuilder)localObject1).append(", ts:");
      ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.qz.af.d());
      o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", ((StringBuilder)localObject1).toString());
      localObject1 = s.b.b(this.f);
      if (localObject1 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "sysConfig");
        ((s.a)localObject1).a(paramObject);
      }
      com.tencent.luggage.wxa.rz.f.a.c((Runnable)new s.b.b.1(this, paramObject));
      return Unit.INSTANCE;
      label546:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("execute --ERROR-- get launchPB failed by ");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(" |instance:");
      ((StringBuilder)localObject1).append(s.b.a(this.f));
      ((StringBuilder)localObject1).append(", appId:");
      ((StringBuilder)localObject1).append(s.b.d(this.f));
      ((StringBuilder)localObject1).append(", versionType:");
      ((StringBuilder)localObject1).append(s.b.f(this.f));
      ((StringBuilder)localObject1).append(", ts:");
      ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.qz.af.d());
      o.b("Luggage.WxaLaunchPrepareProcess|runProfiled", ((StringBuilder)localObject1).toString());
      localObject1 = s.b.b(this.f);
      if (localObject1 != null) {
        ((s.a)localObject1).a((Throwable)paramObject);
      }
      return Unit.INSTANCE;
      label676:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("execute --ERROR-- get wxaPkgWrappingInfo failed by ");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(" |instance:");
      ((StringBuilder)localObject1).append(s.b.a(this.f));
      ((StringBuilder)localObject1).append(", appId:");
      ((StringBuilder)localObject1).append(s.b.d(this.f));
      ((StringBuilder)localObject1).append(", versionType:");
      ((StringBuilder)localObject1).append(s.b.f(this.f));
      ((StringBuilder)localObject1).append(", ts:");
      ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.qz.af.d());
      o.b("Luggage.WxaLaunchPrepareProcess|runProfiled", ((StringBuilder)localObject1).toString());
      localObject1 = s.b.b(this.f);
      if (localObject1 != null) {
        ((s.a)localObject1).a((Throwable)paramObject);
      }
      return Unit.INSTANCE;
      label806:
      paramObject = new StringBuilder();
      paramObject.append("execute --ERROR-- get NULL WxaAttributes |instance:");
      paramObject.append(s.b.a(this.f));
      paramObject.append(", appId:");
      paramObject.append(s.b.d(this.f));
      paramObject.append(", versionType:");
      paramObject.append(s.b.f(this.f));
      paramObject.append(", ts:");
      paramObject.append(com.tencent.luggage.wxa.qz.af.d());
      o.b("Luggage.WxaLaunchPrepareProcess|runProfiled", paramObject.toString());
      paramObject = s.b.b(this.f);
      if (paramObject != null) {
        paramObject.a((Throwable)new NullPointerException("WxaAttributes is NULL"));
      }
      return Unit.INSTANCE;
      label931:
      break;
      paramObject = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b.b
 * JD-Core Version:    0.7.0.1
 */