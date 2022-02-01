package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.concurrent.ConcurrentHashMap;
import vrd;
import vuj;
import vuk;

public class QCircleFeedPicPreloadScroller$1
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$1(vuj paramvuj, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    vrd localvrd = new vrd().b(true).a(true).d(vrd.b).a(this.a.cover.picUrl.get()).c(QCircleGridFeedItemView.b).b(QCircleGridFeedItemView.b);
    String str = QCircleFeedPicLoader.a().a(localvrd);
    if (!vuj.a(this.this$0).containsKey(str))
    {
      QCircleFeedPicLoader.a().a(localvrd, new vuk(this));
      vuj.a(this.this$0).put(str, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1
 * JD-Core Version:    0.7.0.1
 */