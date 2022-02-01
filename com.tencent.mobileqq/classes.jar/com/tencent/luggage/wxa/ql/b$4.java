package com.tencent.luggage.wxa.ql;

import com.tencent.luggage.wxa.qz.o;

class b$4
  implements Runnable
{
  b$4(b paramb, boolean paramBoolean) {}
  
  public void run()
  {
    o.d("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(this.a) });
    this.b.a.a(this.b.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.b.4
 * JD-Core Version:    0.7.0.1
 */