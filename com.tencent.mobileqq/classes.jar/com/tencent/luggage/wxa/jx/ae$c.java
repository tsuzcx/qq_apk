package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.ah;
import com.tencent.luggage.wxa.qw.ai;
import com.tencent.luggage.wxa.qw.lw;
import com.tencent.luggage.wxa.rp.d;
import com.tencent.luggage.wxa.rp.h;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class ae$c
{
  private final long a;
  private final String b;
  private final int c;
  private final List<String> d;
  private final b e;
  
  public ae$c(@NotNull String paramString, int paramInt, @NotNull List<String> paramList, @NotNull b paramb)
  {
    this.b = paramString;
    this.c = paramInt;
    this.d = paramList;
    this.e = paramb;
    this.a = TimeUnit.MINUTES.toSeconds(5L);
  }
  
  private final void a(@NotNull b paramb, List<? extends lw> paramList, Function1<? super ai, Unit> paramFunction1, Function1<? super String, Unit> paramFunction11)
  {
    paramb = new ah();
    paramb.a.addAll((Collection)paramList);
    paramb.b = 100;
    d.b.a((Runnable)new ae.c.b(this, paramb, paramFunction1, paramFunction11));
  }
  
  public final void a(@NotNull Function1<? super List<s>, Unit> paramFunction11, @NotNull Function1<? super List<s>, Unit> paramFunction12, @NotNull Function0<Unit> paramFunction0, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction11, "onLoaded");
    Intrinsics.checkParameterIsNotNull(paramFunction12, "onUpdated");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onNoUpdate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onError");
    paramFunction11 = new ae.c.a(this, paramFunction1, paramFunction11, paramFunction12, paramFunction0);
    f.a.c((Runnable)paramFunction11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.c
 * JD-Core Version:    0.7.0.1
 */