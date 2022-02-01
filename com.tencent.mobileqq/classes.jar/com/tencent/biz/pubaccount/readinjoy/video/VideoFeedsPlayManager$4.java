package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import spn;

class VideoFeedsPlayManager$4
  implements Runnable
{
  VideoFeedsPlayManager$4(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    spn localspn = VideoFeedsPlayManager.a(this.this$0);
    if (localspn != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      localspn.d();
      if (!VideoFeedsPlayManager.b(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "activity become onPause after videoPlayer.start()， so we need to pause it");
        }
        localspn.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.4
 * JD-Core Version:    0.7.0.1
 */