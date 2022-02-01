package com.tencent.biz.pubaccount.Advertisement.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoCoverView$2
  implements View.OnClickListener
{
  VideoCoverView$2(VideoCoverView paramVideoCoverView) {}
  
  public void onClick(View paramView)
  {
    VideoCoverView.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.2
 * JD-Core Version:    0.7.0.1
 */