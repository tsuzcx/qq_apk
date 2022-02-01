package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudRead.StClearCountRsp;

class QFSFollowTabFragment$1$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StClearCountRsp>
{
  QFSFollowTabFragment$1$1(QFSFollowTabFragment.1 param1) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StClearCountRsp paramStClearCountRsp)
  {
    paramBaseRequest = new StringBuilder();
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramLong = EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp();
      if (this.a.a > paramLong) {
        EeveeRedpointUtil.saveFollowTabFeedListLastRspTimestamp(this.a.a);
      }
      paramBaseRequest.append("[sendClearFollowTabRedPointRequest] clear outer red dot success!");
      if (paramStClearCountRsp != null)
      {
        paramBaseRequest.append(", result.retCode: ");
        paramBaseRequest.append(paramStClearCountRsp.result.retCode.get());
        paramBaseRequest.append(", result.msg: ");
        paramBaseRequest.append(paramStClearCountRsp.result.msg.get());
      }
      paramBaseRequest.append(", followTabFeedListLastPreRspTimestamp: ");
      paramBaseRequest.append(this.a.a);
      paramBaseRequest.append(", followTabFeedListLastRspTimestamp: ");
      paramBaseRequest.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_QFSFollowTabFragment", 1, new Object[] { paramBaseRequest });
      return;
    }
    paramBaseRequest.append("[sendClearFollowTabRedPointRequest] clear outer red dot error! isSuccess : ");
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
    QLog.e("QCircleEeveeRedPoint_QFSFollowTabFragment", 1, new Object[] { paramBaseRequest });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSFollowTabFragment.1.1
 * JD-Core Version:    0.7.0.1
 */