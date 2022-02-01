package com.tencent.mobileqq.app;

import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import mqq.app.AppRuntime;

class FrameHelperActivity$20
  implements Runnable
{
  FrameHelperActivity$20(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    ((IOnlineStatusService)this.this$0.A.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.20
 * JD-Core Version:    0.7.0.1
 */