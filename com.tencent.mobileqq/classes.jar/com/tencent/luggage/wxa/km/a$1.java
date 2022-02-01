package com.tencent.luggage.wxa.km;

import android.os.Handler;
import com.tencent.luggage.wxa.kl.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    if (!a.a(this.a).get()) {
      return;
    }
    synchronized (this.a)
    {
      ArrayList localArrayList = new ArrayList(a.b(this.a));
      a.b(this.a).clear();
      ??? = a.c(this.a);
      if ((??? != null) && (localArrayList.size() > 0)) {
        ((i)???).a(localArrayList);
      }
      a.e(this.a).postDelayed(a.d(this.a), com.tencent.luggage.wxa.kh.a.a.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.a.1
 * JD-Core Version:    0.7.0.1
 */