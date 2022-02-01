package com.tencent.luggage.wxa.mk;

class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      c.a(this.a);
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.c.1
 * JD-Core Version:    0.7.0.1
 */