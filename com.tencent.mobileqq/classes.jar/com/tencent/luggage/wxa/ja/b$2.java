package com.tencent.luggage.wxa.ja;

import com.tencent.luggage.wxa.qz.o;

class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public void run()
  {
    boolean bool = b.a(this.a);
    b.a(this.a, false);
    o.d("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.a.a()) });
    if ((bool) && (this.a.a())) {
      b.b(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.b.2
 * JD-Core Version:    0.7.0.1
 */