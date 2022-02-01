package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.OnDoubleClickListener;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleInsFeedItemView$2
  implements QCircleDoubleClickLayout.OnDoubleClickListener
{
  static {}
  
  QCircleInsFeedItemView$2(QCircleInsFeedItemView paramQCircleInsFeedItemView, Object paramObject) {}
  
  @QCircleFeedClick
  public void onDoubleClick()
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this);
    onDoubleClick_aroundBody1$advice(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView.2
 * JD-Core Version:    0.7.0.1
 */