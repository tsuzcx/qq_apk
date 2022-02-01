package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.OnLongClickListener;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleInsFeedItemView$3
  implements QCircleDoubleClickLayout.OnLongClickListener
{
  static {}
  
  QCircleInsFeedItemView$3(QCircleInsFeedItemView paramQCircleInsFeedItemView) {}
  
  @QCircleFeedClick
  public void onLongClick()
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this);
    onLongClick_aroundBody1$advice(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView.3
 * JD-Core Version:    0.7.0.1
 */