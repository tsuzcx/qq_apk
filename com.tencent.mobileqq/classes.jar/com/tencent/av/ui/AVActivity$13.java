package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.screenshare.ScreenShareTipsHelper;
import com.tencent.av.tips.TipsUtil;

class AVActivity$13
  implements Runnable
{
  AVActivity$13(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.I == null) {
      return;
    }
    SessionInfo localSessionInfo = this.this$0.I.k();
    if ((localSessionInfo.p()) || ((localSessionInfo.u()) && (localSessionInfo.am)))
    {
      TipsUtil.a(VideoController.f().e, 1070, 0L, true);
      if (!ScreenShareTipsHelper.a)
      {
        TipsUtil.a(VideoController.f().e, 1072, 3000L);
        ScreenShareTipsHelper.a = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.13
 * JD-Core Version:    0.7.0.1
 */