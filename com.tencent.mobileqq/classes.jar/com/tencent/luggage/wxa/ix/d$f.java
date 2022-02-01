package com.tencent.luggage.wxa.ix;

import android.os.Handler;
import android.os.Message;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.iu.j;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.t;

final class d$f
  extends f
{
  d$f(d paramd, g paramg)
  {
    super(paramg);
  }
  
  public void a()
  {
    super.a();
    this.a.r().sendEmptyMessageDelayed(d.a.f.a(), d.j(this.a).A().R * 1000L);
    t localt = d.i(this.a);
    if (localt != null)
    {
      localt.o();
      d.j(this.a).ae().I().d();
    }
  }
  
  public boolean a(Message paramMessage)
  {
    int i = d.7.b[d.a.a(paramMessage.what).ordinal()];
    if (i != 4)
    {
      if (i != 6) {
        return super.a(paramMessage);
      }
      o.d(d.k(this.a), "suspend timeout");
      this.a.a();
      return true;
    }
    paramMessage = this.a;
    d.a(paramMessage, d.d(paramMessage));
    return true;
  }
  
  public void b()
  {
    super.b();
    this.a.r().removeMessages(d.a.f.a());
  }
  
  public String c()
  {
    return "|Suspend";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.f
 * JD-Core Version:    0.7.0.1
 */