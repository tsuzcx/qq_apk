package com.tencent.luggage.wxa.kj;

import android.bluetooth.BluetoothGatt;
import com.tencent.luggage.wxa.kn.a;

class b$1
  implements Runnable
{
  b$1(b paramb, BluetoothGatt paramBluetoothGatt) {}
  
  public void run()
  {
    Integer localInteger = b.a(this.b);
    if (localInteger != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Attempting to requestConnectionPriority, ");
      localStringBuilder.append(localInteger);
      a.c("MicroMsg.Ble.ConnectAction", localStringBuilder.toString(), new Object[0]);
      if (!this.a.requestConnectionPriority(localInteger.intValue())) {
        a.b("MicroMsg.Ble.ConnectAction", "requestConnectionPriority fail", new Object[0]);
      }
    }
    a.c("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
    this.a.discoverServices();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.b.1
 * JD-Core Version:    0.7.0.1
 */