package com.tencent.luggage.wxa.ke;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      o.d("MicroMsg.Ble.BleManager", "Receive intent failed");
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      boolean bool = false;
      o.e("MicroMsg.Ble.BleManager", "state:%d", new Object[] { Integer.valueOf(i) });
      if (i == 12) {
        bool = true;
      }
      if (((a.a()) && (!bool)) || ((!a.a()) && (bool)))
      {
        paramContext = a.b().values().iterator();
        while (paramContext.hasNext()) {
          ((b)paramContext.next()).a(bool);
        }
      }
      a.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ke.a.2
 * JD-Core Version:    0.7.0.1
 */