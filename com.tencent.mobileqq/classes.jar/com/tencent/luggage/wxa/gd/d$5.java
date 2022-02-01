package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.qz.o;

class d$5
  implements a.a
{
  d$5(d paramd) {}
  
  public void a()
  {
    o.d(d.b(this.a), "onForeground");
    d.m(this.a);
  }
  
  public void a(int paramInt)
  {
    String str = d.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackground, type: ");
    localStringBuilder.append(paramInt);
    o.d(str, localStringBuilder.toString());
    d.b(this.a, paramInt);
  }
  
  public void b()
  {
    d.n(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.5
 * JD-Core Version:    0.7.0.1
 */