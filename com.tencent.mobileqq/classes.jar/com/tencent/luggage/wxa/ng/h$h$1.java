package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.nf.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$interruptDetectorTimer$1$1", "Lcom/tencent/mm/plugin/appbrand/dlna/net/callback/ControlCallback;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$h$1
  implements com.tencent.luggage.wxa.jq.a
{
  public void a(@Nullable e parame)
  {
    if (h.n(this.a.a)) {
      return;
    }
    if (parame != null)
    {
      parame = parame.c;
      if (parame != null)
      {
        parame = (com.tencent.luggage.wxa.jr.a)parame.get("CurrentURI");
        if (parame != null)
        {
          parame = parame.a();
          break label53;
        }
      }
    }
    parame = null;
    label53:
    parame = String.valueOf(parame);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMediaInfo: currentUrl = ");
    localStringBuilder.append(parame);
    o.d("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
    if (parame != null)
    {
      if (!StringsKt.isBlank((CharSequence)StringsKt.trim((CharSequence)parame).toString()))
      {
        if (Intrinsics.areEqual(parame, "null")) {
          return;
        }
        if ((Intrinsics.areEqual(parame, h.c(this.a.a).d()) ^ true)) {
          h.g(this.a.a).e();
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  public void b(@Nullable e parame)
  {
    o.d("MicroMsg.VideoCast.VideoCastController", "getMediaInfo fail");
    h.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.h.1
 * JD-Core Version:    0.7.0.1
 */