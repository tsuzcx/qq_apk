package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.rm.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/OpenSDKTicketTransferResponseStepChecker;", "", "request", "Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;", "ticket", "", "onSuccess", "Lkotlin/Function1;", "", "onError", "(Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "job", "Lkotlinx/coroutines/Job;", "checkTicketResponse", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeGetDeeplinkInfoResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCheck", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class j
{
  @Deprecated
  public static final j.a a = new j.a(null);
  private static final Integer[] g = { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(5) };
  private Job b;
  private final a.c c;
  private final String d;
  private final Function1<String, Unit> e;
  private final Function1<Object, Unit> f;
  
  public j(@NotNull a.c paramc, @NotNull String paramString, @NotNull Function1<? super String, Unit> paramFunction1, @NotNull Function1<Object, Unit> paramFunction11)
  {
    this.c = paramc;
    this.d = paramString;
    this.e = paramFunction1;
    this.f = paramFunction11;
  }
  
  public final void a()
  {
    this.c.a.a((a)new j.d(this));
    this.b = BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new j.e(this, null), 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.j
 * JD-Core Version:    0.7.0.1
 */