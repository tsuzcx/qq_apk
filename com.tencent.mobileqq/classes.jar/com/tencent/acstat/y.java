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
    Context localContext = this.a;
    if (localContext == null)
    {
      StatServiceImpl.f().error("The Context of StatService.onStop() can not be null!");
      return;
    }
    StatServiceImpl.flushDataToDB(localContext);
    if (!StatServiceImpl.a())
    {
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (StatCommonHelper.isBackgroundRunning(this.a))
      {
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("onStop isBackgroundRunning flushDataToDB");
        }
        StatServiceImpl.commitEvents(this.a, -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.y
 * JD-Core Version:    0.7.0.1
 */