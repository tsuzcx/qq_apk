package com.tencent.luggage.wxa.kg;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kn.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$invoke$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class g$b
  extends AdvertiseCallback
{
  g$b(int paramInt, c paramc) {}
  
  public void onStartFailure(int paramInt)
  {
    super.onStartFailure(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Not broadcasting: ");
    ((StringBuilder)localObject).append(paramInt);
    o.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", ((StringBuilder)localObject).toString());
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("fail:Unhandled ");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(" error");
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = "fail:feature unsupported";
            }
          }
          else {
            localObject = "fail:internal error";
          }
        }
        else {
          localObject = "fail:already started";
        }
      }
      else {
        localObject = "fail:too many advertisers";
      }
    }
    else {
      localObject = "fail:data too large";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStartFailure: error msg = ");
    localStringBuilder.append((String)localObject);
    o.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", localStringBuilder.toString());
    b.a(this.a, this.b, this.c, 10008, (String)localObject);
  }
  
  public void onStartSuccess(@Nullable AdvertiseSettings paramAdvertiseSettings)
  {
    super.onStartSuccess(paramAdvertiseSettings);
    b.a(this.a, this.b, this.c, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.g.b
 * JD-Core Version:    0.7.0.1
 */