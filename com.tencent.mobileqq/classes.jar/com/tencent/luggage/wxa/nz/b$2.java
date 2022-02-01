package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

class b$2
  implements Runnable
{
  b$2(b paramb, String paramString) {}
  
  public void run()
  {
    synchronized (b.a(this.b))
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = (ConcurrentLinkedQueue)b.a(this.b).get(this.a);
      o.e("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", new Object[] { this.a, Integer.valueOf(localConcurrentLinkedQueue.size()) });
      Runnable localRunnable = (Runnable)localConcurrentLinkedQueue.peek();
      if (localRunnable != null)
      {
        localRunnable.run();
        localConcurrentLinkedQueue.poll();
        if (localConcurrentLinkedQueue.size() > 0)
        {
          o.d("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
          b.b(this.b, this.a);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.b.2
 * JD-Core Version:    0.7.0.1
 */