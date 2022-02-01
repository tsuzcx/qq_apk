package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.richframework.helper.VideoPreloadHelper;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedVideoPreloadScroller$1
  implements Runnable
{
  QCircleFeedVideoPreloadScroller$1(QCircleFeedVideoPreloadScroller paramQCircleFeedVideoPreloadScroller, String paramString, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    if (!QCircleFeedVideoPreloadScroller.a(this.this$0).containsKey(this.a))
    {
      QCircleFeedVideoPreloadScroller.b(this.this$0).a(this.b);
      ConcurrentHashMap localConcurrentHashMap = QCircleFeedVideoPreloadScroller.a(this.this$0);
      String str = this.a;
      localConcurrentHashMap.put(str, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedVideoPreloadScroller.1
 * JD-Core Version:    0.7.0.1
 */