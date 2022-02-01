package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$1$1
  implements Runnable
{
  VideoPlayManager$1$1(VideoPlayManager.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    VideoPlayManager.a(this.a.this$0, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */