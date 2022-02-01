package com.tencent.biz.subscribe.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeHybirdFragment$5
  implements View.OnClickListener
{
  SubscribeHybirdFragment$5(SubscribeHybirdFragment paramSubscribeHybirdFragment, ShareInfoBean paramShareInfoBean) {}
  
  public void onClick(View paramView)
  {
    this.b.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.5
 * JD-Core Version:    0.7.0.1
 */