package com.tencent.biz.qqcircle.widgets.polymerization;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleCommonClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleTagPolymerizationHeadView$1
  implements View.OnClickListener
{
  static {}
  
  QCircleTagPolymerizationHeadView$1(QCircleTagPolymerizationHeadView paramQCircleTagPolymerizationHeadView) {}
  
  @QCircleCommonClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(b, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleTagPolymerizationHeadView.1
 * JD-Core Version:    0.7.0.1
 */