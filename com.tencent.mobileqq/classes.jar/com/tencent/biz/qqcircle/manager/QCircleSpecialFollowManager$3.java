package com.tencent.biz.qqcircle.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

class QCircleSpecialFollowManager$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFollowListRsp>
{
  QCircleSpecialFollowManager$3(QCircleSpecialFollowManager paramQCircleSpecialFollowManager, int paramInt) {}
  
  public void a(BaseRequest arg1, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    ??? = new StringBuilder();
    ???.append("updateSpecialFollowList: isSuccess");
    ???.append(paramBoolean);
    ???.append("retCode:");
    ???.append(paramLong);
    ???.append("    errMsg:");
    ???.append(paramString);
    QLog.d("QCircleSpecialFollowMgr", 1, ???.toString());
    synchronized (this.b)
    {
      if (QCircleSpecialFollowManager.c(this.b) != this.a)
      {
        this.b.d();
        return;
      }
      QCircleSpecialFollowManager.a(this.b, false);
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowListRsp != null))
      {
        QCircleSpecialFollowManager.b(this.b).obtainMessage(1003, new QCircleSpecialFollowManager.SpecialFollowListResp(paramStGetFollowListRsp, this.a, null)).sendToTarget();
        return;
      }
      QCircleSpecialFollowManager.b(this.b).obtainMessage(1005).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.3
 * JD-Core Version:    0.7.0.1
 */