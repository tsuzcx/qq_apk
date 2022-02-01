package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements c
{
  @Deprecated
  public static final b.a a = new b.a(null);
  private static final HashMap<String, b> e = new HashMap();
  private static final c f = (c)b.b.a;
  private final LinkedBlockingQueue<com.tencent.luggage.wxa.sj.g> b;
  private final AtomicInteger c;
  private final int d;
  
  public b(int paramInt)
  {
    this.d = paramInt;
    this.b = new LinkedBlockingQueue();
    this.c = new AtomicInteger(0);
  }
  
  @JvmStatic
  @NotNull
  public static final c a(@Nullable d paramd)
  {
    return a.a(paramd);
  }
  
  private final void a(com.tencent.luggage.wxa.sj.g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("schedule ");
    localStringBuilder.append(paramg.a());
    o.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", localStringBuilder.toString());
    paramg.run();
  }
  
  private final void b(com.tencent.luggage.wxa.sj.g paramg)
  {
    do
    {
      if (this.c.incrementAndGet() <= this.d)
      {
        a(paramg);
        return;
      }
      this.b.offer(paramg);
      if (this.c.decrementAndGet() >= this.d) {
        return;
      }
      paramg = (com.tencent.luggage.wxa.sj.g)this.b.poll();
    } while (paramg != null);
  }
  
  private final void d()
  {
    this.c.decrementAndGet();
    com.tencent.luggage.wxa.sj.g localg = (com.tencent.luggage.wxa.sj.g)this.b.poll();
    if (localg != null) {
      b(localg);
    }
  }
  
  private final void e()
  {
    this.b.clear();
  }
  
  public void a(@NotNull g paramg, @NotNull com.tencent.luggage.wxa.iu.b paramb, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "api");
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("name[");
    ((StringBuilder)localObject).append(paramg.d());
    ((StringBuilder)localObject).append("], callbackId[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], appId[");
    ((StringBuilder)localObject).append(paramb.getAppId());
    ((StringBuilder)localObject).append(']');
    localObject = ((StringBuilder)localObject).toString();
    paramg = new b.c(this, paramb, paramg, paramJSONObject, paramInt, (String)localObject);
    paramb = new StringBuilder();
    paramb.append("dispatch ");
    paramb.append((String)localObject);
    o.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", paramb.toString());
    b((com.tencent.luggage.wxa.sj.g)paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.b
 * JD-Core Version:    0.7.0.1
 */