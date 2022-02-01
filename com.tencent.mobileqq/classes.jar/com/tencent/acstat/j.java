package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;

final class j
  implements Runnable
{
  j(Context paramContext) {}
  
  public final void run()
  {
    NetworkManager.getInstance(StatServiceImpl.e()).registerBroadcast();
    StatCommonHelper.getDiffTime(this.a, true);
    af.a(this.a);
    g.b(this.a);
    StatServiceImpl.a(Thread.getDefaultUncaughtExceptionHandler());
    if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
      StatServiceImpl.commitEvents(this.a, -1);
    }
    if (StatConfig.isDebugEnable()) {
      StatServiceImpl.f().d("Init MTA StatService success, sdk version:2.4.2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.j
 * JD-Core Version:    0.7.0.1
 */