package com.tencent.luggage.wxa.lh;

import com.tencent.luggage.wxa.jx.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$1
  implements d.a
{
  g$1(g paramg, c paramc, int paramInt, JSONObject paramJSONObject) {}
  
  public void a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      g.a(this.d, this.a, this.b, this.c);
      return;
    }
    g localg = this.d;
    c localc = this.a;
    paramInt = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail: ");
    localStringBuilder.append(paramString);
    g.a(localg, localc, paramInt, localg.a(localStringBuilder.toString(), localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.g.1
 * JD-Core Version:    0.7.0.1
 */