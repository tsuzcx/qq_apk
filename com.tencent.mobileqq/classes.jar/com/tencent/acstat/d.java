package com.tencent.acstat;

import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import java.util.TimerTask;

class d
  extends TimerTask
{
  d(c paramc) {}
  
  public void run()
  {
    if (StatConfig.isDebugEnable()) {
      StatCommonHelper.getLogger().i("TimerTask run");
    }
    StatServiceImpl.d(c.a(this.a));
    cancel();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.d
 * JD-Core Version:    0.7.0.1
 */