package com.tencent.luggage.wxa.bl;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.c.c.b;
import com.tencent.luggage.wxa.ot.d;

public final class b$c
  implements c.b
{
  private int a;
  
  public b$c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(Object... paramVarArgs)
  {
    if (this.a != -1) {
      ((d)e.b(d.class)).a(this.a, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bl.b.c
 * JD-Core Version:    0.7.0.1
 */