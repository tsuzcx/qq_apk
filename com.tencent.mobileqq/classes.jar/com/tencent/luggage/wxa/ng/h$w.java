package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.jo.e.a;
import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$stop$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$w
  extends h.c
{
  h$w(Function1 paramFunction1)
  {
    super(paramFunction1);
  }
  
  public void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    o.d("MicroMsg.VideoCast.VideoCastController", "stop success");
    h.d(this.b).a().a(e.a.b);
    h.j(this.b);
    this.b.c().c();
    this.c.invoke(Boolean.valueOf(true));
  }
  
  public void b(@Nullable e parame)
  {
    super.b(parame);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop fail");
    if (parame != null) {
      parame = Integer.valueOf(parame.a);
    } else {
      parame = "";
    }
    localStringBuilder.append(parame);
    o.b("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
    this.c.invoke(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.w
 * JD-Core Version:    0.7.0.1
 */