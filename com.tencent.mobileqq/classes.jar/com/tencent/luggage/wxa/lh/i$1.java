package com.tencent.luggage.wxa.lh;

import com.tencent.luggage.wxa.jx.c;
import java.util.HashMap;
import java.util.Map;

class i$1
  implements d.a
{
  i$1(i parami, c paramc, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      i.a(this.c, this.a, this.b);
      return;
    }
    i locali = this.c;
    c localc = this.a;
    paramInt = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail: ");
    localStringBuilder.append(paramString);
    i.a(locali, localc, paramInt, locali.a(localStringBuilder.toString(), localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.i.1
 * JD-Core Version:    0.7.0.1
 */