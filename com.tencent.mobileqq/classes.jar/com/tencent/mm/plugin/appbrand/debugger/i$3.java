package com.tencent.mm.plugin.appbrand.debugger;

import java.util.LinkedList;

class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  public void run()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (i.a(this.a).z())
    {
      localLinkedList.addAll(i.b(this.a));
      i.b(this.a).clear();
      i.a(this.a, false);
      i.a(this.a, localLinkedList, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.i.3
 * JD-Core Version:    0.7.0.1
 */