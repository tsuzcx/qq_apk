package com.tencent.luggage.wxa.lh;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class e$1
  implements d.a
{
  e$1(e parame, c paramc, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      this.a.a(this.b, this.c.a("ok", localHashMap));
      return;
    }
    c localc = this.a;
    paramInt = this.b;
    e locale = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail ");
    localStringBuilder.append(paramString);
    localc.a(paramInt, locale.a(localStringBuilder.toString(), localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.e.1
 * JD-Core Version:    0.7.0.1
 */