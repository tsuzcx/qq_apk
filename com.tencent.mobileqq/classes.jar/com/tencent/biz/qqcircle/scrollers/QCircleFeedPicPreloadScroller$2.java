package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicPreloadScroller$2
  implements Runnable
{
  QCircleFeedPicPreloadScroller$2(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Option localOption = new Option().setFromPreLoad(true).setPredecode(true).setPriority(1).setUrl(this.a.cover.picUrl.get()).setRequestWidth(QCircleGridFeedItemView.PIC_LOAD_SIZE).setRequestHeight(QCircleGridFeedItemView.PIC_LOAD_SIZE);
    String str = QCircleFeedPicLoader.g().getCacheKey(localOption);
    if (!QCircleFeedPicPreloadScroller.a(this.this$0).containsKey(str))
    {
      QCircleFeedPicLoader.g().loadImage(localOption, new QCircleFeedPicPreloadScroller.2.1(this));
      QCircleFeedPicPreloadScroller.a(this.this$0).put(str, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2
 * JD-Core Version:    0.7.0.1
 */