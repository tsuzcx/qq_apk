package com.tencent.luggage.wxa.on;

import android.text.TextUtils;
import com.tencent.luggage.wxa.oo.a.c;

class c$1
  implements a.c
{
  c$1(c paramc, c.b paramb) {}
  
  public void a()
  {
    c.b localb = this.a;
    if (localb != null) {
      localb.a(c.a.a());
    }
  }
  
  public void a(String paramString)
  {
    if (this.a != null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.a.a(c.a.c());
        return;
      }
      if (!paramString.startsWith("fail"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail ");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      this.a.a(new c.a(-1, paramString));
    }
  }
  
  public void b()
  {
    c.b localb = this.a;
    if (localb != null) {
      localb.a(c.a.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.c.1
 * JD-Core Version:    0.7.0.1
 */