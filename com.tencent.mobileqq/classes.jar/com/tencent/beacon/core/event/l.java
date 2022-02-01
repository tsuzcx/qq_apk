package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;

class l
  implements Runnable
{
  l(m paramm) {}
  
  public void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.l
 * JD-Core Version:    0.7.0.1
 */