package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;

class AVActivity$15
  implements Runnable
{
  AVActivity$15(AVActivity paramAVActivity, int paramInt) {}
  
  public void run()
  {
    if (!VideoController.a().r()) {}
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    do
    {
      do
      {
        return;
        localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      } while ((localWatchTogetherMediaPlayCtrl == null) || (!localWatchTogetherMediaPlayCtrl.h()));
      if (this.a != 3) {
        localWatchTogetherMediaPlayCtrl.a("AVActivity.onResume", null);
      }
      localWatchTogetherMediaPlayCtrl.d();
    } while (localWatchTogetherMediaPlayCtrl.i());
    localWatchTogetherMediaPlayCtrl.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.15
 * JD-Core Version:    0.7.0.1
 */