package com.tencent.biz.qqcircle.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

class QCircleSpecialFollowManager$4
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFollowListRsp>
{
  QCircleSpecialFollowManager$4(QCircleSpecialFollowManager paramQCircleSpecialFollowManager, QCircleSpecialFollowManager.MoreInfo paramMoreInfo) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("loadMoreSpecialFollowList: isSuccess");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append("retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("    errMsg:");
    paramBaseRequest.append(paramString);
    QLog.d("QCircleSpecialFollowMgr", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowListRsp != null))
    {
      QCircleSpecialFollowManager.b(this.b).obtainMessage(1004, new QCircleSpecialFollowManager.SpecialFollowListResp(paramStGetFollowListRsp, QCircleSpecialFollowManager.MoreInfo.a(this.a), null)).sendToTarget();
      return;
    }
    QCircleSpecialFollowManager.b(this.b).obtainMessage(1005).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.4
 * JD-Core Version:    0.7.0.1
 */