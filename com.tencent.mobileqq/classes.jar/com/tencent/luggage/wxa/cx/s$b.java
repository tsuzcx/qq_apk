package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.ef.i;
import com.tencent.luggage.wxa.eo.a;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchPrepareProcess$Loader;", "", "runtime", "Lcom/tencent/luggage/standalone_ext/Runtime;", "cb", "Lcom/tencent/luggage/launch/WxaLaunchPrepareProcess$LaunchPrepareCallback;", "(Lcom/tencent/luggage/standalone_ext/Runtime;Lcom/tencent/luggage/launch/WxaLaunchPrepareProcess$LaunchPrepareCallback;)V", "LoaderInstanceId", "", "appId", "", "kotlin.jvm.PlatformType", "enterUrl", "initConfig", "Lcom/tencent/luggage/standalone_ext/config/RuntimeSDKInitConfigBase;", "statObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "versionType", "wxaAttributes", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "wxaInstanceId", "execute", "", "runStepGetCode", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runStepGetLaunch", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class s$b
{
  private final int a;
  private final String b;
  private final int c;
  private final String d;
  private final a e;
  private final com.tencent.luggage.wxa.ou.d f;
  private final String g;
  private s h;
  private final com.tencent.luggage.wxa.em.d i;
  private final s.a j;
  
  public s$b(@NotNull com.tencent.luggage.wxa.em.d paramd, @Nullable s.a parama)
  {
    this.i = paramd;
    this.j = parama;
    this.a = hashCode();
    this.b = this.i.aa();
    this.c = this.i.ab();
    this.d = this.i.as();
    this.e = this.i.G();
    this.f = this.i.l();
    paramd = this.e;
    Intrinsics.checkExpressionValueIsNotNull(paramd, "initConfig");
    this.g = paramd.i();
  }
  
  @Nullable
  public final Object a(@NotNull Continuation<? super com.tencent.mm.plugin.appbrand.appcache.af> paramContinuation)
  {
    Object localObject1 = new SafeContinuation(IntrinsicsKt.intercepted(paramContinuation));
    Continuation localContinuation = (Continuation)localObject1;
    long l = com.tencent.luggage.wxa.qz.af.b();
    Object localObject2 = t.a;
    Object localObject3 = this.g;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "wxaInstanceId");
    t.a((t)localObject2, (String)localObject3, t.d.d, t.c.b, null, 8, null);
    localObject2 = this.i;
    localObject3 = this.h;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaAttributes");
    }
    h.a(localObject2, localObject3).b((b)s.b.f.a).a((e.c)new s.b.d(l, localContinuation, this)).a((e.a)new s.b.e(l, localContinuation, this));
    localObject1 = ((SafeContinuation)localObject1).getOrThrow();
    if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return localObject1;
  }
  
  public final void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("execute --START-- |instance:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", appId:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", versionType:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", ts:");
    ((StringBuilder)localObject).append(com.tencent.luggage.wxa.qz.af.d());
    o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", ((StringBuilder)localObject).toString());
    localObject = (CoroutineExceptionHandler)new s.b.a((CoroutineContext.Key)CoroutineExceptionHandler.Key, this);
    localObject = BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, Dispatchers.getIO().plus((CoroutineContext)localObject), null, (Function2)new s.b.b(this, null), 2, null);
    i.a.a((com.tencent.luggage.wxa.iu.d)this.i, (Function1)new s.b.c((Job)localObject));
  }
  
  @Nullable
  public final Object b(@NotNull Continuation<? super fb> paramContinuation)
  {
    j localj = new j();
    com.tencent.luggage.wxa.em.d locald = this.i;
    s locals = this.h;
    if (locals == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaAttributes");
    }
    return localj.a(locald, locals, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b
 * JD-Core Version:    0.7.0.1
 */