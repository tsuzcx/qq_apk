package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "bool", "", "str", "", "invoke"}, k=3, mv={1, 1, 16})
final class g$f
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  g$f(Continuation paramContinuation)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "str");
    g.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkAuthStateSuspended()-waitForUserLoginDone, get bool:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", str:");
    ((StringBuilder)localObject).append(paramString);
    o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (paramBoolean) {
      paramString = TdiAuthState.WechatTdi_Auth_State_OK;
    } else {
      paramString = TdiAuthState.WechatTdi_Auth_State_NoAuth;
    }
    Result.Companion localCompanion = Result.Companion;
    ((Continuation)localObject).resumeWith(Result.constructor-impl(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.f
 * JD-Core Version:    0.7.0.1
 */