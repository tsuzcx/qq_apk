package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;

public class QCirclePolymerizationPreLoaderTask
  extends BasePreLoadTask
{
  private QCirclePolymerizationBean a;
  
  public QCirclePolymerizationPreLoaderTask(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.a = paramQCirclePolymerizationBean;
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = new QCircleGetFeedListRequest((QCirclePolymerizationBean)localObject, null, null);
    paramOnPreLoadListener = new QCirclePolymerizationPreLoaderTask.1(this, paramOnPreLoadListener);
    ((QCircleGetFeedListRequest)localObject).setEnableCache(true);
    ((QCircleGetFeedListRequest)localObject).mRequest.extInfo.setHasFlag(true);
    ((QCircleGetFeedListRequest)localObject).mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, paramOnPreLoadListener);
    paramOnPreLoadListener = new StringBuilder();
    paramOnPreLoadListener.append("QCirclePolymerizationPreLoaderTask->sendQCircleRequest: CmdName:");
    paramOnPreLoadListener.append(((QCircleGetFeedListRequest)localObject).getCmdName());
    paramOnPreLoadListener.append("| TraceId:");
    paramOnPreLoadListener.append(((QCircleGetFeedListRequest)localObject).getTraceId());
    paramOnPreLoadListener.append(" | SeqId:");
    paramOnPreLoadListener.append(((QCircleGetFeedListRequest)localObject).getCurrentSeq());
    paramOnPreLoadListener.append(" | extInfo:");
    paramOnPreLoadListener.append(((FeedCloudCommon.Entry)((QCircleGetFeedListRequest)localObject).mRequest.extInfo.mapInfo.get(0)).key.get());
    paramOnPreLoadListener.append(": ");
    paramOnPreLoadListener.append(((FeedCloudCommon.Entry)((QCircleGetFeedListRequest)localObject).mRequest.extInfo.mapInfo.get(0)).value.get());
    QLog.d("QCirclePolymerizationPreLoaderTask", 1, paramOnPreLoadListener.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCirclePolymerizationPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */