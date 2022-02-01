package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.concurrent.ConcurrentHashMap;
import vrd;
import vuj;
import vum;
import vwk;

public class QCircleFeedPicPreloadScroller$3
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$3(vuj paramvuj, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Object localObject1 = (FeedCloudMeta.StImage)this.a.cover.get();
    Object localObject2 = vwk.a(this.a, ((FeedCloudMeta.StImage)localObject1).width.get(), ((FeedCloudMeta.StImage)localObject1).height.get());
    localObject1 = new vrd().b(true).a(true).a(((FeedCloudMeta.StImage)localObject1).picUrl.get()).c(((Integer)((Pair)localObject2).first).intValue()).b(((Integer)((Pair)localObject2).second).intValue()).d(vrd.b);
    localObject2 = QCircleFeedPicLoader.a().a((vrd)localObject1);
    if (!vuj.a(this.this$0).containsKey(localObject2))
    {
      QCircleFeedPicLoader.a().a((vrd)localObject1, new vum(this));
      vuj.a(this.this$0).put(localObject2, Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3
 * JD-Core Version:    0.7.0.1
 */