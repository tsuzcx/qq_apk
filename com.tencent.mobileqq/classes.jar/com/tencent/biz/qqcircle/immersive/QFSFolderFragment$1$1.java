package com.tencent.biz.qqcircle.immersive;

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

class QFSFolderFragment$1$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StClearCountRsp>
{
  QFSFolderFragment$1$1(QFSFolderFragment.1 param1) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearCountRsp paramStClearCountRsp)
  {
    paramBaseRequest = new StringBuilder();
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest.append("[sendClearOuterEntranceRedPointRequest] clear outer red dot success!");
      if (paramStClearCountRsp != null)
      {
        paramBaseRequest.append(", result.retCode: ");
        paramBaseRequest.append(paramStClearCountRsp.result.retCode.get());
        paramBaseRequest.append(", result.msg: ");
        paramBaseRequest.append(paramStClearCountRsp.result.msg.get());
        paramString = paramStClearCountRsp.clearCountRspInfos.get();
        if (paramString != null)
        {
          paramStClearCountRsp = new StringBuilder();
          paramStClearCountRsp.append(", rspInfoList size: ");
          paramStClearCountRsp.append(paramString.size());
          paramBaseRequest.append(paramStClearCountRsp.toString());
          paramString = paramString.iterator();
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            paramStClearCountRsp = (FeedCloudRead.StClearCountRspInfo)paramString.next();
          } while ((paramStClearCountRsp == null) || (paramStClearCountRsp.countType.get() != 1));
          EeveeRedpointUtil.saveLastOuterEntranceRedPointClearRspTimestamp(paramStClearCountRsp.clearTime.get());
        }
        else
        {
          paramBaseRequest.append(", rspInfoList is null!");
        }
      }
      QLog.d("QCircleEeveeRedPoint_QFSFolderFragment", 1, new Object[] { paramBaseRequest });
      return;
    }
    paramBaseRequest.append("[sendClearOuterEntranceRedPointRequest]");
    paramBaseRequest.append(" clear outer red dot error! isSuccess : ");
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
    QLog.e("QCircleEeveeRedPoint_QFSFolderFragment", 1, new Object[] { paramBaseRequest });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSFolderFragment.1.1
 * JD-Core Version:    0.7.0.1
 */