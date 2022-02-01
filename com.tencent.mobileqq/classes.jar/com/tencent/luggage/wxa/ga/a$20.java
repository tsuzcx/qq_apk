package com.tencent.luggage.wxa.ga;

import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.qz.o;

class a$20
  implements a.a
{
  a$20(a parama) {}
  
  public void a()
  {
    o.d(a.b(this.a), "onForeground");
    a.c(this.a);
  }
  
  public void a(int paramInt)
  {
    String str = a.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackground, type: ");
    localStringBuilder.append(paramInt);
    o.d(str, localStringBuilder.toString());
    a.a(this.a, paramInt);
  }
  
  public void b()
  {
    a.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.a.20
 * JD-Core Version:    0.7.0.1
 */