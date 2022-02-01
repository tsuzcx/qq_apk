package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.nf.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$play$2$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$l$1
  extends h.c
{
  h$l$1()
  {
    super(localObject.a);
  }
  
  public void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    o.d("MicroMsg.VideoCast.VideoCastController", "play success, url = [%s]", new Object[] { h.c(this.b.a).d() });
    this.b.b.a();
  }
  
  public void b(@Nullable e parame)
  {
    super.b(parame);
    o.b("MicroMsg.VideoCast.VideoCastController", "play fail");
    parame = new h.b(a.l);
    parame.a(Integer.valueOf(this.b.c));
    h.a(this.b.a, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.l.1
 * JD-Core Version:    0.7.0.1
 */