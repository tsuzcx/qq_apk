package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRight.GetCircleUnCareListRsp;

class QCirclePrivacySettingContentPart$6
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRight.GetCircleUnCareListRsp>
{
  QCirclePrivacySettingContentPart$6(QCirclePrivacySettingContentPart paramQCirclePrivacySettingContentPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((paramGetCircleUnCareListRsp != null) && (paramGetCircleUnCareListRsp.userlist != null))
      {
        paramBaseRequest = new StringBuilder();
        paramBaseRequest.append("UnCareList + updateBlacklistNum= ");
        paramBaseRequest.append(paramGetCircleUnCareListRsp.userlist.size());
        QLog.e("QCirclePrivacySettingContentPart", 1, paramBaseRequest.toString());
        QCirclePrivacySettingContentPart.a(this.a, paramGetCircleUnCareListRsp.userlist.size());
      }
    }
    else
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("UnCareList + retcode= ");
      paramBaseRequest.append(paramLong);
      paramBaseRequest.append("errMsg = ");
      paramBaseRequest.append(paramString);
      QLog.e("QCirclePrivacySettingContentPart", 1, paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.6
 * JD-Core Version:    0.7.0.1
 */