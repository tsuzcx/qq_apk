package com.tencent.luggage.wxa.cj;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class a$1
  implements c.a
{
  a$1(a parama, h paramh, JSONObject paramJSONObject, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    o.d("Luggage.BaseLoginJsApi", "%s.invoke: login result errCode:%d errMsg:%s", new Object[] { this.d.d(), Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.d.a(this.a, this.b, this.c);
      return;
    }
    h localh = this.a;
    paramInt = this.c;
    a locala = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramString);
    localh.a(paramInt, locala.b(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cj.a.1
 * JD-Core Version:    0.7.0.1
 */