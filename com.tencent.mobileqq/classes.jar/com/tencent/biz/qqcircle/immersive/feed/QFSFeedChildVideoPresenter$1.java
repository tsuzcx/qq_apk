package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;

class QFSFeedChildVideoPresenter$1
  implements View.OnClickListener
{
  QFSFeedChildVideoPresenter$1(QFSFeedChildVideoPresenter paramQFSFeedChildVideoPresenter) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c != null)
    {
      QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
      localQCircleLayerBean.setVideoCurrentPosition(QFSFeedChildVideoPresenter.a(this.a));
      localQCircleLayerBean.setDataPosInList(this.a.d);
      localQCircleLayerBean.setFeed((FeedCloudMeta.StFeed)this.a.c);
      QCircleLauncher.h(paramView.getContext(), localQCircleLayerBean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */