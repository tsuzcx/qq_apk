package com.tencent.mobileqq.activity.miniaio;

import com.tencent.commonsdk.util.notification.NotificationLimiterUtil;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.util.notification.NotificationLimiterImpl;

public class MiniMsgTabServerInitStep
  extends AsyncStep
{
  public static boolean a = false;
  private static String b = "MiniMsgTabServerInitStep";
  
  private void a()
  {
    a = true;
    NotificationLimiterUtil.setLimiter(new NotificationLimiterImpl());
  }
  
  protected int doStep()
  {
    if (this.mStepId == 108) {
      a();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep
 * JD-Core Version:    0.7.0.1
 */