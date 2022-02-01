package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.concurrent.ConcurrentHashMap;
import uxx;
import vou;
import vrx;
import vsb;

public class QCircleFeedPicPreloadScroller$4
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$4(vrx paramvrx, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Object localObject = uxx.a(this.a, this.a.video.width.get(), this.a.video.height.get());
    localObject = new vou().b(true).a(true).d(vou.b).a(this.a.cover.picUrl.get()).c(((Integer)((Pair)localObject).first).intValue()).b(((Integer)((Pair)localObject).second).intValue());
    String str = QCircleFeedPicLoader.a().a((vou)localObject);
    if (!vrx.a(this.this$0).containsKey(str))
    {
      QCircleFeedPicLoader.a().a((vou)localObject, new vsb(this));
      vrx.a(this.this$0).put(str, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.4
 * JD-Core Version:    0.7.0.1
 */