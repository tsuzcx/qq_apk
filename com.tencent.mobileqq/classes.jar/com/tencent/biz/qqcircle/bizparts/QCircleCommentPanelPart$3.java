package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleCommentPanelPart$3
  implements View.OnClickListener
{
  QCircleCommentPanelPart$3(QCircleCommentPanelPart paramQCircleCommentPanelPart) {}
  
  public void onClick(View paramView)
  {
    QCircleCommentPanelPart.a(this.a).f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.3
 * JD-Core Version:    0.7.0.1
 */