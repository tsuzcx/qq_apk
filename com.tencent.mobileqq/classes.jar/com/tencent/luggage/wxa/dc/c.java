package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.rm.b;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/CgiEx;", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/luggage/login/Cgi;", "()V", "<set-?>", "", "appId", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "request", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;)V", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "Ljava/lang/Class;", "responseClazz", "getResponseClazz", "()Ljava/lang/Class;", "setResponseClazz", "(Ljava/lang/Class;)V", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class c<REQUEST extends gt, RESPONSE extends gu>
  extends a<REQUEST, RESPONSE>
{
  @Nullable
  private String a;
  @NotNull
  protected REQUEST c;
  @NotNull
  protected Class<RESPONSE> d;
  
  @Nullable
  public final Object a(@NotNull Continuation<? super RESPONSE> paramContinuation)
  {
    Object localObject = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localObject;
    com.tencent.luggage.wxa.rm.c localc = new com.tencent.luggage.wxa.rm.c();
    a(d(), c(), b()).a((b)localc).a((e.c)new c.a(localCancellableContinuation)).a((e.a)new c.b(localCancellableContinuation));
    localCancellableContinuation.invokeOnCancellation((Function1)new c.c(localc));
    localObject = ((CancellableContinuationImpl)localObject).getResult();
    if (localObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return localObject;
  }
  
  protected final void a(@NotNull REQUEST paramREQUEST)
  {
    Intrinsics.checkParameterIsNotNull(paramREQUEST, "<set-?>");
    this.c = paramREQUEST;
  }
  
  protected final void a(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  @NotNull
  public Class<RESPONSE> b()
  {
    Class localClass = this.d;
    if (localClass == null) {
      Intrinsics.throwUninitializedPropertyAccessException("responseClazz");
    }
    return localClass;
  }
  
  @NotNull
  public final REQUEST c()
  {
    gt localgt = this.c;
    if (localgt == null) {
      Intrinsics.throwUninitializedPropertyAccessException("request");
    }
    return localgt;
  }
  
  @Nullable
  public final String d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.c
 * JD-Core Version:    0.7.0.1
 */