package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleCertifiedPart$1
  implements View.OnClickListener
{
  QCircleCertifiedPart$1(QCircleCertifiedPart paramQCircleCertifiedPart) {}
  
  public void onClick(View paramView)
  {
    if (QCircleCertifiedPart.a(this.a)) {
      QCircleCertifiedPart.b(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCertifiedPart.1
 * JD-Core Version:    0.7.0.1
 */