package com.tencent.liteav.basic.a;

import java.util.Iterator;
import java.util.LinkedList;

public class a
{
  private final LinkedList<Runnable> a = new LinkedList();
  
  public void a()
  {
    Object localObject3;
    synchronized (this.a)
    {
      if (!this.a.isEmpty())
      {
        Object localObject1 = new LinkedList(this.a);
        this.a.clear();
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((Runnable)((Iterator)localObject1).next()).run();
          }
        }
        return;
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      this.a.add(paramRunnable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.a.a
 * JD-Core Version:    0.7.0.1
 */