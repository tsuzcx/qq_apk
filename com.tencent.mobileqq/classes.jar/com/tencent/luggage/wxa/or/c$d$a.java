package com.tencent.luggage.wxa.or;

import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$requestDeviceOrientation$2$callback$1", "Lkotlin/Function1;", "", "", "antiReentryGuard", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoke", "reason", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class c$d$a
  implements Function1<String, Unit>
{
  private final AtomicBoolean d = new AtomicBoolean(true);
  
  c$d$a(e.b paramb, boolean paramBoolean) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    if (this.d.getAndSet(false))
    {
      c.f();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDeviceOrientation, will invoke outer listener reason:[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], orientation:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" success:");
      ((StringBuilder)localObject).append(this.c);
      o.d("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", ((StringBuilder)localObject).toString());
      paramString = this.a.b;
      if (paramString != null) {
        paramString.a(this.b, this.c);
      }
      localObject = c.a(this.a.a);
      paramString = this.b;
      if (paramString != null) {
        paramString = paramString.name();
      } else {
        paramString = null;
      }
      ((n)localObject).setSoftOrientation(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.c.d.a
 * JD-Core Version:    0.7.0.1
 */