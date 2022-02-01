package com.google.android.exoplayer2.util;

import android.os.SystemClock;

public final class ConditionVariable
{
  private boolean isOpen;
  
  public void block()
  {
    try
    {
      while (!this.isOpen) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean block(long paramLong)
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = paramLong + l1;
      for (paramLong = l1; (!this.isOpen) && (paramLong < l2); paramLong = SystemClock.elapsedRealtime()) {
        wait(l2 - paramLong);
      }
      boolean bool = this.isOpen;
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean close()
  {
    try
    {
      boolean bool = this.isOpen;
      this.isOpen = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean open()
  {
    try
    {
      boolean bool = this.isOpen;
      if (bool) {
        return false;
      }
      this.isOpen = true;
      notifyAll();
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ConditionVariable
 * JD-Core Version:    0.7.0.1
 */