package com.tencent.luggage.wxa.ff;

import androidx.core.util.Pools.Pool;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "Landroidx/core/util/Pools$Pool;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/JsApiInfo;", "()V", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "acquire", "clear", "", "release", "", "jsApiInfo", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class a$a
  implements Pools.Pool<d>
{
  private final ConcurrentLinkedDeque<d> a = new ConcurrentLinkedDeque();
  
  @NotNull
  public d a()
  {
    d locald = (d)this.a.poll();
    if (locald != null) {
      return locald;
    }
    return new d();
  }
  
  public boolean a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "jsApiInfo");
    return this.a.offer(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ff.a.a
 * JD-Core Version:    0.7.0.1
 */