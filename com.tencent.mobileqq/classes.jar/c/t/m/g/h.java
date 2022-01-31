package c.t.m.g;

import java.util.concurrent.CountDownLatch;

final class h
  implements Runnable
{
  h(j paramj, i parami) {}
  
  public final void run()
  {
    aj localaj = this.a.a();
    this.b.a(localaj);
    this.b.i.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.h
 * JD-Core Version:    0.7.0.1
 */