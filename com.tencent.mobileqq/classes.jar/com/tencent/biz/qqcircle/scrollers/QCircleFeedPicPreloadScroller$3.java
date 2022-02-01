package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import uxx;
import vou;
import vrx;
import vsa;

public class QCircleFeedPicPreloadScroller$3
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$3(vrx paramvrx, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Iterator localIterator = this.a.images.get().iterator();
    int i = 0;
    boolean bool;
    if (localIterator.hasNext())
    {
      Object localObject1 = (FeedCloudMeta.StImage)localIterator.next();
      Object localObject2 = uxx.a(this.a, ((FeedCloudMeta.StImage)localObject1).width.get(), ((FeedCloudMeta.StImage)localObject1).height.get());
      vou localvou = new vou().b(true);
      if (i == 0)
      {
        bool = true;
        label82:
        localObject1 = localvou.a(bool).a(((FeedCloudMeta.StImage)localObject1).picUrl.get()).c(((Integer)((Pair)localObject2).first).intValue()).b(((Integer)((Pair)localObject2).second).intValue()).d(vou.b + i);
        localObject2 = QCircleFeedPicLoader.a().a((vou)localObject1);
        if (vrx.a(this.this$0).containsKey(localObject2)) {
          break label209;
        }
        QCircleFeedPicLoader.a().a((vou)localObject1, new vsa(this));
        i += 1;
        vrx.a(this.this$0).put(localObject2, Boolean.valueOf(false));
      }
    }
    label209:
    for (;;)
    {
      break;
      bool = false;
      break label82;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3
 * JD-Core Version:    0.7.0.1
 */