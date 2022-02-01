package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoView$4
  implements View.OnClickListener
{
  VideoView$4(VideoView paramVideoView) {}
  
  public void onClick(View paramView)
  {
    if (!VideoPlayController.a.a()) {
      ReadInJoyLogicEngineEventDispatcher.a().a(VideoView.access$300(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.4
 * JD-Core Version:    0.7.0.1
 */