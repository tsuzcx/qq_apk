package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleFeedItemTagGuidePresenter$2
  implements View.OnClickListener
{
  static {}
  
  QCircleFeedItemTagGuidePresenter$2(QCircleFeedItemTagGuidePresenter paramQCircleFeedItemTagGuidePresenter, FeedCloudMeta.StFeed paramStFeed) {}
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(c, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemTagGuidePresenter.2
 * JD-Core Version:    0.7.0.1
 */