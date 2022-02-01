package com.tencent.biz.qqcircle.immersive.utils;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QFSShareInfoUtils
{
  public static QCircleShareInfo a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleShareInfo localQCircleShareInfo = new QCircleShareInfo();
    localQCircleShareInfo.c = new QCircleExtraTypeInfo();
    localQCircleShareInfo.b = paramStFeed;
    localQCircleShareInfo.d = 0;
    localQCircleShareInfo.j = (QCirclePluginUtil.d(localQCircleShareInfo.b) ^ true);
    localQCircleShareInfo.k = true;
    localQCircleShareInfo.i = QCirclePluginUtil.d(localQCircleShareInfo.b);
    localQCircleShareInfo.l = false;
    localQCircleShareInfo.m = false;
    if (paramStFeed == null) {
      return localQCircleShareInfo;
    }
    b(paramStFeed, localQCircleShareInfo);
    a(paramStFeed, localQCircleShareInfo);
    return localQCircleShareInfo;
  }
  
  private static void a(@NonNull FeedCloudMeta.StFeed paramStFeed, @NonNull QCircleShareInfo paramQCircleShareInfo)
  {
    List localList = paramStFeed.opMask2.get();
    if (localList != null)
    {
      boolean bool2 = QCirclePluginUtil.b((FeedCloudMeta.StUser)paramStFeed.poster.get());
      boolean bool1 = true;
      if ((bool2) || (!localList.contains(Integer.valueOf(1)))) {
        bool1 = false;
      }
      paramQCircleShareInfo.m = bool1;
      paramQCircleShareInfo.p = localList.contains(Integer.valueOf(10));
    }
  }
  
  private static void b(@NonNull FeedCloudMeta.StFeed paramStFeed, @NonNull QCircleShareInfo paramQCircleShareInfo)
  {
    Object localObject = new QQCircleFeedBase.StFeedBusiReqData();
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(paramStFeed.busiData.get().toByteArray());
        List localList = ((QQCircleFeedBase.StFeedBusiReqData)localObject).uninterest_buttons.get();
        boolean bool2 = false;
        if ((localList == null) || (localList.size() <= 0)) {
          break label132;
        }
        bool1 = true;
        paramQCircleShareInfo.l = bool1;
        localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList;
        if ((localObject != null) && (((FeedCloudMeta.StPushList)localObject).hasClickCount.get() > 0))
        {
          boolean bool3 = QCirclePushInfoManager.a().d(paramStFeed.id.get());
          paramQCircleShareInfo.n = bool3;
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
          paramQCircleShareInfo.o = bool1;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        QLog.e("QFSShareInfoUtils", 1, "[createShareInfo] error: ", paramStFeed);
      }
      return;
      label132:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSShareInfoUtils
 * JD-Core Version:    0.7.0.1
 */