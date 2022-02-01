package com.tencent.magicbrush.handler.glfont;

import java.util.LinkedList;
import java.util.Queue;

class g$a
{
  private Queue<k> a = new LinkedList();
  
  k a()
  {
    k localk2 = (k)this.a.poll();
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = new k();
    }
    return localk1;
  }
  
  void a(k paramk)
  {
    if (paramk != null)
    {
      paramk.a();
      this.a.offer(paramk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g.a
 * JD-Core Version:    0.7.0.1
 */