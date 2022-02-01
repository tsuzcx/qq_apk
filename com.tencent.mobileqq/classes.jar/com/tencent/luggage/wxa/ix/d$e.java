package com.tencent.luggage.wxa.ix;

import android.os.Message;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.iu.j;
import com.tencent.mm.plugin.appbrand.jsruntime.t;

final class d$e
  extends f
{
  d$e(d paramd, g paramg)
  {
    super(paramg);
  }
  
  public void a()
  {
    super.a();
    t localt = d.i(this.a);
    if (localt != null)
    {
      localt.n();
      d.j(this.a).ae().I().e();
    }
  }
  
  public boolean a(Message paramMessage)
  {
    if (d.7.b[d.a.a(paramMessage.what).ordinal()] != 1) {
      return super.a(paramMessage);
    }
    paramMessage = this.a;
    d.a(paramMessage, d.c(paramMessage));
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public String c()
  {
    return "|Foreground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.e
 * JD-Core Version:    0.7.0.1
 */