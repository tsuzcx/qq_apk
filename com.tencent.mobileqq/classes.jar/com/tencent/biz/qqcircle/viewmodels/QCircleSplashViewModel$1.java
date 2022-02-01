package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleSplashViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  QCircleSplashViewModel$1(QCircleSplashViewModel paramQCircleSplashViewModel) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    String str = this.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNewUserPymkPageFeedList onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    if ((paramStGetFeedListRsp != null) && (paramBoolean) && (paramLong == 0L))
    {
      QCircleSplashViewModel.a(this.a, paramStGetFeedListRsp);
      this.a.a.setValue(UIStateData.a(false).a(false, paramStGetFeedListRsp));
      return;
    }
    this.a.a.setValue(UIStateData.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleSplashViewModel.1
 * JD-Core Version:    0.7.0.1
 */