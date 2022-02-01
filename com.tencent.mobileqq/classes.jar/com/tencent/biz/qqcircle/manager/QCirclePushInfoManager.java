package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleUndoPushReqInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCirclePushInfoManager
{
  private static volatile QCirclePushInfoManager a;
  private ConcurrentHashMap<String, FeedCloudMeta.StPushList> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  
  public static QCirclePushInfoManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCirclePushInfoManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public FeedCloudMeta.StPushList a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new FeedCloudMeta.StPushList();
    }
    return (FeedCloudMeta.StPushList)this.b.get(paramString);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QCirclePushReportReqInterceptor paramQCirclePushReportReqInterceptor)
  {
    Object localObject1 = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      ((QQCircleFeedBase.StFeedBusiReqData)localObject1).mergeFrom(paramStFeed.busiData.get().toByteArray());
      localObject1 = ((QQCircleFeedBase.StFeedBusiReqData)localObject1).pushList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    Object localObject2 = new QCircleDoRecommendRequest(paramStFeed, 0, (FeedCloudMeta.StPushList)localObject2, 1);
    QCircleRequestSender.a().b().b(paramQCirclePushReportReqInterceptor).b(new QCircleUndoPushReqInterceptor(true, null)).a(localObject2).a(new QCirclePushInfoManager.1(this, paramStFeed)).a();
  }
  
  public void a(String paramString, FeedCloudMeta.StPushList paramStPushList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramStPushList == null) {
        return;
      }
      Object localObject = a(paramString);
      if ((localObject != null) && (((FeedCloudMeta.StPushList)localObject).totalClickCount.get() > paramStPushList.totalClickCount.get()))
      {
        paramStPushList.set((MessageMicro)localObject);
        paramStPushList = new StringBuilder();
        paramStPushList.append("setPushInfo from Manager feedId");
        paramStPushList.append(paramString);
        QLog.d("QCirclePushTimesManager", 4, paramStPushList.toString());
        return;
      }
      this.b.put(paramString, paramStPushList);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePushInfo feedId");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QCirclePushTimesManager", 4, ((StringBuilder)localObject).toString());
      c(paramString, paramStPushList);
    }
  }
  
  public void a(List<FeedCloudMeta.StFeed> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)paramList.next();
      Object localObject = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(localStFeed.busiData.get().toByteArray());
        localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList;
        a().b(localStFeed.id.get(), (FeedCloudMeta.StPushList)localObject);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    ConcurrentHashMap localConcurrentHashMap = this.b;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public void b(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.putIfAbsent(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public void b(String paramString, FeedCloudMeta.StPushList paramStPushList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramStPushList == null) {
        return;
      }
      c(paramString, paramStPushList);
      this.b.put(paramString, paramStPushList);
    }
  }
  
  public void c(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramString);
    }
  }
  
  public void c(String paramString, FeedCloudMeta.StPushList paramStPushList)
  {
    MutableLiveData localMutableLiveData = QCircleFeedDataCenter.a().a(FeedBlockData.class, paramString);
    if (localMutableLiveData == null) {
      return;
    }
    FeedBlockData localFeedBlockData = (FeedBlockData)localMutableLiveData.getValue();
    if (localFeedBlockData == null) {
      return;
    }
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = (QQCircleFeedBase.StFeedBusiReqData)localFeedBlockData.a("DITTO_FEED_BUSI_REQ_DATA");
    paramString = localStFeedBusiReqData;
    if (localStFeedBusiReqData == null) {
      paramString = new QQCircleFeedBase.StFeedBusiReqData();
    }
    paramString.pushList.set(paramStPushList);
    localFeedBlockData.a("DITTO_FEED_BUSI_REQ_DATA", paramString);
    localMutableLiveData.postValue(localFeedBlockData);
  }
  
  public boolean d(String paramString)
  {
    paramString = (Long)this.c.get(paramString);
    return (paramString != null) && (System.currentTimeMillis() - 60000L <= paramString.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCirclePushInfoManager
 * JD-Core Version:    0.7.0.1
 */