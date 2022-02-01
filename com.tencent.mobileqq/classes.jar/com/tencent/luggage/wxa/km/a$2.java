package com.tencent.luggage.wxa.km;

import android.bluetooth.BluetoothDevice;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.kl.i;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class a$2
  extends e
{
  a$2(a parama) {}
  
  public void a(int paramInt)
  {
    com.tencent.luggage.wxa.kn.a.a(a.f(this.a), "[onScanResult]onScanFailed, errorCode:%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt, h paramh)
  {
    if ((paramh != null) && (paramh.a() != null)) {
      if (!a.g(this.a).get())
      {
        com.tencent.luggage.wxa.kn.a.a(a.f(this.a), "[onScanResult]not init, err", new Object[0]);
        return;
      }
    }
    for (;;)
    {
      synchronized (this.a)
      {
        if (a.h(this.a) == null)
        {
          com.tencent.luggage.wxa.kn.a.b(a.f(this.a), "[onScanResult]may be close, err", new Object[0]);
          return;
        }
        String str = a.f(this.a);
        int i = 1;
        com.tencent.luggage.wxa.kn.a.c(str, "callbackType:%d, result:%s", new Object[] { Integer.valueOf(paramInt), paramh });
        str = paramh.a().getAddress();
        paramInt = i;
        if (a.h(this.a).containsKey(str))
        {
          if (!com.tencent.luggage.wxa.kh.a.a.c) {
            break label288;
          }
          paramInt = i;
        }
        paramh = new d(paramh);
        a.h(this.a).put(str, paramh);
        if (paramInt != 0)
        {
          if (com.tencent.luggage.wxa.kh.a.a.b > 0) {
            synchronized (this.a)
            {
              if (a.b(this.a) != null) {
                a.b(this.a).add(paramh);
              }
              return;
            }
          }
          ??? = a.c(this.a);
          if (??? != null) {
            ((i)???).a(paramh);
          }
        }
        return;
      }
      com.tencent.luggage.wxa.kn.a.a(a.f(this.a), "[onScanResult]result is null, err", new Object[0]);
      return;
      label288:
      paramInt = 0;
    }
  }
  
  public void a(List<h> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.a.2
 * JD-Core Version:    0.7.0.1
 */