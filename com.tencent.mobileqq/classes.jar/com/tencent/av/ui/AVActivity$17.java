package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;

class AVActivity$17
  implements Runnable
{
  AVActivity$17(AVActivity paramAVActivity, int paramInt) {}
  
  public void run()
  {
    if (!VideoController.f().aD()) {
      return;
    }
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    if (!localWatchTogetherMediaPlayCtrl.q()) {
      return;
    }
    if (this.a != 3) {
      localWatchTogetherMediaPlayCtrl.a("AVActivity.onResume", null);
    }
    localWatchTogetherMediaPlayCtrl.p();
    if (!localWatchTogetherMediaPlayCtrl.r()) {
      localWatchTogetherMediaPlayCtrl.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.17
 * JD-Core Version:    0.7.0.1
 */