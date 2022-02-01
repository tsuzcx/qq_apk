package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;

public class QCircleMessagePreLoaderTask
  extends BasePreLoadTask
{
  private boolean a;
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    QCircleMessageNoticeRequest localQCircleMessageNoticeRequest = new QCircleMessageNoticeRequest(null, this.a);
    paramOnPreLoadListener = new QCircleMessagePreLoaderTask.1(this, paramOnPreLoadListener);
    localQCircleMessageNoticeRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localQCircleMessageNoticeRequest, paramOnPreLoadListener);
    paramOnPreLoadListener = new StringBuilder();
    paramOnPreLoadListener.append("QCircleMessagePreLoader->sendQCircleRequest: CmdName:");
    paramOnPreLoadListener.append(localQCircleMessageNoticeRequest.getCmdName());
    paramOnPreLoadListener.append("| TraceId:");
    paramOnPreLoadListener.append(localQCircleMessageNoticeRequest.getTraceId());
    paramOnPreLoadListener.append(" | SeqId:");
    paramOnPreLoadListener.append(localQCircleMessageNoticeRequest.getCurrentSeq());
    QLog.d("QCircleMessagePreLoader", 1, paramOnPreLoadListener.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleMessagePreLoaderTask
 * JD-Core Version:    0.7.0.1
 */