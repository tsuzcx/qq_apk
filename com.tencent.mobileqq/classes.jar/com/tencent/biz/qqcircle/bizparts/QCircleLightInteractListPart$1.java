package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleLightInteractListPart$1
  implements View.OnClickListener
{
  QCircleLightInteractListPart$1(QCircleLightInteractListPart paramQCircleLightInteractListPart) {}
  
  public void onClick(View paramView)
  {
    QCircleLightInteractListPart.a(this.a).f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.1
 * JD-Core Version:    0.7.0.1
 */