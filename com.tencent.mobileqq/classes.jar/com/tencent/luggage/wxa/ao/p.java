package com.tencent.luggage.wxa.ao;

import java.util.PriorityQueue;

public final class p
{
  private final Object a;
  private final PriorityQueue<Integer> b;
  private int c;
  
  public void a(int paramInt)
  {
    synchronized (this.a)
    {
      this.b.add(Integer.valueOf(paramInt));
      this.c = Math.max(this.c, paramInt);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.a)
    {
      this.b.remove(Integer.valueOf(paramInt));
      if (this.b.isEmpty()) {
        paramInt = -2147483648;
      } else {
        paramInt = ((Integer)this.b.peek()).intValue();
      }
      this.c = paramInt;
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.p
 * JD-Core Version:    0.7.0.1
 */