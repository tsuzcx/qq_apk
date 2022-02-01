package com.tencent.biz.qqcircle.immersive.feed;

import android.view.MotionEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTapClickEvent;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.OnTapClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QFSFeedChildDoublePraisePresenter$2
  implements QCircleDoubleClickLayout.OnTapClickListener
{
  QFSFeedChildDoublePraisePresenter$2(QFSFeedChildDoublePraisePresenter paramQFSFeedChildDoublePraisePresenter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    QFSFeedChildDoublePraisePresenter localQFSFeedChildDoublePraisePresenter = this.a;
    localQFSFeedChildDoublePraisePresenter.b(new QFSTapClickEvent(((FeedCloudMeta.StFeed)localQFSFeedChildDoublePraisePresenter.c).id.get(), paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildDoublePraisePresenter.2
 * JD-Core Version:    0.7.0.1
 */