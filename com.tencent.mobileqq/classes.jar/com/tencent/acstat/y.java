package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;

final class y
  implements Runnable
{
  y(Context paramContext) {}
  
  public final void run()
  {
    if (this.a == null) {
      StatServiceImpl.f().error("The Context of StatService.onStop() can not be null!");
    }
    for (;;)
    {
      return;
      StatServiceImpl.flushDataToDB(this.a);
      if (StatServiceImpl.a()) {
        continue;
      }
      try
      {
        Thread.sleep(100L);
        if (!StatCommonHelper.isBackgroundRunning(this.a)) {
          continue;
        }
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("onStop isBackgroundRunning flushDataToDB");
        }
        StatServiceImpl.commitEvents(this.a, -1);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.y
 * JD-Core Version:    0.7.0.1
 */