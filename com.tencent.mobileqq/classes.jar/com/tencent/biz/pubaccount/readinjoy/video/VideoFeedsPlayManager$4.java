package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import rwf;

class VideoFeedsPlayManager$4
  implements Runnable
{
  VideoFeedsPlayManager$4(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      VideoFeedsPlayManager.a(this.this$0).d();
      if ((!VideoFeedsPlayManager.b(this.this$0)) && (VideoFeedsPlayManager.a(this.this$0) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "activity become onPause after videoPlayer.start()， so we need to pause it");
        }
        VideoFeedsPlayManager.a(this.this$0).f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.4
 * JD-Core Version:    0.7.0.1
 */