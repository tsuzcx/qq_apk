package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolyBaseLikeView$1
  implements View.OnClickListener
{
  QCirclePolyBaseLikeView$1(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView) {}
  
  public void onClick(View paramView)
  {
    QCircleToast.a(QCircleToast.b, 2131895841, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView.1
 * JD-Core Version:    0.7.0.1
 */