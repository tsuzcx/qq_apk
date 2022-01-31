package com.tencent.beacon.core.a;

import com.tencent.beacon.core.d.i;

final class b$a$1
  implements Runnable
{
  b$a$1(Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      i.a(localThrowable);
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */