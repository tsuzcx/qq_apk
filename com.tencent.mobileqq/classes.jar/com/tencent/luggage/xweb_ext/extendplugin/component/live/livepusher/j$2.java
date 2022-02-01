package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.qz.o;

class j$2
  implements a.a
{
  j$2(j paramj) {}
  
  public void a()
  {
    o.d(j.g(this.a), "onForeground");
    j.h(this.a);
  }
  
  public void a(int paramInt)
  {
    String str = j.g(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackground, type: ");
    localStringBuilder.append(paramInt);
    o.d(str, localStringBuilder.toString());
    j.b(this.a, paramInt);
  }
  
  public void b()
  {
    j.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.2
 * JD-Core Version:    0.7.0.1
 */