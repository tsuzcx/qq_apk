package com.tencent.bugly.proguard;

import java.util.concurrent.LinkedBlockingQueue;

final class u$2
  implements Runnable
{
  u$2(u paramu, int paramInt, LinkedBlockingQueue paramLinkedBlockingQueue) {}
  
  public final void run()
  {
    int i = 0;
    while (i < this.a)
    {
      Runnable localRunnable = (Runnable)this.b.poll();
      if (localRunnable == null) {
        break;
      }
      localRunnable.run();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.u.2
 * JD-Core Version:    0.7.0.1
 */