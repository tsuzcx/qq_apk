package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.ViewTreeObserver;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import oxd;

public class VideoView$2
  implements Runnable
{
  VideoView$2(VideoView paramVideoView, boolean paramBoolean) {}
  
  public void run()
  {
    if (VideoView.a(this.this$0) != null)
    {
      VideoView.a(this.this$0).setOutputMute(VideoView.a(this.this$0));
      VideoView.a(this.this$0).setXYaxis(VideoView.a(this.this$0));
      if (this.this$0.getViewTreeObserver() != null) {
        this.this$0.getViewTreeObserver().addOnGlobalLayoutListener(new oxd(this));
      }
      if (this.a) {
        this.this$0.E_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.2
 * JD-Core Version:    0.7.0.1
 */