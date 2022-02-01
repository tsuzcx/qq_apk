package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolyBaseLikeView$2
  implements View.OnClickListener
{
  QCirclePolyBaseLikeView$2(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView.2
 * JD-Core Version:    0.7.0.1
 */