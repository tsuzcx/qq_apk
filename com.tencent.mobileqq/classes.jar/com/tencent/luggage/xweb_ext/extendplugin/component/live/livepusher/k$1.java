package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.wxa.qz.o;

class k$1
  implements Runnable
{
  k$1(k paramk, int paramInt) {}
  
  public void run()
  {
    k.a(this.b, this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyOrientationChanged, angle:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", orientation:");
    ((StringBuilder)localObject).append(k.a(this.b));
    o.d("TXLivePusherJSAdapter", ((StringBuilder)localObject).toString());
    localObject = this.b;
    k.a((k)localObject, this.a, k.a((k)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k.1
 * JD-Core Version:    0.7.0.1
 */