package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.gv;
import com.tencent.luggage.wxa.qw.gw;
import com.tencent.luggage.wxa.qw.mx;
import com.tencent.luggage.wxa.ro.d;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/CgiWxaRealtimeReportRoute;", "", "infoList", "", "Lcom/tencent/mm/protocal/protobuf/WxaRealTimeReportInfo;", "(Ljava/util/List;)V", "getInfoList", "()Ljava/util/List;", "pipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Lcom/tencent/mm/protocal/protobuf/RouteResponse;", "run", "Constants", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  private d<gw> a;
  @NotNull
  private final List<mx> b;
  
  public a(@NotNull List<? extends mx> paramList)
  {
    this.b = paramList;
  }
  
  @NotNull
  public final d<gw> a()
  {
    try
    {
      if (((a)this).a != null)
      {
        localObject1 = this.a;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("pipeline");
        }
        return localObject1;
      }
      Object localObject1 = (b)e.a(b.class);
      if (localObject1 != null)
      {
        gv localgv = new gv();
        localgv.a.addAll((Collection)CollectionsKt.filterNotNull((Iterable)this.b));
        localObject1 = ((b)localObject1).b("/cgi-bin/mmbiz-bin/wxartrappsvr/route", null, (com.tencent.luggage.wxa.qu.a)localgv, gw.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "cgiService.syncPipeline(…outeResponse::class.java)");
        this.a = ((d)localObject1);
        localObject1 = this.a;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("pipeline");
        }
        return localObject1;
      }
      localObject1 = ((Function0)a.a.a).invoke();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "{\n                QuickA…        }\n            }()");
      localObject1 = (d)localObject1;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.a
 * JD-Core Version:    0.7.0.1
 */