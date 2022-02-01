package com.tencent.luggage.wxa.ix;

import android.os.Looper;
import android.os.MessageQueue;

class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public void run()
  {
    Looper.myQueue().addIdleHandler(new d.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.6
 * JD-Core Version:    0.7.0.1
 */