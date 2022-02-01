package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoViewVideoHolder$8
  implements View.OnClickListener
{
  VideoViewVideoHolder$8(VideoViewVideoHolder paramVideoViewVideoHolder, ErrorMessage paramErrorMessage) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.b.b.getContext()))
    {
      QQToast.makeText(this.b.b.getContext(), 1, 2131892102, 0).show();
    }
    else
    {
      this.b.s.setVisibility(0);
      this.b.t.setVisibility(8);
      VideoViewVideoHolder localVideoViewVideoHolder = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry ");
      localStringBuilder.append(this.a.errorCode);
      localVideoViewVideoHolder.a(10, true, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.8
 * JD-Core Version:    0.7.0.1
 */