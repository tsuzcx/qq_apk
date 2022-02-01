package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViewBase$1
  implements View.OnClickListener
{
  ViewBase$1(ViewBase paramViewBase) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.1
 * JD-Core Version:    0.7.0.1
 */