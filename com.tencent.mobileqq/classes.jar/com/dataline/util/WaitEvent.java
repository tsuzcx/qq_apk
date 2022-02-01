package com.dataline.util;

public class WaitEvent
{
  private boolean a;
  private boolean b;
  
  public WaitEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a()
  {
    try
    {
      if (!this.a) {
        this.a = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(long paramLong)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      if (this.a) {
        try
        {
          if ((this.b) && (this.a)) {
            this.a = true;
          }
          return true;
        }
        finally {}
      }
      try
      {
        Thread.sleep(1L);
        label47:
        if ((paramLong == -1L) || (System.currentTimeMillis() - l < paramLong)) {
          continue;
        }
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label47;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.WaitEvent
 * JD-Core Version:    0.7.0.1
 */