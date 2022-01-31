package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.List;

final class kl$3
  implements Runnable
{
  kl$3(kl paramkl, int paramInt) {}
  
  public final void run()
  {
    Iterator localIterator = kl.b(this.b).iterator();
    while (localIterator.hasNext())
    {
      hb localhb = (hb)localIterator.next();
      if (localhb != null) {
        localhb.a(this.a);
      }
    }
    kl.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.kl.3
 * JD-Core Version:    0.7.0.1
 */