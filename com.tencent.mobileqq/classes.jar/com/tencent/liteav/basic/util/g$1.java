package com.tencent.liteav.basic.util;

class g$1
  implements Runnable
{
  g$1(g paramg, Runnable paramRunnable, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    this.a.run();
    this.b[0] = true;
    synchronized (g.a(this.c))
    {
      g.a(this.c).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g.1
 * JD-Core Version:    0.7.0.1
 */