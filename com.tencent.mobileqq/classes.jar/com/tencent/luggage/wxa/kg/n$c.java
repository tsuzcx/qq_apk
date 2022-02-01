package com.tencent.luggage.wxa.kg;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class n$c
  extends AdvertiseCallback
{
  public void onStartFailure(int paramInt)
  {
    super.onStartFailure(paramInt);
    AdvertiseCallback localAdvertiseCallback = n.c(this.a);
    if (localAdvertiseCallback == null) {
      Intrinsics.throwNpe();
    }
    localAdvertiseCallback.onStartFailure(paramInt);
    n.d(this.a);
  }
  
  public void onStartSuccess(@Nullable AdvertiseSettings paramAdvertiseSettings)
  {
    super.onStartSuccess(paramAdvertiseSettings);
    if (n.b(this.a))
    {
      AdvertiseCallback localAdvertiseCallback = n.c(this.a);
      if (localAdvertiseCallback == null) {
        Intrinsics.throwNpe();
      }
      localAdvertiseCallback.onStartSuccess(paramAdvertiseSettings);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.n.c
 * JD-Core Version:    0.7.0.1
 */