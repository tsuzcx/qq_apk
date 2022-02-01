package com.tencent.luggage.wxa.fy;

import android.view.Choreographer;
import java.util.concurrent.Future;

class d$3
  implements Runnable
{
  d$3(d paramd, Future paramFuture, Runnable paramRunnable) {}
  
  public void run()
  {
    Choreographer.getInstance().postFrameCallback(new d.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.d.3
 * JD-Core Version:    0.7.0.1
 */