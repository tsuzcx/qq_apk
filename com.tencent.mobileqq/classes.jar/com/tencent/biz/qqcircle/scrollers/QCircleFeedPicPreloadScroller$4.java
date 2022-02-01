package com.tencent.biz.qqcircle.scrollers;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import vuj;
import vwk;

public class QCircleFeedPicPreloadScroller$4
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$4(vuj paramvuj, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Iterator localIterator = this.a.images.get().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)localIterator.next();
      Pair localPair = vwk.a(this.a, localStImage.width.get(), localStImage.height.get());
      vuj localvuj = this.this$0;
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        i = localvuj.a(i, bool, localStImage.picUrl.get(), localPair);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.4
 * JD-Core Version:    0.7.0.1
 */