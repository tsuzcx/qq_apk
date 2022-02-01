package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.a.a;
import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class j$d
  implements a.a
{
  public void a(@Nullable c paramc)
  {
    if (paramc != null)
    {
      localObject1 = paramc.a();
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).j;
        if (localObject1 != null) {
          break label28;
        }
      }
    }
    Object localObject1 = "";
    label28:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onAddDevice: udn = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", ((StringBuilder)localObject2).toString());
    if ((paramc != null) && (!StringsKt.isBlank((CharSequence)localObject1)))
    {
      localObject2 = this.a.a().a();
      if (localObject2 != null) {
        localObject2 = ((b)localObject2).j;
      } else {
        localObject2 = null;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        localObject1 = this.a.h();
        if (localObject1 != null) {
          localObject1 = (Unit)((Function1)localObject1).invoke(Boolean.valueOf(true));
        }
        this.a.a(paramc);
      }
      return;
    }
    paramc = this.a.h();
    if (paramc != null) {
      paramc = (Unit)paramc.invoke(Boolean.valueOf(false));
    }
  }
  
  public void b(@Nullable c paramc)
  {
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
  }
  
  public void c(@Nullable c paramc)
  {
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.j.d
 * JD-Core Version:    0.7.0.1
 */