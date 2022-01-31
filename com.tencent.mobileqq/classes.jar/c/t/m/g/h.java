package c.t.m.g;

import java.util.concurrent.CountDownLatch;

final class h
  implements Runnable
{
  h(k paramk, i parami) {}
  
  public final void run()
  {
    ao localao = this.a.a();
    this.b.a(localao);
    this.b.l.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.h
 * JD-Core Version:    0.7.0.1
 */