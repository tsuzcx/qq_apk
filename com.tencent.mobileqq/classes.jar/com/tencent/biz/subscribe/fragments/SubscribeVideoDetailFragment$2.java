package com.tencent.biz.subscribe.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeVideoDetailFragment$2
  implements View.OnClickListener
{
  SubscribeVideoDetailFragment$2(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */