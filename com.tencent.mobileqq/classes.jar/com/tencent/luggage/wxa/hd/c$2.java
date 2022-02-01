package com.tencent.luggage.wxa.hd;

import android.os.Build;
import android.os.Build.VERSION;

final class c$2
  extends c.b
{
  c$2(c.a parama)
  {
    super(parama);
  }
  
  String a()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return Build.RADIO;
    }
    return Build.getRadioVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.2
 * JD-Core Version:    0.7.0.1
 */