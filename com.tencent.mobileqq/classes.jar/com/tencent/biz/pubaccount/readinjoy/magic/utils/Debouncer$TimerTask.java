package com.tencent.biz.pubaccount.readinjoy.magic.utils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Debouncer$TimerTask
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private final T jdField_a_of_type_JavaLangObject;
  private final Object b;
  
  public void run()
  {
    synchronized (this.b)
    {
      long l = this.jdField_a_of_type_Long - System.currentTimeMillis();
      if (l > 0L)
      {
        Debouncer.a(this.this$0).schedule(this, l, TimeUnit.MILLISECONDS);
        return;
      }
      this.jdField_a_of_type_Long = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.utils.Debouncer.TimerTask
 * JD-Core Version:    0.7.0.1
 */