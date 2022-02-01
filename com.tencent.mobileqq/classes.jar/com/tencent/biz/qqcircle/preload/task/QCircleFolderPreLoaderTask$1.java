package com.tencent.biz.qqcircle.preload.task;

import com.tencent.QCircleCollection;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class QCircleFolderPreLoaderTask$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetBusiInfoRsp>
{
  QCircleFolderPreLoaderTask$1(QCircleFolderPreLoaderTask paramQCircleFolderPreLoaderTask, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleFolderPreLoaderTask->onReceive: dispatch Success:");
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
    QLog.d("QCircleFolderPreLoaderTask", 1, localStringBuilder.toString());
    paramBaseRequest = this.a;
    if (paramBaseRequest != null) {
      paramBaseRequest.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetBusiInfoRsp });
    }
    QCircleCollection.a("QCircleFolderPreLoaderTask", "preload tab");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleFolderPreLoaderTask.1
 * JD-Core Version:    0.7.0.1
 */