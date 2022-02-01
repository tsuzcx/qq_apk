package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m.a;
import org.json.JSONObject;

class ah$1
  implements Runnable
{
  ah$1(ah paramah, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    m.a locala = ah.a(this.a, this.b);
    this.a.a(this.c, this.d.a(locala.b, locala.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ah.1
 * JD-Core Version:    0.7.0.1
 */