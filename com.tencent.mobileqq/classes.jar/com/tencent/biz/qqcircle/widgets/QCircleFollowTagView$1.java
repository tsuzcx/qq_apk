package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.manager.QCircleTagFollowManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleWrite.DoFollowTagRsp;

class QCircleFollowTagView$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleWrite.DoFollowTagRsp>
{
  QCircleFollowTagView$1(QCircleFollowTagView paramQCircleFollowTagView, int paramInt, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleWrite.DoFollowTagRsp paramDoFollowTagRsp)
  {
    boolean bool = false;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.c.a(this.a);
      if (QCircleFollowTagView.a(this.c) != null)
      {
        QCircleFollowTagView.a(this.c.getContext(), QCircleFollowTagView.a(this.c).tagId.get(), this.a);
        paramBaseRequest = QCircleTagFollowManager.a();
        paramString = QCircleFollowTagView.a(this.c).tagId.get();
        paramBoolean = bool;
        if (this.a == 1) {
          paramBoolean = true;
        }
        paramBaseRequest.a(paramString, paramBoolean);
      }
    }
    else
    {
      int i;
      if (this.b) {
        i = 2131895730;
      } else {
        i = 2131895939;
      }
      QCircleToast.a(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowTagView.1
 * JD-Core Version:    0.7.0.1
 */