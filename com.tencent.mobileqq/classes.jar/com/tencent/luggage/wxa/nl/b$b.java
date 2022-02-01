package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.ca;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "(I)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", "request", "onSuccess", "onError", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class b$b
  implements k
{
  private final HashMap<k.b, Pair<Function1<ca[], Unit>, Function3<Integer, Integer, String, Unit>>> a;
  private int b;
  private int c;
  
  public b$b(int paramInt)
  {
    this.c = paramInt;
    this.a = new HashMap();
  }
  
  public final void a()
  {
    this.c -= 1;
    int i = this.c;
    b();
  }
  
  public void a(@NotNull k.b paramb, @NotNull Function1<? super ca[], Unit> paramFunction1, @NotNull Function3<? super Integer, ? super Integer, ? super String, Unit> paramFunction3, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "request");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onSuccess");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onError");
    this.b = paramInt;
    ((Map)this.a).put(paramb, new Pair(paramFunction1, paramFunction3));
    b();
  }
  
  public final void b()
  {
    if (this.c != this.a.size()) {
      return;
    }
    if (this.a.size() <= 0) {
      return;
    }
    i.a.a((List)new LinkedList((Collection)this.a.keySet()), (Function1)new b.b.a(this), (Function3)new b.b.b(this), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.b
 * JD-Core Version:    0.7.0.1
 */