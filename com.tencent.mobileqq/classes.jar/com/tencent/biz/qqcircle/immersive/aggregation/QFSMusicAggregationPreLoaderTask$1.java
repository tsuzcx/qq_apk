package com.tencent.biz.qqcircle.immersive.aggregation;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QFSMusicAggregationPreLoaderTask$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QFSMusicAggregationPreLoaderTask$1(QFSMusicAggregationPreLoaderTask paramQFSMusicAggregationPreLoaderTask, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSMusicAggregationPreLoaderTask->onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" |CmdName:");
    localStringBuilder.append(paramBaseRequest.getCmdName());
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    QLog.d("QFSMusicAggregationPreLoaderTask", 1, localStringBuilder.toString());
    paramBaseRequest = this.a;
    if (paramBaseRequest != null) {
      paramBaseRequest.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetFeedListRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationPreLoaderTask.1
 * JD-Core Version:    0.7.0.1
 */