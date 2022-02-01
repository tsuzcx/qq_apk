package com.tencent.biz.qqcircle.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

class QCircleSpecialFollowManager$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  QCircleSpecialFollowManager$1(QCircleSpecialFollowManager paramQCircleSpecialFollowManager, boolean paramBoolean, String paramString) {}
  
  public void a(BaseRequest arg1, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    ??? = new StringBuilder();
    ???.append("doSpecialFollow: isSuccess");
    ???.append(paramBoolean);
    ???.append("retCode:");
    ???.append(paramLong);
    ???.append("    errMsg:");
    ???.append(paramString);
    QLog.d("QCircleSpecialFollowMgr", 1, ???.toString());
    int i;
    if ((paramBoolean) && (paramLong == 0L)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QCircleSpecialFollowManager.a(this.c, "设置失败", false);
      return;
    }
    synchronized (this.c)
    {
      QCircleSpecialFollowManager.a(this.c);
      QCircleSpecialFollowManager.a(this.c, "设置成功", true);
      ??? = QCircleSpecialFollowManager.b(this.c);
      if (this.a) {
        i = 1001;
      } else {
        i = 1002;
      }
      ???.obtainMessage(i, this.b).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.1
 * JD-Core Version:    0.7.0.1
 */