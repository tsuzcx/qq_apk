package com.tencent.luggage.wxa.hx;

public class b
{
  private final a[] a;
  private int b;
  private final Object c = new Object();
  
  public b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = new a[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  private boolean b(a parama)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.a[i] == parama) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public a a()
  {
    synchronized (this.c)
    {
      if (this.b > 0)
      {
        int i = this.b - 1;
        a locala = this.a[i];
        this.a[i] = null;
        this.b -= 1;
        return locala;
      }
      return null;
    }
  }
  
  public boolean a(a parama)
  {
    synchronized (this.c)
    {
      if (!b(parama))
      {
        parama.a();
        if (this.b < this.a.length)
        {
          this.a[this.b] = parama;
          this.b += 1;
          return true;
        }
        return false;
      }
      throw new IllegalStateException("Already in the pool!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hx.b
 * JD-Core Version:    0.7.0.1
 */