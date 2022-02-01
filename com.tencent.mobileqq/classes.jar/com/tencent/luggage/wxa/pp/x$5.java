package com.tencent.luggage.wxa.pp;

class x$5
  implements Runnable
{
  x$5(x paramx, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    int i = x.d(this.c);
    if (!this.c.isShown()) {
      x.a(this.c, 2);
    } else {
      x.a(this.c, this.a);
    }
    if (x.e(this.c) == null) {
      return;
    }
    if ((i != x.d(this.c)) && (!this.b)) {
      x.e(this.c).a(x.d(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x.5
 * JD-Core Version:    0.7.0.1
 */