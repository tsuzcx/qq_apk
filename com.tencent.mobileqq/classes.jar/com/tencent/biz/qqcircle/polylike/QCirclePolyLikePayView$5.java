package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolyLikePayView$5
  implements View.OnClickListener
{
  QCirclePolyLikePayView$5(QCirclePolyLikePayView paramQCirclePolyLikePayView) {}
  
  public void onClick(View paramView)
  {
    QCirclePolyLikePayView.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView.5
 * JD-Core Version:    0.7.0.1
 */