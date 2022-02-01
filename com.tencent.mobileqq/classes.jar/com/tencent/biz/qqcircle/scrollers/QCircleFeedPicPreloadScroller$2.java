package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import vou;
import vrx;
import vrz;

public class QCircleFeedPicPreloadScroller$2
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$2(vrx paramvrx, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Iterator localIterator = this.a.images.get().iterator();
    int i = 0;
    boolean bool;
    if (localIterator.hasNext())
    {
      Object localObject1 = (FeedCloudMeta.StImage)localIterator.next();
      Object localObject2 = new vou().b(true);
      if (i == 0)
      {
        bool = true;
        label57:
        localObject1 = ((vou)localObject2).a(bool).a(((FeedCloudMeta.StImage)localObject1).picUrl.get()).c(QCircleGridFeedItemView.b).b(QCircleGridFeedItemView.b).d(vou.b + i);
        localObject2 = QCircleFeedPicLoader.a().a((vou)localObject1);
        if (vrx.a(this.this$0).containsKey(localObject2)) {
          break label168;
        }
        QCircleFeedPicLoader.a().a((vou)localObject1, new vrz(this));
        i += 1;
        vrx.a(this.this$0).put(localObject2, Boolean.valueOf(false));
      }
    }
    label168:
    for (;;)
    {
      break;
      bool = false;
      break label57;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2
 * JD-Core Version:    0.7.0.1
 */