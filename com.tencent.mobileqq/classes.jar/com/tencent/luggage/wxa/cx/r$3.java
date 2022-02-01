package com.tencent.luggage.wxa.cx;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.dc.o;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.h;

class r$3
  implements com.tencent.luggage.wxa.rl.b<Boolean, Void>
{
  r$3(r paramr, String paramString) {}
  
  @NonNull
  public Boolean a(Void paramVoid)
  {
    try
    {
      if (!u.a().a(r.a(this.b).b))
      {
        paramVoid = h.c();
        o.c(this.a).a(new r.3.2(this, paramVoid)).a(new r.3.1(this, paramVoid));
        return Boolean.valueOf(false);
      }
      return Boolean.valueOf(true);
    }
    catch (Exception paramVoid)
    {
      h.b().a(paramVoid);
      t.a.a(this.b.a, t.d.b, t.c.d, paramVoid.getMessage());
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.3
 * JD-Core Version:    0.7.0.1
 */