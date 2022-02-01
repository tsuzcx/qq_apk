package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;

class AVActivity$16
  implements Runnable
{
  AVActivity$16(AVActivity paramAVActivity, int paramInt) {}
  
  public void run()
  {
    if (!VideoController.a().p()) {
      return;
    }
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    if (!localWatchTogetherMediaPlayCtrl.h()) {
      return;
    }
    if (this.a != 3) {
      localWatchTogetherMediaPlayCtrl.a("AVActivity.onResume", null);
    }
    localWatchTogetherMediaPlayCtrl.d();
    if (!localWatchTogetherMediaPlayCtrl.i()) {
      localWatchTogetherMediaPlayCtrl.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.16
 * JD-Core Version:    0.7.0.1
 */