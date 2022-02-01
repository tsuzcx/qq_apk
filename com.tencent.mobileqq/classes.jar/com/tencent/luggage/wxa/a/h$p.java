package com.tencent.luggage.wxa.a;

class h$p
  implements Cloneable
{
  float a;
  h.bd b;
  
  h$p(float paramFloat)
  {
    this.a = paramFloat;
    this.b = h.bd.a;
  }
  
  h$p(float paramFloat, h.bd parambd)
  {
    this.a = paramFloat;
    this.b = parambd;
  }
  
  float a()
  {
    return this.a;
  }
  
  float a(float paramFloat)
  {
    int i = h.1.a[this.b.ordinal()];
    if (i != 1)
    {
      switch (i)
      {
      default: 
        return this.a;
      case 8: 
        return this.a * paramFloat / 6.0F;
      case 7: 
        return this.a * paramFloat / 72.0F;
      case 6: 
        return this.a * paramFloat / 25.4F;
      case 5: 
        return this.a * paramFloat / 2.54F;
      }
      return this.a * paramFloat;
    }
    return this.a;
  }
  
  float a(i parami)
  {
    switch (h.1.a[this.b.ordinal()])
    {
    default: 
      return this.a;
    case 9: 
      parami = parami.d();
      if (parami == null) {
        return this.a;
      }
      return this.a * parami.c / 100.0F;
    case 8: 
      return this.a * parami.a() / 6.0F;
    case 7: 
      return this.a * parami.a() / 72.0F;
    case 6: 
      return this.a * parami.a() / 25.4F;
    case 5: 
      return this.a * parami.a() / 2.54F;
    case 4: 
      return this.a * parami.a();
    case 3: 
      return this.a * parami.c();
    case 2: 
      return this.a * parami.b();
    }
    return this.a;
  }
  
  float a(i parami, float paramFloat)
  {
    if (this.b == h.bd.i) {
      return this.a * paramFloat / 100.0F;
    }
    return a(parami);
  }
  
  float b(i parami)
  {
    if (this.b == h.bd.i)
    {
      parami = parami.d();
      if (parami == null) {
        return this.a;
      }
      return this.a * parami.d / 100.0F;
    }
    return a(parami);
  }
  
  boolean b()
  {
    return this.a == 0.0F;
  }
  
  float c(i parami)
  {
    if (this.b == h.bd.i)
    {
      parami = parami.d();
      if (parami == null) {
        return this.a;
      }
      float f1 = parami.c;
      float f2 = parami.d;
      if (f1 == f2) {
        return this.a * f1 / 100.0F;
      }
      f1 = (float)(Math.sqrt(f1 * f1 + f2 * f2) / 1.414213562373095D);
      return this.a * f1 / 100.0F;
    }
    return a(parami);
  }
  
  boolean c()
  {
    return this.a < 0.0F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.a));
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.p
 * JD-Core Version:    0.7.0.1
 */