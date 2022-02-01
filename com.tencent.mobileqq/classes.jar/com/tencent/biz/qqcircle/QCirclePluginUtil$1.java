package com.tencent.biz.qqcircle;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

final class QCirclePluginUtil$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoLikeRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.d("doubleclicklike", 4, " success");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" failed：");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("doubleclicklike", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((VSDispatchObserver.onVSRspCallBack)localObject).onReceive(paramBaseRequest, paramBoolean, paramLong, paramString, paramStDoLikeRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePluginUtil.1
 * JD-Core Version:    0.7.0.1
 */