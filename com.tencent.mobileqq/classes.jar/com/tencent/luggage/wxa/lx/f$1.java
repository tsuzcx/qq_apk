package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;

class f$1
  implements f.a
{
  f$1(f paramf, Map paramMap, c paramc, int paramInt) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSignalStrength, dbm: ");
    localStringBuilder.append(paramInt);
    o.d("MicroMsg.JsApiGetNetworkType", localStringBuilder.toString());
    if (2147483647 != paramInt) {
      this.a.put("signalStrength", Integer.valueOf(paramInt));
    }
    this.b.a(this.c, this.d.a("ok", this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.f.1
 * JD-Core Version:    0.7.0.1
 */