package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView.OnClickItemListener;
import feedcloud.FeedCloudMeta.StUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleFeedItemBottomPresenter$4
  implements QCirclePushAsyncTextView.OnClickItemListener
{
  static {}
  
  QCircleFeedItemBottomPresenter$4(QCircleFeedItemBottomPresenter paramQCircleFeedItemBottomPresenter) {}
  
  @QCircleFeedClick
  public void a()
  {
    JoinPoint localJoinPoint = Factory.makeJP(c, this, this);
    a(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  @QCircleFeedClick
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    JoinPoint localJoinPoint = Factory.makeJP(b, this, this, paramStUser);
    a(this, paramStUser, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBottomPresenter.4
 * JD-Core Version:    0.7.0.1
 */