package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class VideoView$6
  implements Runnable
{
  VideoView$6(VideoView paramVideoView) {}
  
  public void run()
  {
    int i = 0;
    NativeReadInjoyImageView localNativeReadInjoyImageView;
    if ((VideoView.access$600(this.this$0) != null) && (VideoView.access$700(this.this$0) != null))
    {
      QLog.d(this.this$0.tag, 2, "displaycover: " + VideoView.access$800(this.this$0));
      VideoView.access$600(this.this$0).setVisibility(0);
      VideoView.access$600(this.this$0).setAlpha(1.0F);
      VideoView.access$900(this.this$0);
      localNativeReadInjoyImageView = VideoView.access$700(this.this$0);
      if (!VideoView.access$1000(this.this$0)) {
        break label139;
      }
    }
    for (;;)
    {
      localNativeReadInjoyImageView.setVisibility(i);
      VideoView.access$700(this.this$0).clearAnimation();
      VideoView.access$700(this.this$0).setAlpha(1.0F);
      VideoView.access$1100(this.this$0);
      return;
      label139:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.6
 * JD-Core Version:    0.7.0.1
 */