package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;

class QCircleMessagePreLoaderTask$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetNoticeListRsp>
{
  QCircleMessagePreLoaderTask$1(QCircleMessagePreLoaderTask paramQCircleMessagePreLoaderTask, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetNoticeListRsp paramStGetNoticeListRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleMessagePreLoader->onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" |CmdName:");
    localStringBuilder.append(paramBaseRequest.getCmdName());
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    QLog.d("QCircleMessagePreLoader", 1, localStringBuilder.toString());
    paramBaseRequest = this.a;
    if (paramBaseRequest != null) {
      paramBaseRequest.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetNoticeListRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleMessagePreLoaderTask.1
 * JD-Core Version:    0.7.0.1
 */