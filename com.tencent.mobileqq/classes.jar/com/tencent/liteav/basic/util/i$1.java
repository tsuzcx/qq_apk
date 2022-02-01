package com.tencent.liteav.basic.util;

class i$1
  implements Runnable
{
  i$1(i parami, Runnable paramRunnable, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    this.a.run();
    this.b[0] = true;
    synchronized (i.a(this.c))
    {
      i.a(this.c).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.i.1
 * JD-Core Version:    0.7.0.1
 */