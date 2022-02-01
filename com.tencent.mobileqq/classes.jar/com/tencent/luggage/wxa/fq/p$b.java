package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.ea.g;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "enTypeOrdinal", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResult;", "invoke"}, k=3, mv={1, 1, 16})
final class p$b<InputType, ResultType>
  implements com.tencent.luggage.wxa.hj.c<b, PreloadWxaProcessEnvResult>
{
  public static final b a = new b();
  
  public final void a(b paramb, @Nullable e<PreloadWxaProcessEnvResult> parame)
  {
    g localg = g.values()[paramb.a];
    int i = q.a[localg.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        o.b("WxaProcessPreloaderService", "preloadNextProcess(wxa) invalid type");
        if (parame != null) {
          parame.a(PreloadWxaProcessEnvResult.Preload_Fail);
        }
        return;
      }
      paramb = (com.tencent.luggage.wxa.en.a)com.tencent.luggage.wxa.fk.c.a;
    }
    else
    {
      paramb = (com.tencent.luggage.wxa.en.a)com.tencent.luggage.wxa.fk.a.a;
    }
    BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new p.b.1(localg, parame, paramb, null), 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.p.b
 * JD-Core Version:    0.7.0.1
 */