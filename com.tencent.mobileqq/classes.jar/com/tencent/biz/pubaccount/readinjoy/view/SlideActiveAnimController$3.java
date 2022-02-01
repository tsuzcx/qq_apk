package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SlideActiveAnimController$3
  implements View.OnClickListener
{
  SlideActiveAnimController$3(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onClick(View paramView)
  {
    SlideActiveAnimController.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.3
 * JD-Core Version:    0.7.0.1
 */