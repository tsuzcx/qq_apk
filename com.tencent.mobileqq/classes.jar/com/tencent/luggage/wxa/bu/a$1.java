package com.tencent.luggage.wxa.bu;

import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.CopyOnWriteArrayList;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    a locala = this.a;
    a.a(locala, a.a(locala).size());
    o.d("MicroMsg.MBNiReporter", "hy: onFirstFrameRendered picnum:%d", new Object[] { Integer.valueOf(a.b(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bu.a.1
 * JD-Core Version:    0.7.0.1
 */