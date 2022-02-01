package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StImage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleFeedItemPicPresenter$MultiPicAdapter$3
  implements View.OnClickListener
{
  static {}
  
  QCircleFeedItemPicPresenter$MultiPicAdapter$3(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter, QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, FeedCloudMeta.StImage paramStImage) {}
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(f, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.MultiPicAdapter.3
 * JD-Core Version:    0.7.0.1
 */