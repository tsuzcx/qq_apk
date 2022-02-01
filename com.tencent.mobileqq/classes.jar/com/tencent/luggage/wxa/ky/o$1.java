package com.tencent.luggage.wxa.ky;

class o$1
  implements Runnable
{
  o$1(o paramo, int paramInt) {}
  
  public void run()
  {
    o.a(this.b, this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyOrientationChanged, angle:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", orientation:");
    ((StringBuilder)localObject).append(o.a(this.b));
    com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", ((StringBuilder)localObject).toString());
    localObject = this.b;
    o.a((o)localObject, this.a, o.a((o)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.o.1
 * JD-Core Version:    0.7.0.1
 */