package com.tencent.luggage.wxa.ql;

import com.tencent.luggage.wxa.qz.o;

class b$1
  implements Runnable
{
  b$1(b paramb, boolean paramBoolean) {}
  
  public void run()
  {
    o.d("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(this.a) });
    this.b.a.b(this.b.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.b.1
 * JD-Core Version:    0.7.0.1
 */