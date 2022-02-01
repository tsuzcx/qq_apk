package com.tencent.biz.qqcircle.bizparts;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRead.ConfidentCircleMemberRsp;

class QCircleTopAuthPart$3
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRead.ConfidentCircleMemberRsp>
{
  QCircleTopAuthPart$3(QCircleTopAuthPart paramQCircleTopAuthPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRead.ConfidentCircleMemberRsp paramConfidentCircleMemberRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramConfidentCircleMemberRsp != null))
    {
      QLog.e("QCircleTopAuthPart", 1, "confirmCircleMemberShip success!");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("confirmCircleMemberShip error:");
      paramBaseRequest.append(paramString);
      QLog.e("QCircleTopAuthPart", 1, paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart.3
 * JD-Core Version:    0.7.0.1
 */