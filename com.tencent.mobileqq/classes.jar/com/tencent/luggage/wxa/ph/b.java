package com.tencent.luggage.wxa.ph;

import com.tencent.luggage.wxa.pl.d.a;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.pm.i;

public abstract class b
  implements d
{
  private boolean b;
  
  public i a(a parama, com.tencent.luggage.wxa.pj.a parama1, com.tencent.luggage.wxa.pm.a parama2)
  {
    return new com.tencent.luggage.wxa.pm.e();
  }
  
  public void a(a parama, com.tencent.luggage.wxa.pl.d paramd) {}
  
  public void a(a parama, com.tencent.luggage.wxa.pm.a parama1) {}
  
  public void a(a parama, com.tencent.luggage.wxa.pm.a parama1, h paramh) {}
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(a parama, com.tencent.luggage.wxa.pl.d paramd)
  {
    paramd = new com.tencent.luggage.wxa.pl.e(paramd);
    paramd.a(d.a.e);
    parama.b(paramd);
  }
  
  public void c(a parama, com.tencent.luggage.wxa.pl.d paramd) {}
  
  public boolean g()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ph.b
 * JD-Core Version:    0.7.0.1
 */