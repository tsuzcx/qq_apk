package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViolaLazyFragment$1
  implements View.OnClickListener
{
  ViolaLazyFragment$1(ViolaLazyFragment paramViolaLazyFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment.1
 * JD-Core Version:    0.7.0.1
 */