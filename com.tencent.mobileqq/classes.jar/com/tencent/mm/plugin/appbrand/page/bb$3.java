package com.tencent.mm.plugin.appbrand.page;

import java.util.Iterator;
import java.util.LinkedList;

class bb$3
  implements Runnable
{
  bb$3(bb parambb, LinkedList paramLinkedList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb.3
 * JD-Core Version:    0.7.0.1
 */