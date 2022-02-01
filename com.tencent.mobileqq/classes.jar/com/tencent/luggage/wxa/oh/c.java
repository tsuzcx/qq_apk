package com.tencent.luggage.wxa.oh;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.oe.e;
import com.tencent.luggage.wxa.oe.e.a;

public class c
  extends e
{
  private c.a b;
  
  public c(e.a parama, h paramh)
  {
    super(parama, paramh);
  }
  
  protected void a()
  {
    this.b = new c.1(this);
    this.a.q().al().a(this.b);
  }
  
  protected void b()
  {
    if (this.b == null) {
      return;
    }
    if (this.a.q() == null) {
      return;
    }
    com.tencent.luggage.wxa.ix.c localc = this.a.q().al();
    if (localc == null) {
      return;
    }
    localc.b(this.b);
  }
  
  public int c()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oh.c
 * JD-Core Version:    0.7.0.1
 */