package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

class QCircleFeedPicPreloadScroller$4
  implements Runnable
{
  QCircleFeedPicPreloadScroller$4(QCircleFeedPicPreloadScroller paramQCircleFeedPicPreloadScroller, FeedCloudMeta.StDittoFeed paramStDittoFeed) {}
  
  public void run()
  {
    Object localObject = new QQCircleDitto.StItemContainer();
    try
    {
      ((QQCircleDitto.StItemContainer)localObject).mergeFrom(this.a.dittoData.get().toByteArray());
      localObject = QCirclePreLoadPicUtil.b(((QQCircleDitto.StItemContainer)localObject).items.get());
      int j = Math.min(((List)localObject).size(), 2);
      int i = 0;
      while (i < j)
      {
        boolean bool = QCircleFeedPicPreloadScroller.a(this.this$0, (List)localObject, 0, i);
        if (bool) {
          return;
        }
        i += 1;
      }
      String str;
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = QCircleFeedPicPreloadScroller.g();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" error ");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.4
 * JD-Core Version:    0.7.0.1
 */