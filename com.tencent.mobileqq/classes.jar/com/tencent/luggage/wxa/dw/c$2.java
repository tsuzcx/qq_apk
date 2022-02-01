package com.tencent.luggage.wxa.dw;

import android.os.Bundle;
import android.os.ResultReceiver;

class c$2
  implements b<R>
{
  c$2(c paramc) {}
  
  public void a(R paramR)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("parcel", new c.a(paramR));
    c.a(this.a).send(-1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.c.2
 * JD-Core Version:    0.7.0.1
 */