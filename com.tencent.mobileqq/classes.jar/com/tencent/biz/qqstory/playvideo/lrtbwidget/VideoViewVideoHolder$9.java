package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoViewVideoHolder$9
  implements View.OnClickListener
{
  VideoViewVideoHolder$9(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.b.getContext()))
    {
      QQToast.makeText(this.a.b.getContext(), 1, 2131892102, 0).show();
    }
    else
    {
      SLog.d(this.a.a, "video view error, retry, show loading view");
      this.a.s.setVisibility(0);
      this.a.t.setVisibility(8);
      this.a.a(10, true, "retry play");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.9
 * JD-Core Version:    0.7.0.1
 */