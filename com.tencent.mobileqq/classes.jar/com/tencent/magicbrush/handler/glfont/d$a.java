package com.tencent.magicbrush.handler.glfont;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class d$a
{
  public Queue<d.b> a = new LinkedList();
  
  public d.b a()
  {
    d.b localb2 = (d.b)this.a.poll();
    d.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new d.b();
    }
    return localb1;
  }
  
  public void a(d.b paramb)
  {
    this.a.offer(paramb);
  }
  
  public void a(ArrayList<d.b> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        d.b localb = (d.b)localIterator.next();
        this.a.offer(localb);
      }
      paramArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.d.a
 * JD-Core Version:    0.7.0.1
 */