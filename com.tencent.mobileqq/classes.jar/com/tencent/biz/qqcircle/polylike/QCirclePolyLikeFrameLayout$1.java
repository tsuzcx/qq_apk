package com.tencent.biz.qqcircle.polylike;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.concurrent.ConcurrentHashMap;

class QCirclePolyLikeFrameLayout$1
  implements Runnable
{
  QCirclePolyLikeFrameLayout$1(QCirclePolyLikeFrameLayout paramQCirclePolyLikeFrameLayout, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((this.a instanceof QCirclePolyPraiseUpdateEvent))
    {
      String str1;
      if (QCirclePolyLikeFrameLayout.a(this.this$0) == null) {
        str1 = "";
      } else {
        str1 = QCirclePolyLikeFrameLayout.a(this.this$0).id.get();
      }
      if (TextUtils.isEmpty(str1))
      {
        QLog.d("QCirclePraise_", 1, "[onReceiveEvent] feed id not is null.");
        return;
      }
      QCirclePolyPraiseUpdateEvent localQCirclePolyPraiseUpdateEvent = (QCirclePolyPraiseUpdateEvent)this.a;
      String str2 = localQCirclePolyPraiseUpdateEvent.mTargetFeedId;
      QLog.d("QCirclePraise_", 1, new Object[] { "[onReceiveEvent] current feed id: ", str1, " | eventFeedId: ", str2 });
      if (TextUtils.equals(str1, str2))
      {
        if (QCirclePolyLikeFrameLayout.b(this.this$0))
        {
          int i = localQCirclePolyPraiseUpdateEvent.mPraisedStatus;
          int j = localQCirclePolyPraiseUpdateEvent.mPraisedNum;
          QCirclePolyLikeFrameLayout.a(this.this$0, i, j);
          return;
        }
        QCirclePolyLikeFrameLayout.a(this.this$0, localQCirclePolyPraiseUpdateEvent.mNewStPolyLike);
        return;
      }
      QCirclePolyLikeFrameLayout.a.put(localQCirclePolyPraiseUpdateEvent.mTargetFeedId, localQCirclePolyPraiseUpdateEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */