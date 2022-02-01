package com.tencent.luggage.wxa.sg;

import com.tencent.luggage.wxa.sh.a;

public abstract class b
  extends a
{
  private final int b;
  private final int c;
  
  public b(int paramInt1, int paramInt2)
  {
    if ((!a) && (paramInt1 < paramInt2)) {
      throw new AssertionError();
    }
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(g paramg)
  {
    try
    {
      super.a(paramg);
      if (paramg.a("LIMIT") <= this.c) {
        paramg.b("LIMIT", this.b);
      }
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public boolean c(g paramg)
  {
    for (;;)
    {
      try
      {
        int i = paramg.a();
        int j = paramg.d("LIMIT", this.b);
        if (j > i)
        {
          bool = true;
          if ((!bool) && (j >= this.b)) {
            paramg.b("LIMIT", this.c);
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.b
 * JD-Core Version:    0.7.0.1
 */