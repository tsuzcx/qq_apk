package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChooseItemView$1
  implements View.OnClickListener
{
  ChooseItemView$1(ChooseItemView paramChooseItemView) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView.1
 * JD-Core Version:    0.7.0.1
 */