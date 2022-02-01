package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.OnExpandCallback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePersonInfoWidget$4
  implements QCircleTailExpandText.OnExpandCallback
{
  QCirclePersonInfoWidget$4(QCirclePersonInfoWidget paramQCirclePersonInfoWidget) {}
  
  public void a(boolean paramBoolean)
  {
    EventCollector.getInstance().onViewClicked(QCirclePersonInfoWidget.i(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget.4
 * JD-Core Version:    0.7.0.1
 */