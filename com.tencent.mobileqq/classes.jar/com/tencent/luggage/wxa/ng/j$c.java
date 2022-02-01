package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.a.a;
import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class j$c
  implements a.a
{
  public void a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "device");
    int k = 1;
    int j = 1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddDevice: ");
      localStringBuilder.append(paramc);
      o.d("MicroMsg.VideoCast.VideoCastDeviceManager", localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", new Object[] { localException });
    }
    int i;
    Object localObject2;
    b localb;
    if (k.a(paramc))
    {
      localObject1 = (Iterable)this.a.c();
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty()))
      {
        i = j;
      }
      else
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((e)((Iterator)localObject1).next()).d().a();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = ((b)localObject2).j;
          localb = paramc.a();
          if (localb == null) {
            Intrinsics.throwNpe();
          }
        } while (!Intrinsics.areEqual(localObject2, localb.j));
        i = 0;
      }
      if (i != 0) {
        this.a.c().add(new e(paramc));
      }
    }
    else
    {
      localObject1 = (Iterable)this.a.b();
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty()))
      {
        i = k;
      }
      else
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          i = k;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((e)((Iterator)localObject1).next()).d().a();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = ((b)localObject2).j;
          localb = paramc.a();
          if (localb == null) {
            Intrinsics.throwNpe();
          }
        } while (!Intrinsics.areEqual(localObject2, localb.j));
        i = 0;
      }
      if (i != 0) {
        this.a.b().add(new e(paramc));
      }
    }
    Object localObject1 = this.a.d();
    if (localObject1 != null) {
      localObject1 = (Unit)((Function0)localObject1).invoke();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onAddDevice: ");
    paramc = paramc.a();
    if (paramc != null) {
      paramc = paramc.g;
    } else {
      paramc = null;
    }
    ((StringBuilder)localObject1).append(paramc);
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", ((StringBuilder)localObject1).toString());
  }
  
  public void b(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "device");
    this.a.b().remove(new e(paramc));
    this.a.c().remove(new e(paramc));
    Object localObject = this.a.d();
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRemoveDevice: ");
    paramc = paramc.a();
    if (paramc != null) {
      paramc = paramc.g;
    } else {
      paramc = null;
    }
    ((StringBuilder)localObject).append(paramc);
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", ((StringBuilder)localObject).toString());
  }
  
  public void c(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "device");
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateDevice: ");
      localStringBuilder.append(paramc);
      o.d("MicroMsg.VideoCast.VideoCastDeviceManager", localStringBuilder.toString());
      return;
    }
    catch (Exception paramc)
    {
      o.b("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", new Object[] { paramc });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.j.c
 * JD-Core Version:    0.7.0.1
 */