package com.tencent.biz.qqcircle.fragments.main;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudRead.StClearCountRsp;
import feedcloud.FeedCloudRead.StClearCountRspInfo;
import java.util.Iterator;
import java.util.List;

class QCircleFolderRcmdTabFragment$3$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StClearCountRsp>
{
  QCircleFolderRcmdTabFragment$3$1(QCircleFolderRcmdTabFragment.3 param3) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearCountRsp paramStClearCountRsp)
  {
    paramBaseRequest = new StringBuilder();
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest.append("[sendOuterEntranceRedPointRequest] request success!");
      if (paramStClearCountRsp != null)
      {
        paramBaseRequest.append(", result.retCode: ");
        paramBaseRequest.append(paramStClearCountRsp.result.retCode.get());
        paramBaseRequest.append(", result.msg: ");
        paramBaseRequest.append(paramStClearCountRsp.result.msg.get());
        paramString = paramStClearCountRsp.clearCountRspInfos.get();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramStClearCountRsp = (FeedCloudRead.StClearCountRspInfo)paramString.next();
            if ((paramStClearCountRsp != null) && (paramStClearCountRsp.countType.get() == 1)) {
              EeveeRedpointUtil.saveLastOuterEntranceRedPointClearRspTimestamp(paramStClearCountRsp.clearTime.get());
            }
          }
        }
      }
      paramString = new StringBuilder();
      paramString.append("QCircleEeveeRedPoint_");
      paramString.append(QCircleFolderRcmdTabFragment.B);
      QLog.d(paramString.toString(), 1, new Object[] { paramBaseRequest });
      return;
    }
    paramBaseRequest.append("[sendOuterEntranceRedPointRequest] request error! isSuccess : ");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(", retCode: ");
    paramBaseRequest.append(paramLong);
    if (paramStClearCountRsp != null)
    {
      paramBaseRequest.append(", result.retCode: ");
      paramBaseRequest.append(paramStClearCountRsp.result.retCode.get());
      paramBaseRequest.append(", result.msg: ");
      paramBaseRequest.append(paramStClearCountRsp.result.msg.get());
    }
    paramString = new StringBuilder();
    paramString.append("QCircleEeveeRedPoint_");
    paramString.append(QCircleFolderRcmdTabFragment.B);
    QLog.e(paramString.toString(), 1, new Object[] { paramBaseRequest });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment.3.1
 * JD-Core Version:    0.7.0.1
 */