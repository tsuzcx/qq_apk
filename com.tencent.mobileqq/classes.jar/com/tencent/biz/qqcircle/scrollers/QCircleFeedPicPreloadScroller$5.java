package com.tencent.biz.qqcircle.scrollers;

import android.util.Pair;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

class QCircleFeedPicPreloadScroller$5
  implements Runnable
{
  QCircleFeedPicPreloadScroller$5(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedCloudMeta.StDittoFeed paramStDittoFeed) {}
  
  public void run()
  {
    Object localObject1 = new QQCircleDitto.StItemContainer();
    try
    {
      ((QQCircleDitto.StItemContainer)localObject1).mergeFrom(this.a.dittoData.get().toByteArray());
      Pair localPair = QCirclePreLoadPicUtil.a(((QQCircleDitto.StItemContainer)localObject1).styleType.get());
      if (((Integer)localPair.first).intValue() != 0)
      {
        if (((Integer)localPair.second).intValue() == 0) {
          return;
        }
        localObject1 = QCirclePreLoadPicUtil.a(((QQCircleDitto.StItemContainer)localObject1).items.get());
        int k = Math.min(((List)localObject1).size(), 6);
        int i = 0;
        int j = 0;
        while (i < k)
        {
          localObject2 = ((FeedCloudMeta.StImage)((QQCircleDitto.StItemInfo)((List)localObject1).get(i)).images.get().get(0)).picUrl.get();
          j = this.this$0.a(j, true, (String)localObject2, localPair);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject1 = QCircleFeedPicPreloadScroller.g();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" error ");
      ((StringBuilder)localObject2).append(localException.toString());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.5
 * JD-Core Version:    0.7.0.1
 */