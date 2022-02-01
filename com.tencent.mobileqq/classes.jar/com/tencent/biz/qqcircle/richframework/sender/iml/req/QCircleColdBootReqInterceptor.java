package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootService;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class QCircleColdBootReqInterceptor
  implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  private boolean a(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain, QCircleTabGetFeedListRequest paramQCircleTabGetFeedListRequest, @NonNull IPreloadTask paramIPreloadTask)
  {
    String str = paramIPreloadTask.getAttachInfo();
    byte[] arrayOfByte = paramIPreloadTask.getPreloadRspData();
    paramIPreloadTask = new FeedCloudRead.StGetFeedListRsp();
    try
    {
      paramIPreloadTask.mergeFrom(arrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    if ((!TextUtils.isEmpty(str)) && (paramIPreloadTask.has()))
    {
      paramQCircleTabGetFeedListRequest.setAttachInfo(str);
      paramBaseSenderChain.a(true, 0L, "", paramQCircleBaseRequest, paramIPreloadTask);
      QLog.d(a(), 1, "intercept success");
      return true;
    }
    paramQCircleBaseRequest = a();
    paramBaseSenderChain = new StringBuilder();
    paramBaseSenderChain.append("intercept failed! attachInfo: ");
    paramBaseSenderChain.append(str);
    paramBaseSenderChain.append(",rsp: ");
    paramBaseSenderChain.append(paramIPreloadTask.has());
    QLog.e(paramQCircleBaseRequest, 1, paramBaseSenderChain.toString());
    return false;
  }
  
  public String a()
  {
    return "QCircleColdBootReqInterceptor";
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if (((paramQCircleBaseRequest instanceof QCircleTabGetFeedListRequest)) && (!b(paramQCircleBaseRequest, paramBaseSenderChain))) {
      c(paramQCircleBaseRequest, paramBaseSenderChain);
    }
  }
  
  boolean b(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    QCircleTabGetFeedListRequest localQCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest)paramQCircleBaseRequest;
    int i = localQCircleTabGetFeedListRequest.getRequestSource();
    if (((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).isAvailable(i))
    {
      IPreloadTask localIPreloadTask = ((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).getTask(i);
      if (localIPreloadTask == null)
      {
        QLog.d(a(), 1, new Object[] { "can't find preload task,source: ", Integer.valueOf(i) });
        return false;
      }
      QLog.d(a(), 1, new Object[] { "find preload task,source: ", Integer.valueOf(i) });
      QCirclePeriodCollect.setState(String.valueOf(i), null);
      return a(paramQCircleBaseRequest, paramBaseSenderChain, localQCircleTabGetFeedListRequest, localIPreloadTask);
    }
    return false;
  }
  
  void c(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    QLog.d(a(), 1, "unIntercept");
    paramBaseSenderChain.a(paramQCircleBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleColdBootReqInterceptor
 * JD-Core Version:    0.7.0.1
 */