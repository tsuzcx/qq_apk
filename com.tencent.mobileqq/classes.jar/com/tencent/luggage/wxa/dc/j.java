package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.cv.a;
import com.tencent.luggage.wxa.cv.k;
import com.tencent.luggage.wxa.qw.bt;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.hf;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/ScanCodeGetA8Key;", "", "codeData", "", "codeType", "", "codeVersion", "(Ljava/lang/String;II)V", "a8keyRequest", "Lcom/tencent/luggage/jsapi/webview/model/WxaDefGetA8KeyReq;", "getCodeData", "()Ljava/lang/String;", "getCodeType", "()I", "getCodeVersion", "send", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j
{
  private final com.tencent.luggage.wxa.cv.j a;
  @NotNull
  private final String b;
  private final int c;
  private final int d;
  
  public j(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    paramString = new com.tencent.luggage.wxa.cv.j();
    paramString.a();
    paramString.i = 4;
    paramString.r = this.c;
    paramString.s = this.d;
    paramString.f = new hf().a(this.b);
    paramString.a = 2;
    this.a = paramString;
  }
  
  @Nullable
  public final Object a(@NotNull Continuation<? super bt> paramContinuation)
  {
    Object localObject1 = new SafeContinuation(IntrinsicsKt.intercepted(paramContinuation));
    Continuation localContinuation = (Continuation)localObject1;
    k localk = new k();
    Object localObject2 = this.a.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "a8keyRequest.ReqUrl");
    localObject2 = ((hf)localObject2).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "a8keyRequest.ReqUrl.string");
    localk.a((String)localObject2, 0).a((gt)this.a, bt.class).a((e.c)new j.a(localContinuation)).a((e.a)new j.b(localContinuation));
    localObject1 = ((SafeContinuation)localObject1).getOrThrow();
    if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.j
 * JD-Core Version:    0.7.0.1
 */