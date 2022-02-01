package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleTagFlowLayout$1
  implements View.OnClickListener
{
  QCircleTagFlowLayout$1(QCircleTagFlowLayout paramQCircleTagFlowLayout, QCircleFlowLayoutItemView paramQCircleFlowLayoutItemView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QCircleTagFlowLayout.a(this.c, this.a, this.b);
    if (QCircleTagFlowLayout.a(this.c) != null) {
      QCircleTagFlowLayout.a(this.c).a(this.a, this.b, this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout.1
 * JD-Core Version:    0.7.0.1
 */