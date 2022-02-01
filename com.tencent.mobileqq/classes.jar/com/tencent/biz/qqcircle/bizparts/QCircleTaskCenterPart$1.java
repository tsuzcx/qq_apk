package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleTaskCenterPart$1
  implements View.OnClickListener
{
  QCircleTaskCenterPart$1(QCircleTaskCenterPart paramQCircleTaskCenterPart) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart.1
 * JD-Core Version:    0.7.0.1
 */