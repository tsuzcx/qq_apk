package com.tencent.biz.qqcircle.scrollers;

import android.util.Pair;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicPreloadScroller$8
  implements Runnable
{
  QCircleFeedPicPreloadScroller$8(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Object localObject = this.a;
    localObject = QCirclePreLoadPicUtil.a((FeedCloudMeta.StFeed)localObject, ((FeedCloudMeta.StFeed)localObject).video.width.get(), this.a.video.height.get());
    localObject = new Option().setFromPreLoad(true).setPredecode(true).setPriority(1).setUrl(this.a.cover.picUrl.get()).setRequestWidth(((Integer)((Pair)localObject).first).intValue()).setRequestHeight(((Integer)((Pair)localObject).second).intValue());
    String str = QCircleFeedPicLoader.g().getCacheKey((Option)localObject);
    if (!QCircleFeedPicPreloadScroller.a(this.this$0).containsKey(str))
    {
      QCircleFeedPicLoader.g().loadImage((Option)localObject, new QCircleFeedPicPreloadScroller.8.1(this));
      QCircleFeedPicPreloadScroller.a(this.this$0).put(str, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.8
 * JD-Core Version:    0.7.0.1
 */