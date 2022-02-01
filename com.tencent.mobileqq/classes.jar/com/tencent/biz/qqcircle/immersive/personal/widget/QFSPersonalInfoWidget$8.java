package com.tencent.biz.qqcircle.immersive.personal.widget;

import com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.OnExpandCallback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSPersonalInfoWidget$8
  implements QCircleTailExpandText.OnExpandCallback
{
  QFSPersonalInfoWidget$8(QFSPersonalInfoWidget paramQFSPersonalInfoWidget) {}
  
  public void a(boolean paramBoolean)
  {
    EventCollector.getInstance().onViewClicked(QFSPersonalInfoWidget.i(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget.8
 * JD-Core Version:    0.7.0.1
 */