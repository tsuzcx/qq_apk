package com.google.android.exoplayer2.util;

import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager
{
  private int highestPriority = -2147483648;
  private final Object lock = new Object();
  private final PriorityQueue<Integer> queue = new PriorityQueue(10, Collections.reverseOrder());
  
  public void add(int paramInt)
  {
    synchronized (this.lock)
    {
      this.queue.add(Integer.valueOf(paramInt));
      this.highestPriority = Math.max(this.highestPriority, paramInt);
      return;
    }
  }
  
  public void proceed(int paramInt)
  {
    synchronized (this.lock)
    {
      while (this.highestPriority != paramInt) {
        this.lock.wait();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean proceedNonBlocking(int paramInt)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.highestPriority == paramInt)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void proceedOrThrow(int paramInt)
  {
    synchronized (this.lock)
    {
      if (this.highestPriority == paramInt) {
        return;
      }
      throw new PriorityTaskManager.PriorityTooLowException(paramInt, this.highestPriority);
    }
  }
  
  public void remove(int paramInt)
  {
    synchronized (this.lock)
    {
      this.queue.remove(Integer.valueOf(paramInt));
      if (this.queue.isEmpty()) {
        paramInt = -2147483648;
      } else {
        paramInt = ((Integer)this.queue.peek()).intValue();
      }
      this.highestPriority = paramInt;
      this.lock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.PriorityTaskManager
 * JD-Core Version:    0.7.0.1
 */