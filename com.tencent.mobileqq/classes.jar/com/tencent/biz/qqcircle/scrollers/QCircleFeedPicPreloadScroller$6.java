package com.tencent.biz.qqcircle.scrollers;

import android.util.Pair;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;

class QCircleFeedPicPreloadScroller$6
  implements Runnable
{
  QCircleFeedPicPreloadScroller$6(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Iterator localIterator = this.a.images.get().iterator();
    FeedCloudMeta.StImage localStImage;
    Pair localPair;
    QCircleFeedPicPreloadScroller localQCircleFeedPicPreloadScroller;
    boolean bool;
    for (int i = 0; localIterator.hasNext(); i = localQCircleFeedPicPreloadScroller.a(i, bool, localStImage.picUrl.get(), localPair))
    {
      localStImage = (FeedCloudMeta.StImage)localIterator.next();
      localPair = QCirclePreLoadPicUtil.a(this.a, localStImage.width.get(), localStImage.height.get());
      localQCircleFeedPicPreloadScroller = this.this$0;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.6
 * JD-Core Version:    0.7.0.1
 */