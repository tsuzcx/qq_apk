package com.tencent.mobileqq.banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TipsBar$1
  implements View.OnClickListener
{
  TipsBar$1(TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    this.a.removeAllViews();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.TipsBar.1
 * JD-Core Version:    0.7.0.1
 */