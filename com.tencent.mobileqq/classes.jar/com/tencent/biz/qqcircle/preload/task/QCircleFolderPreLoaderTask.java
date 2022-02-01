package com.tencent.biz.qqcircle.preload.task;

import android.text.TextUtils;
import com.tencent.QCircleCollection;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import java.util.List;

public class QCircleFolderPreLoaderTask
  extends BasePreLoadTask
{
  FeedCloudMeta.StGPSV2 a;
  QCircleFolderBean b;
  
  public QCircleFolderPreLoaderTask(FeedCloudMeta.StGPSV2 paramStGPSV2, QCircleFolderBean paramQCircleFolderBean)
  {
    this.a = paramStGPSV2;
    this.b = paramQCircleFolderBean;
  }
  
  private void a(QCircleGetTabListRequest paramQCircleGetTabListRequest)
  {
    if ((paramQCircleGetTabListRequest != null) && (paramQCircleGetTabListRequest.mReq != null))
    {
      if (paramQCircleGetTabListRequest.mReq.extInfo == null) {
        return;
      }
      FeedCloudCommon.StCommonExt localStCommonExt = (FeedCloudCommon.StCommonExt)paramQCircleGetTabListRequest.mReq.extInfo.get();
      List localList1 = paramQCircleGetTabListRequest.mReq.extInfo.mapBytesInfo.get();
      List localList2 = paramQCircleGetTabListRequest.mReq.extInfo.mapInfo.get();
      Object localObject = QCircleReportHelper.getInstance().getInviteId();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).getBytes();
        if (localObject != null)
        {
          FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
          localBytesEntry.key.set("circle_invite");
          localBytesEntry.value.set(ByteStringMicro.copyFrom((byte[])localObject));
          localList1.add(localBytesEntry);
        }
        localStCommonExt.mapBytesInfo.set(localList1);
      }
      localList2.add(QCircleReportFirstLogin.getFirstLoginEntry());
      localStCommonExt.mapInfo.set(localList2);
      paramQCircleGetTabListRequest.mReq.extInfo.set(localStCommonExt);
    }
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    QCircleCollection.a("QCircleFolderPreLoaderTask");
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(this.a, this.b);
    paramOnPreLoadListener = new QCircleFolderPreLoaderTask.1(this, paramOnPreLoadListener);
    a(localQCircleGetTabListRequest);
    VSNetworkHelper.getInstance().sendRequest(localQCircleGetTabListRequest, paramOnPreLoadListener);
    paramOnPreLoadListener = new StringBuilder();
    paramOnPreLoadListener.append("QCircleFolderPreLoaderTask->sendQCircleRequest: CmdName:");
    paramOnPreLoadListener.append(localQCircleGetTabListRequest.getCmdName());
    paramOnPreLoadListener.append("| TraceId:");
    paramOnPreLoadListener.append(localQCircleGetTabListRequest.getTraceId());
    paramOnPreLoadListener.append(" | SeqId:");
    paramOnPreLoadListener.append(localQCircleGetTabListRequest.getCurrentSeq());
    paramOnPreLoadListener.append(" | extInfo:");
    paramOnPreLoadListener.append(((FeedCloudCommon.Entry)localQCircleGetTabListRequest.mReq.extInfo.mapInfo.get(0)).key.get());
    paramOnPreLoadListener.append(": ");
    paramOnPreLoadListener.append(((FeedCloudCommon.Entry)localQCircleGetTabListRequest.mReq.extInfo.mapInfo.get(0)).value.get());
    QLog.d("QCircleFolderPreLoaderTask", 1, paramOnPreLoadListener.toString());
    if ((QCircleFuelAnimationManager.a().c()) || (!QCircleFuelAnimationManager.a().b()))
    {
      paramOnPreLoadListener = new QCircleGetTaskCenterListRequest(HostDataTransUtils.getAccount());
      localQCircleGetTabListRequest.setEnableCache(true);
      VSNetworkHelper.getInstance().sendRequest(paramOnPreLoadListener, new QCircleFolderPreLoaderTask.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleFolderPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */