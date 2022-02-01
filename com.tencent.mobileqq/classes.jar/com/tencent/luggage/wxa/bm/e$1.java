package com.tencent.luggage.wxa.bm;

import java.util.Iterator;
import java.util.Queue;

class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public void run()
  {
    Iterator localIterator = e.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      e.b(this.a).a(str);
    }
    e.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.e.1
 * JD-Core Version:    0.7.0.1
 */