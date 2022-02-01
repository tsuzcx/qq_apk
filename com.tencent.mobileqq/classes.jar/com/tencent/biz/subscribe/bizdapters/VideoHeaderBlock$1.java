package com.tencent.biz.subscribe.bizdapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoHeaderBlock$1
  implements View.OnClickListener
{
  VideoHeaderBlock$1(VideoHeaderBlock paramVideoHeaderBlock) {}
  
  public void onClick(View paramView)
  {
    if ((!FastClickUtils.a("SUB_ENTER_FLOAT_MODE")) && (VideoHeaderBlock.a(this.a) != null)) {
      VideoHeaderBlock.a(this.a).p();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.1
 * JD-Core Version:    0.7.0.1
 */