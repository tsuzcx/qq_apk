package com.tencent.biz.qqcircle.fragments.content.stick;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.List;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class QCircleStickTypeUtils
{
  public static boolean a(FeedCloudMeta.StFeed paramStFeed, int paramInt, boolean paramBoolean)
  {
    return b(paramStFeed, paramInt, paramBoolean) != null;
  }
  
  public static QQCircleFeedBase.StKuoliePasterData b(FeedCloudMeta.StFeed paramStFeed, int paramInt, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QLog.d("QCircleStickTypeUtils", 1, "[obtainExpandData] current feed not is null.");
      return null;
    }
    if (paramBoolean) {}
    try
    {
      paramStFeed = paramStFeed.images.get();
      if (paramInt < paramStFeed.size())
      {
        if (paramInt < -1) {
          return null;
        }
        paramStFeed = (FeedCloudMeta.StImage)paramStFeed.get(paramInt);
        Object localObject = new QQCircleFeedBase.StImageBusiData();
        ((QQCircleFeedBase.StImageBusiData)localObject).mergeFrom(paramStFeed.busiData.get().toByteArray());
        paramStFeed = ((QQCircleFeedBase.StImageBusiData)localObject).kuolie_data;
        break label124;
        paramStFeed = (FeedCloudMeta.StVideo)paramStFeed.video.get();
        localObject = new QQCircleFeedBase.StVideoBusiData();
        ((QQCircleFeedBase.StVideoBusiData)localObject).mergeFrom(paramStFeed.busiData.get().toByteArray());
        paramStFeed = ((QQCircleFeedBase.StVideoBusiData)localObject).kuolie_data;
        label124:
        return paramStFeed;
      }
    }
    catch (Exception paramStFeed)
    {
      QLog.e("QCircleStickTypeUtils", 1, paramStFeed, new Object[0]);
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleStickTypeUtils
 * JD-Core Version:    0.7.0.1
 */