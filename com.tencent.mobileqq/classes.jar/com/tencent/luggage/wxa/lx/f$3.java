package com.tencent.luggage.wxa.lx;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.luggage.wxa.jx.c;

class f$3
  implements Runnable
{
  f$3(f paramf, c paramc) {}
  
  public void run()
  {
    ((TelephonyManager)this.a.getContext().getApplicationContext().getSystemService("phone")).listen(f.a(this.b).a(), 256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.f.3
 * JD-Core Version:    0.7.0.1
 */