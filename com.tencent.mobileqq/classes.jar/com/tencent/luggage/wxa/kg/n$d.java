package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class n$d
  implements Runnable
{
  n$d(n paramn, BluetoothAdapter paramBluetoothAdapter, String paramString, AdvertiseSettings paramAdvertiseSettings, AdvertiseData paramAdvertiseData1, AdvertiseData paramAdvertiseData2) {}
  
  public final void run()
  {
    if (((StringsKt.isBlank((CharSequence)this.c) ^ true)) && ((Intrinsics.areEqual(this.b.getName(), this.c) ^ true)))
    {
      if (!this.b.setName(this.c)) {
        o.c("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", new Object[] { Integer.valueOf(this.b.getState()) });
      }
      int i = 0;
      while (i <= 20)
      {
        String str = this.b.getName();
        o.d("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", new Object[] { Integer.valueOf(i), str, this.c });
        if (!Intrinsics.areEqual(this.c, str)) {
          try
          {
            Thread.sleep(50L);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw ((Throwable)localInterruptedException);
          }
        }
      }
    }
    BluetoothLeAdvertiser localBluetoothLeAdvertiser = this.b.getBluetoothLeAdvertiser();
    if (localBluetoothLeAdvertiser != null) {
      localBluetoothLeAdvertiser.startAdvertising(this.d, this.e, this.f, n.a(this.a));
    }
    this.a.g().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.n.d
 * JD-Core Version:    0.7.0.1
 */