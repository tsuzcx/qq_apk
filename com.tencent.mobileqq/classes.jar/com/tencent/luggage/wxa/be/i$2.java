package com.tencent.luggage.wxa.be;

import android.os.HandlerThread;
import com.tencent.luggage.wxa.qz.s;
import java.util.concurrent.atomic.AtomicBoolean;

class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public void run()
  {
    i.f(this.a).a(null);
    i.g(this.a).quitSafely();
    i.b(this.a).compareAndSet(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.i.2
 * JD-Core Version:    0.7.0.1
 */