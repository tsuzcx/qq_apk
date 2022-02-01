package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QFSTopPopBannerPart$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QFSTopPopBannerPart$3(QFSTopPopBannerPart paramQFSTopPopBannerPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null)) {
      QFSTopPopBannerPart.a(this.a, paramStGetFeedDetailRsp.feed);
    }
    QLog.d("QFSTopPopBannerPart", 1, new Object[] { "fetch real feed success:", Boolean.valueOf(paramBoolean), "  retCode code:", Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.3
 * JD-Core Version:    0.7.0.1
 */