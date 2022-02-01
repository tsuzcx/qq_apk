package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopObserversHelper$4$1
  implements Runnable
{
  TroopObserversHelper$4$1(TroopObserversHelper.4 param4, Runnable paramRunnable, long paramLong) {}
  
  public void run()
  {
    if ((TroopObserversHelper.g(this.c.a) != null) && (TroopObserversHelper.g(this.c.a).isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.4.1
 * JD-Core Version:    0.7.0.1
 */