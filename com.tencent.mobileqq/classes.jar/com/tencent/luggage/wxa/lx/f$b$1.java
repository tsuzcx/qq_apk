package com.tencent.luggage.wxa.lx;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.List;

class f$b$1
  extends PhoneStateListener
{
  f$b$1(f.b paramb) {}
  
  public void onSignalStrengthsChanged(SignalStrength arg1)
  {
    super.onSignalStrengthsChanged(???);
    int i = f.a(this.a.a, ???);
    ??? = new StringBuilder();
    ???.append("onSignalStrengthsChanged, dbm: ");
    ???.append(i);
    o.d("MicroMsg.JsApiGetNetworkType", ???.toString());
    f.a(this.a.a, i);
    synchronized (this.a)
    {
      if (!f.b.a(this.a))
      {
        f.b.a(this.a, true);
        if (f.b.b(this.a) != null)
        {
          Iterator localIterator = f.b.b(this.a).iterator();
          while (localIterator.hasNext()) {
            ((f.a)localIterator.next()).a(i);
          }
          f.b.b(this.a).clear();
          f.b.a(this.a, null);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.f.b.1
 * JD-Core Version:    0.7.0.1
 */