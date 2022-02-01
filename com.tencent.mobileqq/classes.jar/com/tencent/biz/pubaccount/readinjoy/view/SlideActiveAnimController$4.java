package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SlideActiveAnimController$4
  implements View.OnClickListener
{
  SlideActiveAnimController$4(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onClick(View paramView)
  {
    this.a.d = true;
    SlideActiveAnimController.a(this.a, new SlideActiveAnimController.4.1(this));
    SlideActiveAnimController.a(this.a).postDelayed(SlideActiveAnimController.a(this.a), 5000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.4
 * JD-Core Version:    0.7.0.1
 */