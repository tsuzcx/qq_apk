package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/OpenSDKTicketTransferProtocol$RealCall;", "", "request", "Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;", "(Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;)V", "endCallback", "Lkotlin/Function1;", "", "", "loadingProgressDialog", "Lcom/tencent/luggage/opensdk/OpenSDKTicketTransferDelayRevealDialog;", "sessionExpireTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "dismissAlert", "execute", "block", "loge", "message", "logi", "stopTimer", "makeCallbackStr", "reason", "values", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class i$b
{
  private Function1<? super String, Unit> a;
  private v b;
  private h c;
  private final a.c d;
  
  public i$b(@NotNull a.c paramc)
  {
    this.d = paramc;
  }
  
  private final String a(@NotNull a.c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    Object localObject = paramc.a.a(paramc.b);
    if (localObject != null)
    {
      paramc = ((m)localObject).a(paramString, paramMap);
      Intrinsics.checkExpressionValueIsNotNull(paramc, "apiInst.makeReturnJson(reason, values)");
      return paramc;
    }
    if (paramMap == null) {
      paramMap = MapsKt.emptyMap();
    }
    paramMap = new JSONObject(paramMap);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramc.b);
    ((StringBuilder)localObject).append(':');
    ((StringBuilder)localObject).append(paramString);
    paramMap.put("errMsg", ((StringBuilder)localObject).toString());
    paramc = paramMap.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "JSONObject(values.orEmpt…             }.toString()");
    return paramc;
  }
  
  private final void a()
  {
    if (((b)this).b != null)
    {
      v localv = this.b;
      if (localv == null) {
        Intrinsics.throwUninitializedPropertyAccessException("sessionExpireTimer");
      }
      localv.c();
    }
  }
  
  private final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call{");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}, ");
    localStringBuilder.append(paramString);
    o.b("Luggage.WXA.OpenSDKTicketTransferProtocol", localStringBuilder.toString());
  }
  
  private final void b()
  {
    if (((b)this).c != null)
    {
      h localh = this.c;
      if (localh == null) {
        Intrinsics.throwUninitializedPropertyAccessException("loadingProgressDialog");
      }
      localh.dismiss();
    }
  }
  
  public final void a(@NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    this.a = ((Function1)new i.b.a(this, paramFunction1));
    com.tencent.luggage.wxa.ro.h.a().a((com.tencent.luggage.wxa.rm.b)this.d.a).d((com.tencent.luggage.wxa.rl.b)new i.b.b(this)).b((com.tencent.luggage.wxa.rl.b)new i.b.c(this)).b((com.tencent.luggage.wxa.rl.b)new i.b.d(this)).b((com.tencent.luggage.wxa.rl.b)new i.b.e(this)).a((com.tencent.luggage.wxa.rl.b)new i.b.f(this)).a((e.c)new i.b.g(this)).a((e.a)new i.b.h(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b
 * JD-Core Version:    0.7.0.1
 */