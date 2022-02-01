package com.tencent.luggage.wxa.an;

import java.util.Comparator;
import java.util.TreeSet;

public final class k
  implements f, Comparator<g>
{
  private final long a;
  private final TreeSet<g> b;
  private long c;
  
  public k(long paramLong)
  {
    this.a = paramLong;
    this.b = new TreeSet(this);
  }
  
  private void a(a parama, long paramLong)
  {
    while ((this.c + paramLong > this.a) && (!this.b.isEmpty())) {
      try
      {
        parama.b((g)this.b.first());
      }
      catch (a.a locala)
      {
        label43:
        break label43;
      }
    }
  }
  
  public int a(g paramg1, g paramg2)
  {
    if (paramg1.f - paramg2.f == 0L) {
      return paramg1.a(paramg2);
    }
    if (paramg1.f < paramg2.f) {
      return -1;
    }
    return 1;
  }
  
  public void a() {}
  
  public void a(a parama, g paramg)
  {
    this.b.add(paramg);
    this.c += paramg.c;
    a(parama, 0L);
  }
  
  public void a(a parama, g paramg1, g paramg2)
  {
    b(parama, paramg1);
    a(parama, paramg2);
  }
  
  public void a(a parama, String paramString, long paramLong1, long paramLong2)
  {
    a(parama, paramLong2);
  }
  
  public void b(a parama, g paramg)
  {
    this.b.remove(paramg);
    this.c -= paramg.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.k
 * JD-Core Version:    0.7.0.1
 */