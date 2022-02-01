package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.manager.QcircleRewardAdManager;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolyLikePayView$4
  implements View.OnClickListener
{
  QCirclePolyLikePayView$4(QCirclePolyLikePayView paramQCirclePolyLikePayView, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    QCirclePolyLikePayView.a(this.c).cancel();
    QcircleRewardAdManager.a().a(this.c.getContext(), 1, this.a, 7, 6, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView.4
 * JD-Core Version:    0.7.0.1
 */