package com.tencent.luggage.wxa.iu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

class d$6$2
  implements Runnable
{
  d$6$2(d.6 param6) {}
  
  public void run()
  {
    this.a.a.m();
    Object localObject = new LinkedList(d.k(this.a.a));
    d.k(this.a.a).clear();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((t)((Iterator)localObject).next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.6.2
 * JD-Core Version:    0.7.0.1
 */