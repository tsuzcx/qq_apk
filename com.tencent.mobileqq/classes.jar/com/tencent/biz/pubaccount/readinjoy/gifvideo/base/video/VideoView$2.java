package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class VideoView$2
  implements Runnable
{
  VideoView$2(VideoView paramVideoView) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new VideoView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.2
 * JD-Core Version:    0.7.0.1
 */