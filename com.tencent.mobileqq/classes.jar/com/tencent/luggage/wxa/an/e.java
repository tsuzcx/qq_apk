package com.tencent.luggage.wxa.an;

import com.tencent.luggage.wxa.am.f;
import com.tencent.luggage.wxa.am.f.a;
import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.g.a;

public final class e
  implements g.a
{
  private final a a;
  private final g.a b;
  private final g.a c;
  private final f.a d;
  private final int e;
  private final d.a f;
  
  public e(a parama, g.a parama1, g.a parama2, f.a parama3, int paramInt, d.a parama4)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = parama3;
    this.e = paramInt;
    this.f = parama4;
  }
  
  public d b()
  {
    a locala = this.a;
    g localg1 = this.b.a();
    g localg2 = this.c.a();
    Object localObject = this.d;
    if (localObject != null) {
      localObject = ((f.a)localObject).a();
    } else {
      localObject = null;
    }
    return new d(locala, localg1, localg2, (f)localObject, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.e
 * JD-Core Version:    0.7.0.1
 */