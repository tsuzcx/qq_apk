package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.c.a;

public class k
  extends j
{
  private i a;
  private c.a b;
  
  k(com.tencent.luggage.wxa.jx.c paramc)
  {
    super(paramc);
  }
  
  public void a(d paramd)
  {
    if (l() != null) {
      l().a();
    }
    if ((paramd != null) && (m() != null)) {
      paramd.al().b(m());
    }
    a(null);
    a(null);
    a(null);
  }
  
  public void a(c.a parama)
  {
    this.b = parama;
  }
  
  public void a(i parami)
  {
    this.a = parami;
  }
  
  public i l()
  {
    return this.a;
  }
  
  public c.a m()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.k
 * JD-Core Version:    0.7.0.1
 */