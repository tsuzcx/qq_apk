package com.tencent.biz.qqcircle.flutter;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class QQCircleMethodMine$8
  implements VSDispatchObserver.onVSRspCallBack
{
  QQCircleMethodMine$8(MethodChannel.Result paramResult) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    paramObject = paramBaseRequest.getCmdName();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[sendSsoRequest][onReceive] cmd=");
    ((StringBuilder)localObject1).append(paramObject);
    ((StringBuilder)localObject1).append(", success=");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", retCode=");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(", errMsg=");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("QQCircleMethodMine", 1, ((StringBuilder)localObject1).toString());
    if (!(paramBaseRequest instanceof QCircleFlutterRequest))
    {
      paramString = new StringBuilder();
      paramString.append("[onReceive] invalid request, request=");
      paramString.append(paramBaseRequest);
      QLog.e("QQCircleMethodMine", 1, paramString.toString());
      return;
    }
    localObject1 = ((QCircleFlutterRequest)paramBaseRequest).getResponseByteData();
    if (("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList".equals(paramObject)) && (paramBoolean))
    {
      Object localObject2 = new FeedCloudRead.StGetFeedListRsp();
      try
      {
        ((FeedCloudRead.StGetFeedListRsp)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = ((FeedCloudRead.StGetFeedListRsp)localObject2).vecFeed.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((Iterator)localObject2).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[sendSsoRequest] feed id=");
          localStringBuilder.append(localStFeed.id.get());
          QLog.d("QQCircleMethodMine", 1, localStringBuilder.toString());
          QQCircleMethodMine.access$800().put(localStFeed.id.get(), localStFeed);
        }
        QQCircleMethodMine.access$902(QQCircleMethodMine.access$900() + localObject1.length);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[sendSsoRequest][onReceive] feedBytesLength=");
        ((StringBuilder)localObject2).append(QQCircleMethodMine.access$900());
        ((StringBuilder)localObject2).append(", feed size=");
        ((StringBuilder)localObject2).append(QQCircleMethodMine.access$800().size());
        QLog.d("QQCircleMethodMine", 1, ((StringBuilder)localObject2).toString());
      }
      catch (Exception localException)
      {
        QLog.e("QQCircleMethodMine", 1, "sendSsoRequest", localException);
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cmd", paramObject);
    localHashMap.put("isSuc", Boolean.valueOf(paramBoolean));
    localHashMap.put("errCode", Long.valueOf(paramLong));
    localHashMap.put("errDesc", paramString);
    localHashMap.put("body", localObject1);
    localHashMap.put("ssoSeq", Integer.valueOf(paramBaseRequest.getCurrentSeq()));
    this.a.success(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.8
 * JD-Core Version:    0.7.0.1
 */