package com.tencent.bugly.proguard;

final class u$1
  implements Runnable
{
  u$1(u paramu, Runnable paramRunnable) {}
  
  public final void run()
  {
    this.a.run();
    synchronized (u.a(this.b))
    {
      u.b(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.u.1
 * JD-Core Version:    0.7.0.1
 */