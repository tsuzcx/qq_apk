package com.tencent.luggage.wxa.fy;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.Future;

class d$3$1
  implements Choreographer.FrameCallback
{
  private int b = 0;
  
  d$3$1(d.3 param3) {}
  
  public void doFrame(long paramLong)
  {
    o.d(this.a.c.a, "scheduleAfterTransferFromTask, doFrame");
    this.b += 1;
    if (2 <= this.b)
    {
      this.a.a.cancel(true);
      this.a.b.run();
      return;
    }
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.d.3.1
 * JD-Core Version:    0.7.0.1
 */