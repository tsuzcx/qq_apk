package com.tencent.map.sdk.a;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class bn
  implements Runnable
{
  bn(bj parambj) {}
  
  public final void run()
  {
    if (bj.e(this.a).size() == 0)
    {
      bj.f(this.a).incrementAndGet();
      bj.b(this.a, true);
      return;
    }
    bj.a(this.a, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.bn
 * JD-Core Version:    0.7.0.1
 */