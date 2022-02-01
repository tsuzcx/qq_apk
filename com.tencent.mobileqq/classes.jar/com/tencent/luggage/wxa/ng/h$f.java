package com.tencent.luggage.wxa.ng;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jr.a;
import com.tencent.luggage.wxa.jr.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$getVolume$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$WXControlCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "fail", "", "response", "Lcom/tencent/mm/plugin/appbrand/dlna/net/entity/TcpActionResponse;", "success", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$f
  extends h.c
{
  h$f(Function1 paramFunction1)
  {
    super(paramFunction1);
  }
  
  public void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    parame = parame.c;
    if (parame != null)
    {
      parame = (a)parame.get("CurrentVolume");
      if (parame != null)
      {
        parame = parame.a();
        break label41;
      }
    }
    parame = null;
    label41:
    if (!TextUtils.isEmpty((CharSequence)parame))
    {
      localObject = new f(true);
      if (parame == null) {
        Intrinsics.throwNpe();
      }
      ((f)localObject).a(Integer.valueOf(Integer.parseInt(parame)));
      this.c.invoke(localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get volume success : ");
    ((StringBuilder)localObject).append(parame);
    o.d("MicroMsg.VideoCast.VideoCastController", ((StringBuilder)localObject).toString());
  }
  
  public void b(@Nullable e parame)
  {
    super.b(parame);
    if (parame != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get volume  fail");
      localStringBuilder.append(parame.a);
      o.b("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.f
 * JD-Core Version:    0.7.0.1
 */