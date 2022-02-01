package com.tencent.biz.qqcircle.datacenter.impl;

import com.tencent.biz.qqcircle.datacenter.request.QCircleFeedDetailListRequest;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCircleGlobalFeedCenterRspInterceptor;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QCircleFeedDetailWrapperProvider
  implements RspInterceptor<Object, BaseSenderChain<Object>>
{
  private int a;
  private int b;
  
  public QCircleFeedDetailWrapperProvider(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private Map<Integer, FeedBlockData> a(List<FeedBlockData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      TreeMap localTreeMap = new TreeMap();
      int i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedBlockData localFeedBlockData = (FeedBlockData)paramList.next();
        if ((localFeedBlockData != null) && (localFeedBlockData.b() != null) && (localFeedBlockData.b().dittoFeed != null) && (localFeedBlockData.b().dittoFeed.dittoId.get() != 0)) {
          localTreeMap.put(Integer.valueOf(i), localFeedBlockData);
        }
        i += 1;
      }
      return localTreeMap;
    }
    return null;
  }
  
  public String a()
  {
    return "QCircleFeedDetailWrapperProvider";
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, BaseSenderChain<Object> paramBaseSenderChain)
  {
    if ((!paramBoolean) && (paramLong != 0L))
    {
      paramBaseSenderChain.a(false, paramLong, paramString, paramObject1, paramObject2);
      return;
    }
    try
    {
      List localList = (List)paramObject2;
      if (localList != null)
      {
        if (localList.size() <= 0) {
          return;
        }
        QLog.d("QCircleFeedDetailWrapperProvider", 1, "send batch detail");
        localList = localList.subList(0, Math.min(this.b, localList.size()));
        QCircleRequestCall localQCircleRequestCall = QCircleRequestSender.a().b().b(false);
        try
        {
          localQCircleRequestCall.a(paramBaseSenderChain).a(new QCircleFeedDetailListRequest(this.a, QCircleTransFormHelper.b(localList))).a(new QCircleGlobalFeedCenterRspInterceptor(a(localList))).a();
          return;
        }
        catch (Exception localException1) {}
      }
      else
      {
        return;
      }
    }
    catch (Exception localException2)
    {
      QLog.e(a(), 1, localException2.getMessage(), localException2);
      localException2.printStackTrace();
      paramBaseSenderChain.a(false, paramLong, paramString, paramObject1, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.impl.QCircleFeedDetailWrapperProvider
 * JD-Core Version:    0.7.0.1
 */