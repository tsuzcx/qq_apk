package com.tencent.luggage.wxa.kv;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class a$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      o.d("MicroMsg.BeaconManager", "Receive intent failed");
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      boolean bool = false;
      o.d("MicroMsg.BeaconManager", "state:%d", new Object[] { Integer.valueOf(i) });
      if (i == 12) {
        bool = true;
      }
      if (((a.c) && (!bool)) || ((!a.c) && (bool)))
      {
        paramContext = a.a.values().iterator();
        while (paramContext.hasNext()) {
          ((a.a)paramContext.next()).a(bool);
        }
      }
      a.c = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.a.1
 * JD-Core Version:    0.7.0.1
 */