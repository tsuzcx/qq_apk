package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import qty;

class VideoFeedsPlayManager$3
  implements Runnable
{
  VideoFeedsPlayManager$3(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoFeedsPlayManager.a(this.this$0).f();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      if ((!VideoFeedsPlayManager.c(this.this$0)) && (VideoFeedsPlayManager.a(this.this$0) != null))
      {
        VideoFeedsPlayManager.a(this.this$0).h();
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "activity become onPause after videoPlayer.start()， so we need to pause it");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.3
 * JD-Core Version:    0.7.0.1
 */