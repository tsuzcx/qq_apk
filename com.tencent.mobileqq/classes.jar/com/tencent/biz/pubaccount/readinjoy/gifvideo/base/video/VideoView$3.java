package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoView$3
  implements View.OnClickListener
{
  VideoView$3(VideoView paramVideoView) {}
  
  public void onClick(View paramView)
  {
    long l;
    if (VideoView.access$200(this.a).a() != null)
    {
      l = VideoView.access$200(this.a).a().b();
      VideoReportUtil.a.b(VideoView.access$300(this.a), l, this.a.isPlaying());
      if (!this.a.isPlaying()) {
        break label88;
      }
      this.a.setManualPause(true);
      this.a.pause();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      l = 0L;
      break;
      label88:
      if (VideoView.access$400(this.a))
      {
        this.a.setManualPause(false);
        this.a.resume();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.3
 * JD-Core Version:    0.7.0.1
 */