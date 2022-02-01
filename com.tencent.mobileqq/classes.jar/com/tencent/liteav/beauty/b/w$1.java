package com.tencent.liteav.beauty.b;

class w$1
  implements Runnable
{
  w$1(w paramw) {}
  
  public void run()
  {
    synchronized (w.a(this.a))
    {
      w.b(this.a);
      w.a(this.a).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.w.1
 * JD-Core Version:    0.7.0.1
 */