package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class VideoView$15
  implements Runnable
{
  VideoView$15(VideoView paramVideoView) {}
  
  public void run()
  {
    if ((VideoView.access$2700(this.this$0) != null) && (VideoView.access$2800(this.this$0) != null))
    {
      QLog.d("gifvideo.VideoView", 2, this.this$0.getTag() + " displaycover");
      if (VideoView.access$3400(this.this$0) != null) {
        VideoView.access$3400(this.this$0).cancel();
      }
      if (VideoView.access$3500(this.this$0) != null) {
        VideoView.access$3500(this.this$0).cancel();
      }
      VideoView.access$2700(this.this$0).setVisibility(0);
      VideoView.access$2700(this.this$0).setAlpha(1.0F);
      VideoView.access$3600(this.this$0);
      if (VideoView.access$3700(this.this$0))
      {
        VideoView.access$2800(this.this$0).clearAnimation();
        VideoView.access$2800(this.this$0).setVisibility(0);
        VideoView.access$2800(this.this$0).setAlpha(1.0F);
        VideoView.access$3800(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.15
 * JD-Core Version:    0.7.0.1
 */