package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;

class e$1
  implements j.a
{
  e$1(e parame, k paramk, h paramh) {}
  
  public void a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1562453447)
    {
      if (i != -1514425717)
      {
        if ((i == 1073716042) && (paramString.equals("StateListening")))
        {
          i = 0;
          break label70;
        }
      }
      else if (paramString.equals("StateSuspend"))
      {
        i = 2;
        break label70;
      }
    }
    else if (paramString.equals("StateNotListening"))
    {
      i = 1;
      break label70;
    }
    i = -1;
    label70:
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_NOT_LISTENING, stop blink");
      if (this.a.l() != null) {
        this.a.l().b(this.b.q());
      }
    }
    else
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_LISTENING, start blink");
      if (this.a.l() != null) {
        this.a.l().a(this.b.q());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.e.1
 * JD-Core Version:    0.7.0.1
 */