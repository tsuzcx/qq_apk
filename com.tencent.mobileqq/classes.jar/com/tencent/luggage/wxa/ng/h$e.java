package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.nf.b;
import com.tencent.luggage.wxa.nf.b.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$getProgressTimeMs$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$e
  extends h.c
{
  h$e()
  {
    super(localh);
  }
  
  public void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    Object localObject1 = parame.c;
    if (localObject1 != null)
    {
      if (((Map)localObject1).isEmpty()) {
        return;
      }
      if ((((Map)localObject1).containsKey("RelTime")) && (((Map)localObject1).containsKey("TrackDuration")))
      {
        parame = ((com.tencent.luggage.wxa.jr.a)MapsKt.getValue((Map)localObject1, "RelTime")).a();
        localObject1 = ((com.tencent.luggage.wxa.jr.a)MapsKt.getValue((Map)localObject1, "TrackDuration")).a();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getProgressTimeMs: relTime = ");
        ((StringBuilder)localObject2).append(parame);
        ((StringBuilder)localObject2).append(", duration =  ");
        ((StringBuilder)localObject2).append((String)localObject1);
        o.d("MicroMsg.VideoCast.VideoCastController", ((StringBuilder)localObject2).toString());
        int i = (int)b.b.a(parame);
        int j = (int)b.b.a((String)localObject1);
        h.a(this.b, i);
        h.g(this.b).a(i, j);
        localObject2 = h.g(this.b);
        double d1 = i;
        double d2 = j;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = 100;
        Double.isNaN(d2);
        ((com.tencent.luggage.wxa.ge.a)localObject2).a((int)(d1 * d2));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get position success, relTime: ");
        ((StringBuilder)localObject2).append((int)b.b.a(parame));
        ((StringBuilder)localObject2).append(' ');
        ((StringBuilder)localObject2).append("duration: ");
        ((StringBuilder)localObject2).append((int)b.b.a((String)localObject1));
        o.d("MicroMsg.VideoCast.VideoCastController", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void b(@Nullable e parame)
  {
    super.b(parame);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get position  fail");
    if (parame != null) {
      parame = Integer.valueOf(parame.a);
    } else {
      parame = "";
    }
    localStringBuilder.append(parame);
    o.b("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
    parame = new h.b(a.l);
    this.b.c().c();
    h.a(this.b, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.e
 * JD-Core Version:    0.7.0.1
 */