package com.tencent.biz.subscribe.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeMultiPicFragment$1
  implements View.OnClickListener
{
  SubscribeMultiPicFragment$1(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment.1
 * JD-Core Version:    0.7.0.1
 */