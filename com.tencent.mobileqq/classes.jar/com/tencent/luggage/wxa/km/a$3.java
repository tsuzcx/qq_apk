package com.tencent.luggage.wxa.km;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class a$3
  extends BroadcastReceiver
{
  a$3(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      o.d(a.f(this.a), "Receive intent failed");
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      int i = paramContext.getState();
      o.e(a.f(this.a), "state:%d", new Object[] { Integer.valueOf(i) });
      if (i != 12)
      {
        if (i == 11) {
          return;
        }
        if ((i == 10) || (i == 13))
        {
          com.tencent.luggage.wxa.kn.a.c(a.f(this.a), "bluetooth is disable, stop scan", new Object[0]);
          a.a(this.a).set(false);
          this.a.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.a.3
 * JD-Core Version:    0.7.0.1
 */