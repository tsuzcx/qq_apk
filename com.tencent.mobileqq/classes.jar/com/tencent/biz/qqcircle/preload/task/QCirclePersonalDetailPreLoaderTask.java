package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetMainPageReq;

public class QCirclePersonalDetailPreLoaderTask
  extends BasePreLoadTask
{
  private String a;
  private QCircleInitBean b;
  
  public QCirclePersonalDetailPreLoaderTask(String paramString, QCircleInitBean paramQCircleInitBean)
  {
    this.a = paramString;
    this.b = paramQCircleInitBean;
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    QCircleGetMainPageRequest localQCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.a, null, this.b);
    localQCircleGetMainPageRequest.mRequest.extInfo.setHasFlag(true);
    localQCircleGetMainPageRequest.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    paramOnPreLoadListener = new QCirclePersonalDetailPreLoaderTask.1(this, paramOnPreLoadListener);
    localQCircleGetMainPageRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localQCircleGetMainPageRequest, paramOnPreLoadListener);
    paramOnPreLoadListener = new StringBuilder();
    paramOnPreLoadListener.append("QCirclePersonalDetailPreLoaderTask->sendQCircleRequest: CmdName:");
    paramOnPreLoadListener.append(localQCircleGetMainPageRequest.getCmdName());
    paramOnPreLoadListener.append("| TraceId:");
    paramOnPreLoadListener.append(localQCircleGetMainPageRequest.getTraceId());
    paramOnPreLoadListener.append(" | SeqId:");
    paramOnPreLoadListener.append(localQCircleGetMainPageRequest.getCurrentSeq());
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, paramOnPreLoadListener.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCirclePersonalDetailPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */