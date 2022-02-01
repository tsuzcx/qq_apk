package com.tencent.luggage.wxa.hj;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

class l$a$2
  extends ScheduledThreadPoolExecutor
{
  l$a$2(l.a parama, int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory);
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(new l.a.2.1(this, paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.a.2
 * JD-Core Version:    0.7.0.1
 */