package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QCirclePolyParseFrameLayout$1
  implements Runnable
{
  QCirclePolyParseFrameLayout$1(QCirclePolyParseFrameLayout paramQCirclePolyParseFrameLayout, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((QCirclePolyParseFrameLayout.a(this.this$0) != null) && ((this.a instanceof QCirclePolyPraiseUpdateEvent)))
    {
      QCirclePolyPraiseUpdateEvent localQCirclePolyPraiseUpdateEvent = (QCirclePolyPraiseUpdateEvent)this.a;
      if (QCirclePolyParseFrameLayout.a(this.this$0).id.get().equals(localQCirclePolyPraiseUpdateEvent.mTargetFeedId)) {
        QCirclePolyParseFrameLayout.a(this.this$0, localQCirclePolyPraiseUpdateEvent.mNewStPolyLike);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolyParseFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */