package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicPreloadScroller$3
  implements Runnable
{
  QCircleFeedPicPreloadScroller$3(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Iterator localIterator = this.a.images.get().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (FeedCloudMeta.StImage)localIterator.next();
      Object localObject2 = new Option();
      boolean bool = true;
      localObject2 = ((Option)localObject2).setFromPreLoad(true);
      if (i != 0) {
        bool = false;
      }
      localObject1 = ((Option)localObject2).setPredecode(bool).setUrl(((FeedCloudMeta.StImage)localObject1).picUrl.get()).setRequestWidth(QCircleGridFeedItemView.PIC_LOAD_SIZE).setRequestHeight(QCircleGridFeedItemView.PIC_LOAD_SIZE);
      int j = i + 1;
      localObject1 = ((Option)localObject1).setPriority(j);
      localObject2 = QCircleFeedPicLoader.g().getCacheKey((Option)localObject1);
      if (!QCircleFeedPicPreloadScroller.a(this.this$0).containsKey(localObject2))
      {
        QCircleFeedPicLoader.g().loadImage((Option)localObject1, new QCircleFeedPicPreloadScroller.3.1(this));
        QCircleFeedPicPreloadScroller.a(this.this$0).put(localObject2, Boolean.valueOf(false));
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3
 * JD-Core Version:    0.7.0.1
 */