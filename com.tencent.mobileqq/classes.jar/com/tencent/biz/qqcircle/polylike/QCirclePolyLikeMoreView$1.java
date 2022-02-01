package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolyLikeMoreView$1
  implements View.OnClickListener
{
  QCirclePolyLikeMoreView$1(QCirclePolyLikeMoreView paramQCirclePolyLikeMoreView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.k != null) {
      this.a.k.a(null);
    }
    if (this.a.l == null)
    {
      QCirclePolyLikeMoreView localQCirclePolyLikeMoreView = this.a;
      localQCirclePolyLikeMoreView.l = new QCirclePolyLikeAllDialog(localQCirclePolyLikeMoreView.getContext());
    }
    this.a.l.a(this.a.d, QCirclePolyLikeInfoManger.a().b(), this.a.j, this.a.getReportBean());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeMoreView.1
 * JD-Core Version:    0.7.0.1
 */