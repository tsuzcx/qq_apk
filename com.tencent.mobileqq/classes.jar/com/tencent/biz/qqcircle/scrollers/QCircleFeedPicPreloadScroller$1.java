package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StImage;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StPicTextBanner;

class QCircleFeedPicPreloadScroller$1
  implements Runnable
{
  QCircleFeedPicPreloadScroller$1(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedBlockData paramFeedBlockData) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && ((((FeedBlockData)localObject).a("DITTO_GUIDE_PUBLISH_BANNER") instanceof QQCircleDitto.StCircleDittoDataNew)))
    {
      String str1 = ((QQCircleDitto.StCircleDittoDataNew)this.a.a("DITTO_GUIDE_PUBLISH_BANNER")).picTextBanner.backgroundImage.picUrl.get();
      localObject = new Option().setFromPreLoad(true).setUrl(str1);
      String str2 = QCircleFeedPicPreloadScroller.g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload guide url:");
      localStringBuilder.append(str1);
      QLog.d(str2, 1, localStringBuilder.toString());
      str1 = QCircleFeedPicLoader.g().getCacheKey((Option)localObject);
      if (!QCircleFeedPicPreloadScroller.a(this.this$0).containsKey(str1))
      {
        QCircleFeedPicLoader.g().loadImage((Option)localObject, new QCircleFeedPicPreloadScroller.1.1(this));
        QCircleFeedPicPreloadScroller.a(this.this$0).put(str1, Boolean.valueOf(false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1
 * JD-Core Version:    0.7.0.1
 */