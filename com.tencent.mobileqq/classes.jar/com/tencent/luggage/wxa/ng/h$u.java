package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$setVolume$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$u
  extends h.c
{
  h$u()
  {
    super(localh);
  }
  
  public void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    o.d("MicroMsg.VideoCast.VideoCastController", "setVolume success");
  }
  
  public void b(@Nullable e parame)
  {
    super.b(parame);
    if (parame != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVolume fail:");
      localStringBuilder.append(parame.a);
      o.b("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVolume fail:");
      localStringBuilder.append(parame.a);
      o.b("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.u
 * JD-Core Version:    0.7.0.1
 */