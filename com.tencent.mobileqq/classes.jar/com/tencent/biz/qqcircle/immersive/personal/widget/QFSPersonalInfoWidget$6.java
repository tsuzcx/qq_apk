package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCirclePersonDetailClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QFSPersonalInfoWidget$6
  implements View.OnClickListener
{
  static {}
  
  QFSPersonalInfoWidget$6(QFSPersonalInfoWidget paramQFSPersonalInfoWidget) {}
  
  @QCirclePersonDetailClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(c, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget.6
 * JD-Core Version:    0.7.0.1
 */