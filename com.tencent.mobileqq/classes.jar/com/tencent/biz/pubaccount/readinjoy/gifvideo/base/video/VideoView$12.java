package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import mqq.os.MqqHandler;

class VideoView$12
  implements Runnable
{
  VideoView$12(VideoView paramVideoView) {}
  
  public void run()
  {
    float f;
    if ((this.this$0.getCurrentState() == 7) && (VideoView.access$900(this.this$0) != null) && (VideoView.access$900(this.this$0).getDuration() != 0L))
    {
      f = (float)VideoView.access$900(this.this$0).getCurrentPostion() / (float)VideoView.access$900(this.this$0).getDuration();
      if ((f < 0.0F) || (f > 0.1D) || (VideoView.access$2500(this.this$0) != null)) {
        break label117;
      }
      VideoView.access$2600(this.this$0);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(VideoView.access$2700(this.this$0), 100L);
      return;
      label117:
      if ((f >= 0.9D) && (VideoView.access$2500(this.this$0) != null)) {
        VideoView.access$2300(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.12
 * JD-Core Version:    0.7.0.1
 */