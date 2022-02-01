package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.jo.e.a;
import com.tencent.luggage.wxa.jq.a;
import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.nf.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$play$3$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$m$1
  extends h.c
{
  h$m$1()
  {
    super(localObject.a);
  }
  
  public void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    o.d("MicroMsg.VideoCast.VideoCastController", "playNew: stop success");
    h.d(this.b.a).a().a(e.a.b);
    h.d(this.b.a).a().a(h.c(this.b.a).d(), (a)new h.m.1.a(this));
  }
  
  public void b(@Nullable e parame)
  {
    super.b(parame);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop fail before play new");
    if (parame != null) {
      parame = Integer.valueOf(parame.a);
    } else {
      parame = "";
    }
    localStringBuilder.append(parame);
    o.b("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.m.1
 * JD-Core Version:    0.7.0.1
 */