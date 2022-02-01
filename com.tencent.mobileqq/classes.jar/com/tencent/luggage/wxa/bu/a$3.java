package com.tencent.luggage.wxa.bu;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.qz.o;

class a$3
  extends c.c
{
  a$3(a parama) {}
  
  public void a()
  {
    o.d("MicroMsg.MBNiReporter", "hy: onCreate");
    a.e(this.a);
  }
  
  public void a(c.d paramd)
  {
    o.d("MicroMsg.MBNiReporter", "hy: onPause");
    this.a.b();
  }
  
  public void b()
  {
    o.d("MicroMsg.MBNiReporter", "hy: onResume");
  }
  
  public void c()
  {
    o.d("MicroMsg.MBNiReporter", "hy: onDestroy");
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bu.a.3
 * JD-Core Version:    0.7.0.1
 */