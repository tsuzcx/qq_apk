package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StImageUrl;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;
import qqcircle.QQCircleReport.SingleDcData;

public class QCircleProtoUtil
{
  public static FeedBlockData a(byte[] paramArrayOfByte)
  {
    try
    {
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      localStFeed.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new FeedBlockData(localStFeed);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static List<FeedCloudEeveeBase.StEeveeAttachInfo> a(List<byte[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedCloudEeveeBase.StEeveeAttachInfo localStEeveeAttachInfo = c((byte[])paramList.next());
      if (localStEeveeAttachInfo != null) {
        localArrayList.add(localStEeveeAttachInfo);
      }
    }
    return localArrayList;
  }
  
  public static void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (paramStFeed == null)
    {
      QLog.d("QCircleProtoUtil", 1, "adjustFeedPicUrl stFeed is null");
      return;
    }
    if (paramStFeed.images.size() > 0)
    {
      paramStFeed = (FeedCloudMeta.StImage)paramStFeed.images.get(0);
      if ((paramStFeed != null) && (paramStFeed.vecImageUrl.size() > 0))
      {
        Iterator localIterator = paramStFeed.vecImageUrl.get().iterator();
        while (localIterator.hasNext())
        {
          FeedCloudMeta.StImageUrl localStImageUrl = (FeedCloudMeta.StImageUrl)localIterator.next();
          if (localStImageUrl.levelType.get() == paramInt)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setPic levelType:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append("   url:");
            localStringBuilder.append(localStImageUrl.url.get());
            QLog.d("QCircleProtoUtil", 1, localStringBuilder.toString());
            paramStFeed.picUrl.set(localStImageUrl.url.get());
          }
        }
      }
    }
  }
  
  public static void a(FeedCloudMeta.StPushList paramStPushList)
  {
    if (paramStPushList == null)
    {
      QLog.d("QCircleProtoUtil", 1, "pushInfo is null");
      return;
    }
    int i = paramStPushList.hasClickCount.get();
    int j = paramStPushList.totalClickCount.get();
    paramStPushList.status.set(0);
    paramStPushList.totalClickCount.set(j - i);
    paramStPushList.hasClickCount.set(0);
    List localList = paramStPushList.vecUser.get();
    String str = HostDataTransUtils.getAccount();
    if ((localList.size() > 0) && (((FeedCloudMeta.StUser)localList.get(0)).id.get().equals(str)))
    {
      localList.remove(0);
      paramStPushList.count.set(paramStPushList.count.get() - 1);
    }
  }
  
  public static void a(FeedCloudMeta.StPushList paramStPushList, int paramInt)
  {
    if (paramStPushList == null)
    {
      QLog.d("QCircleProtoUtil", 1, "pushInfo is null");
      return;
    }
    int j = paramStPushList.hasClickCount.get();
    Object localObject = paramStPushList.status;
    int i;
    if (paramInt > 0) {
      i = 1;
    } else {
      i = 0;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = paramStPushList.vecUser.get();
    if ((paramInt > 0) && ((((List)localObject).size() <= 0) || (!((FeedCloudMeta.StUser)((List)localObject).get(0)).id.get().equals(HostDataTransUtils.getAccount()))))
    {
      QLog.d("QCircleProtoUtil", 1, "is not in pushList add user");
      ((List)localObject).add(0, QCirclePluginGlobalInfo.c());
      paramStPushList.count.set(paramStPushList.count.get() + 1);
    }
    paramStPushList.totalClickCount.set(paramInt - j + paramStPushList.totalClickCount.get());
    paramStPushList.hasClickCount.set(paramInt);
  }
  
  public static List<FeedBlockData> b(List<byte[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (byte[])paramList.next();
      if (localObject != null)
      {
        localObject = a((byte[])localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static QQCirclePrivateMsgShow.UserPMGiftInfo b(byte[] paramArrayOfByte)
  {
    try
    {
      QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = new QQCirclePrivateMsgShow.UserPMGiftInfo();
      localUserPMGiftInfo.mergeFrom(paramArrayOfByte);
      return localUserPMGiftInfo;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static FeedCloudEeveeBase.StEeveeAttachInfo c(byte[] paramArrayOfByte)
  {
    try
    {
      FeedCloudEeveeBase.StEeveeAttachInfo localStEeveeAttachInfo = new FeedCloudEeveeBase.StEeveeAttachInfo();
      localStEeveeAttachInfo.mergeFrom(paramArrayOfByte);
      return localStEeveeAttachInfo;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static List<byte[]> c(List<QQCircleReport.SingleDcData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((QQCircleReport.SingleDcData)paramList.next()).toByteArray());
    }
    return localArrayList;
  }
  
  public static List<byte[]> d(List<QQCirclePrivateMsgShow.UserPMGiftInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((QQCirclePrivateMsgShow.UserPMGiftInfo)paramList.next()).toByteArray());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleProtoUtil
 * JD-Core Version:    0.7.0.1
 */