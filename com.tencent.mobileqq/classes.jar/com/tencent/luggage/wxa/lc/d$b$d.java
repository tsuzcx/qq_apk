package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.ih.c;
import com.tencent.luggage.wxa.ih.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$b$d
  implements e.c
{
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @Nullable c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.a(paramInt1, paramInt2, paramString, paramc);
  }
  
  public void a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "result");
    if (paramc.k())
    {
      d.b.a(this.a, "cancel", null, 0, 6, null);
      return;
    }
    HashMap localHashMap = new HashMap();
    paramc = ((Iterable)paramc.c()).iterator();
    while (paramc.hasNext())
    {
      d locald = (d)paramc.next();
      ((Map)localHashMap).put(locald.c(), locald.i());
    }
    d.b.a(this.a, "ok", (Map)localHashMap, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.d.b.d
 * JD-Core Version:    0.7.0.1
 */