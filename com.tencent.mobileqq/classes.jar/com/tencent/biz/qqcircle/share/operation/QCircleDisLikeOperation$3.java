package com.tencent.biz.qqcircle.share.operation;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleDisLikeOperation$3
  implements View.OnClickListener
{
  QCircleDisLikeOperation$3(QCircleDisLikeOperation paramQCircleDisLikeOperation) {}
  
  public void onClick(View paramView)
  {
    QCircleDisLikeOperation.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleDisLikeOperation.3
 * JD-Core Version:    0.7.0.1
 */