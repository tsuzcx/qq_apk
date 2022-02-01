package com.tencent.biz.qqcircle.widgets.pymk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleDitto.StButton;

class QCirclePYMKRecommendItemViewHolder$3
  implements View.OnClickListener
{
  static {}
  
  QCirclePYMKRecommendItemViewHolder$3(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder, QQCircleDitto.StButton paramStButton) {}
  
  public void onClick(View paramView)
  {
    if (QCirclePYMKRecommendItemViewHolder.a(this.b, this.a))
    {
      QCircleHostLauncher.doJumpAction(paramView.getContext(), this.a.jumpUrl.get());
    }
    else
    {
      QCircleFollowView localQCircleFollowView = QCirclePYMKRecommendItemViewHolder.a(this.b);
      JoinPoint localJoinPoint = Factory.makeJP(c, this, localQCircleFollowView, paramView);
      a(this, localQCircleFollowView, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder.3
 * JD-Core Version:    0.7.0.1
 */