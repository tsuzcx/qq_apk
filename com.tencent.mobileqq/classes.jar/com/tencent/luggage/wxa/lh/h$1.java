package com.tencent.luggage.wxa.lh;

import java.util.HashMap;
import java.util.Map;

class h$1
  implements d.a
{
  h$1(h paramh) {}
  
  public void a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      h.a(this.a);
      return;
    }
    com.tencent.luggage.wxa.li.c.a(h.b(this.a).getAppId(), paramInt);
    h localh = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail: ");
    localStringBuilder.append(paramString);
    h.a(localh, localh.a(localStringBuilder.toString(), localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.h.1
 * JD-Core Version:    0.7.0.1
 */