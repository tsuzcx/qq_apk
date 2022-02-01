package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareTipsHelper;
import com.tencent.av.tips.TipsUtil;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity) {}
  
  public void run()
  {
    TipsUtil.a(VideoController.a().a, 8, 0L, true);
    if (!ScreenShareTipsHelper.a)
    {
      TipsUtil.a(VideoController.a().a, 10, 3000L);
      ScreenShareTipsHelper.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */