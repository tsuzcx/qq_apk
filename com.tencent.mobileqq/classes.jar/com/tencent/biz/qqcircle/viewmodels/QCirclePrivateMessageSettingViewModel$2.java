package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;

class QCirclePrivateMessageSettingViewModel$2
  implements VSDispatchObserver.onVSRspCallBack<QQCirclePrivateMsgShow.StChangePMSettingRsp>
{
  QCirclePrivateMessageSettingViewModel$2(QCirclePrivateMessageSettingViewModel paramQCirclePrivateMessageSettingViewModel) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgShow.StChangePMSettingRsp paramStChangePMSettingRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("setProfileRequest isSuccess:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.d("QCirclePrivateMessageSettingViewModel", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L) && (paramStChangePMSettingRsp != null))
    {
      this.a.b.setValue(UIStateData.a(false).a(false, paramStChangePMSettingRsp));
      return;
    }
    this.a.b.setValue(UIStateData.a(paramString).a(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePrivateMessageSettingViewModel.2
 * JD-Core Version:    0.7.0.1
 */